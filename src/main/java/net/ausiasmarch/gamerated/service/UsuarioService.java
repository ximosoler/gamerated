package net.ausiasmarch.gamerated.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.gamerated.entity.UsuarioEntity;
import net.ausiasmarch.gamerated.exception.ResourceNotFoundException;
import net.ausiasmarch.gamerated.helper.RandomHelper;
import net.ausiasmarch.gamerated.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository oUsuarioRepository;

    public void validate(Long id) {
        if (!oUsuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " not exist");
        }
    }

    private final String GAMERATED_DEFAULT_PASSWORD = "0775f0bfa1657cd14831c856d70fdca1a640a2f2488f515289f112c4701d0a64";

    private final String[] nicks = { "Jose", "Mark", "Elen", "Toni", "Hector", "Joseppe", "Laura", "Vika", "Sergio",
            "Javi", "Marcos", "Pere", "Daniel", "Josfe", "Havi", "Sergio", "Aaron", "Rafa", "Lionel", "Borja", "Ximo",
            "Mar" };

    public UsuarioEntity get(Long id) {
        return oUsuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id " + id + " not exist"));
    }

    public Long count() {
        return oUsuarioRepository.count();
    }

    public Page<UsuarioEntity> getPage(Pageable oPageable, String strFilter, String strTipocuenta) {
        Page<UsuarioEntity> oPage = null;
        if (strFilter == null || strFilter.equals("") || strFilter.trim().equals("")) {
            if (strTipocuenta == null || strTipocuenta.equals("") || strTipocuenta.trim().equals("")) {
                oPage = oUsuarioRepository.findAll(oPageable);
            } else {
                oPage = oUsuarioRepository.findByTipocuentaIgnoreCase(strTipocuenta, oPageable);
            }
        } else {
            if (strTipocuenta == null || strTipocuenta.equals("") || strTipocuenta.trim().equals("")) {
                oPage = oUsuarioRepository.findByNickIgnoreCaseContaining(strFilter, oPageable);
            } else {
                oPage = oUsuarioRepository.findByNickIgnoreCaseContainingAndTipocuentaIgnoreCase(strFilter, strTipocuenta,
                        oPageable);
            }
        }
        return oPage;
    }

    public Long create(UsuarioEntity oNewUsuarioEntity) {
        oNewUsuarioEntity.setId(0L);
        oNewUsuarioEntity.setPass(GAMERATED_DEFAULT_PASSWORD);
        return oUsuarioRepository.save(oNewUsuarioEntity).getId();
    }

    @Transactional
    public Long update(UsuarioEntity oUsuarioEntity) {
        validate(oUsuarioEntity.getId());
        UsuarioEntity oldUserEntity = oUsuarioRepository.findById(oUsuarioEntity.getId()).get();
        oUsuarioEntity.setPass(oldUserEntity.getPass());
        return update4Usuarios(oUsuarioEntity).getId();
    }

    @Transactional
    private UsuarioEntity update4Usuarios(UsuarioEntity oUpdatedUserEntity) {
        UsuarioEntity oUsuarioEntity = oUsuarioRepository.findById(oUpdatedUserEntity.getId()).get();
        oUsuarioEntity.setNick(oUpdatedUserEntity.getNick());
        oUsuarioEntity.setPass(oUpdatedUserEntity.getPass());
        oUsuarioEntity.setTipocuenta(oUpdatedUserEntity.getTipocuenta());
        return oUsuarioRepository.save(oUsuarioEntity);
    }

    public Long delete(Long id) {
        oUsuarioRepository.existsById(id);
        oUsuarioRepository.deleteById(id);
        return id;
    }

    public UsuarioEntity generate() {
        return oUsuarioRepository.save(generateRandomUser());
    }

    private UsuarioEntity generateRandomUser() {

        UsuarioEntity oUsuarioEntity = new UsuarioEntity();
        oUsuarioEntity.setNick(generateNick());
        oUsuarioEntity.setPass(GAMERATED_DEFAULT_PASSWORD);

        if (RandomHelper.getRandomInt(1, 2) == 1) {
            oUsuarioEntity.setTipocuenta("Admin");
        } else {
            oUsuarioEntity.setTipocuenta("User");
        }

        return oUsuarioEntity;
    }

    private String generateNick() {
        return nicks[RandomHelper.getRandomInt(0, nicks.length - 1)].toLowerCase();
    }

    public UsuarioEntity getOneRandom() {        
       
            List<UsuarioEntity> usuarioList = oUsuarioRepository.findAll();
            int iPosicion = RandomHelper.getRandomInt(0, (int) oUsuarioRepository.count() - 1);
            return oUsuarioRepository.getById(usuarioList.get(iPosicion).getId());            
        
    }

}
