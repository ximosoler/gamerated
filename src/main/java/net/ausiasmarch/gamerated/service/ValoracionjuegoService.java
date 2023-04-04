package net.ausiasmarch.gamerated.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ausiasmarch.gamerated.entity.ValoracionjuegoEntity;
import net.ausiasmarch.gamerated.exception.ResourceNotFoundException;
import net.ausiasmarch.gamerated.repository.ValoracionjuegoRepository;
@Service
public class ValoracionjuegoService {

    @Autowired
    ValoracionjuegoRepository oValoracionjuegoRepository;

    public void validate(Long id) {
        if (!oValoracionjuegoRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " doesn't exist");
        }
    }

    public ValoracionjuegoEntity get(Long id) {
        return oValoracionjuegoRepository.findById(id).get();      
    }

    public Long count() {
        return oValoracionjuegoRepository.count();
    }

    public Page<ValoracionjuegoEntity> getPage(Pageable oPageable, String strFilter) {
        Page<ValoracionjuegoEntity> oPage = null;

        oPage = oValoracionjuegoRepository.findAll(oPageable);
        return oPage;
    }



    public Long create(ValoracionjuegoEntity oNewValoracionjuegoEntity) {
        oNewValoracionjuegoEntity.setId(0L);
    /*  oNewValoracionjuegoEntity.setTexto();
        oNewValoracionjuegoEntity.setFechahora();
        oNewValoracionjuegoEntity.setUsuario();
        oNewValoracionjuegoEntity.setJuego();
        oNewValoracionjuegoEntity.setComentariojuego();*/
        return oValoracionjuegoRepository.save(oNewValoracionjuegoEntity).getId();
    }

    
    @Transactional
    public Long update(ValoracionjuegoEntity oValoracionjuegoEntity) {
        validate(oValoracionjuegoEntity.getId());
        return oValoracionjuegoRepository.save(oValoracionjuegoEntity).getId();
    }


    public Long delete(Long id) {
       
      oValoracionjuegoRepository.existsById(id);
      oValoracionjuegoRepository.deleteById(id);
           
       return id;
            
    }

}
