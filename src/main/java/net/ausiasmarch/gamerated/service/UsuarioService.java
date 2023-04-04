package net.ausiasmarch.gamerated.service;

import org.springframework.transaction.annotation.Transactional;

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

    private final String GAMERATED_DEFAULT_PASSWORD = "4298f843f830fb3cc13ecdfe1b2cf10f51f929df056d644d1bca73228c5e8f64";

    private final String[] nicks = {"Jose", "Mark", "Elen", "Toni", "Hector", "Joseppe", "Laura", "Vika", "Sergio",
    "Javi", "Marcos", "Pere", "Daniel", "Josfe", "Havi", "Sergio", "Aaron", "Rafa", "Lionel", "Borja", "Ximo", "Mar"};

    public UsuarioEntity get(Long id) {
        return oUsuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id " + id + " not exist"));
    }

    public Long count() {
        return oUsuarioRepository.count();
    }

    public Page<UsuarioEntity> getPage(Pageable oPageable, String strFilter, Long id_tipousuario) {
        Page<UsuarioEntity> oPage = null;

        oPage = oUsuarioRepository.findAll(oPageable);
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
        
        if(RandomHelper.getRandomInt(1, 2) == 1){
            oUsuarioEntity.setTipocuenta("Admin");
        }else{
            oUsuarioEntity.setTipocuenta("User");
        }
        
        return oUsuarioEntity;
    }

    private String generateNick() {
        return nicks[RandomHelper.getRandomInt(0, nicks.length - 1)].toLowerCase();
    }

}
