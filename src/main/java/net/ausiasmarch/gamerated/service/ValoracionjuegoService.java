package net.ausiasmarch.gamerated.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ausiasmarch.gamerated.entity.ValoracionjuegoEntity;
import net.ausiasmarch.gamerated.exception.ResourceNotFoundException;
import net.ausiasmarch.gamerated.helper.RandomHelper;
import net.ausiasmarch.gamerated.repository.ValoracionjuegoRepository;
@Service
public class ValoracionjuegoService {

    @Autowired
    ValoracionjuegoRepository oValoracionjuegoRepository;

    @Autowired
    UsuarioService oUsuarioService;

    @Autowired
    JuegoService oJuegoService;

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

    public Page<ValoracionjuegoEntity> getPage(Pageable oPageable, String strFilter, int id_usuario, int id_juego, int nota) {
        Page<ValoracionjuegoEntity> oPage = null;
        if (strFilter == null || strFilter.isEmpty() || strFilter.trim().isEmpty()) {
            oPage = oValoracionjuegoRepository.findAll(oPageable);
        } else {
            oPage = oValoracionjuegoRepository.findByUsuarioIgnoreCaseContaining(id_usuario, oPageable);
        }
        
        return oPage;
    }



    public Long create(ValoracionjuegoEntity oValoracionjuegoEntity) {
        oValoracionjuegoEntity.setId(0L);
        return oValoracionjuegoRepository.save(oValoracionjuegoEntity).getId();
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
    public ValoracionjuegoEntity generate() {
        return oValoracionjuegoRepository.save(generateRandomValoracion());
    }

    private ValoracionjuegoEntity generateRandomValoracion() {

        ValoracionjuegoEntity oValoracionjuegoEntity = new ValoracionjuegoEntity();
        oValoracionjuegoEntity.setUsuario(oUsuarioService.getOneRandom());
        oValoracionjuegoEntity.setJuego(oJuegoService.getOneRandom());
        oValoracionjuegoEntity.setNota(RandomHelper.getRandomInt(0, 10));
       

        
        return oValoracionjuegoEntity;
    }
}


