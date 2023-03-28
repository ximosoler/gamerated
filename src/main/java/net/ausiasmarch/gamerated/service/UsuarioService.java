package net.ausiasmarch.gamerated.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.ausiasmarch.gamerated.entity.UsuarioEntity;
import net.ausiasmarch.gamerated.exception.ResourceNotFoundException;
import net.ausiasmarch.gamerated.repository.UsuarioRepository;
@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository oUsuarioRepository;

    public UsuarioEntity get(Long id) {
        return oUsuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id " + id + " not exist"));
    }

    public Long count() {
        return oUsuarioRepository.count();
    }

    public Page<UsuarioEntity> getPage(Pageable oPageable, String strFilter, Long id_tipousuario) {
        return null;
    }

    public Long create(UsuarioEntity oNewUserEntity) {
        return null;
    }

    public Long update(UsuarioEntity oUserEntity) {
        return null;
    }

    public Long delete(Long id) {
        return null;
    }

    public UsuarioEntity generate() {
        return null;
    }

    public Object generateSome(Integer amount) {
        return null;
    }

}
