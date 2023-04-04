package net.ausiasmarch.gamerated.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ausiasmarch.gamerated.entity.ComentariojuegoEntity;
import net.ausiasmarch.gamerated.exception.ResourceNotFoundException;
import net.ausiasmarch.gamerated.repository.ComentariojuegoRepository;
@Service
public class ComentariojuegoService {

    @Autowired
    ComentariojuegoRepository oComentariojuegoRepository;

    public void validate(Long id) {
        if (!oComentariojuegoRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " doesn't exist");
        }
    }

    public ComentariojuegoEntity get(Long id) {
        return oComentariojuegoRepository.findById(id).get();      
    }

    public Long count() {
        return oComentariojuegoRepository.count();
    }

    public Page<ComentariojuegoEntity> getPage(Pageable oPageable, String strFilter) {
        Page<ComentariojuegoEntity> oPage = null;

        oPage = oComentariojuegoRepository.findAll(oPageable);
        return oPage;
    }



    public Long create(ComentariojuegoEntity oNewComentariojuegoEntity) {
        oNewComentariojuegoEntity.setId(0L);
    /*  oNewComentariojuegoEntity.setTexto();
        oNewComentariojuegoEntity.setFechahora();
        oNewComentariojuegoEntity.setUsuario();
        oNewComentariojuegoEntity.setJuego();
        oNewComentariojuegoEntity.setComentariojuego();*/
        return oComentariojuegoRepository.save(oNewComentariojuegoEntity).getId();
    }

    
    @Transactional
    public Long update(ComentariojuegoEntity oComentariojuegoEntity) {
        validate(oComentariojuegoEntity.getId());
        return oComentariojuegoRepository.save(oComentariojuegoEntity).getId();
    }


    public Long delete(Long id) {
       
      oComentariojuegoRepository.existsById(id);
      oComentariojuegoRepository.deleteById(id);
           
       return id;
            
    }

}
