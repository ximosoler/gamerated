package net.ausiasmarch.gamerated.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.ausiasmarch.gamerated.entity.JuegoEntity;
import net.ausiasmarch.gamerated.repository.JuegoRepository;
import net.ausiasmarch.gamerated.exception.ResourceNotFoundException;

@Service
public class JuegoService {

    @Autowired
    JuegoRepository oJuegoRepository;

    public void validate(Long id) {
        if (!oJuegoRepository.existsById(id)) {
            throw new ResourceNotFoundException("id " + id + " not exist");
        }
    }

    public JuegoEntity get(Long id) {
        return oJuegoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("id " + id + " not exist"));
    }

    public Long count() {
        return oJuegoRepository.count();
    }

    public Page<JuegoEntity> getPage(Pageable oPageable, String strFilter) {
        Page<JuegoEntity> oPage = null;

        oPage = oJuegoRepository.findAll(oPageable);
        return oPage;
    }

    public Long create(JuegoEntity oNewJuegoEntity) {
        oNewJuegoEntity.setId(0L);
       /* oNewJuegoEntity.setTitulo();
        oNewJuegoEntity.setDesarrolladora();
        oNewJuegoEntity.setPlataforma();
        oNewJuegoEntity.setFechasalida();
        oNewJuegoEntity.setGenero();
        oNewJuegoEntity.setDuracion();*/

        return oJuegoRepository.save(oNewJuegoEntity).getId();
    } 
    
    @Transactional
    public Long update(JuegoEntity oJuegoEntity) {
        validate(oJuegoEntity.getId());
        JuegoEntity oldJuegoEntity = oJuegoRepository.findById(oJuegoEntity.getId()).get();
        oJuegoEntity.setTitulo(oldJuegoEntity.getTitulo());
        oJuegoEntity.setDesarrolladora(oldJuegoEntity.getDesarrolladora());
        oJuegoEntity.setPlataforma(oldJuegoEntity.getPlataforma());
        oJuegoEntity.setFechasalida(oldJuegoEntity.getFechasalida());
        oJuegoEntity.setGenero(oldJuegoEntity.getGenero());
        oJuegoEntity.setDuracion(oldJuegoEntity.getDuracion());

        return updateJuegos(oJuegoEntity).getId();
    }

    @Transactional
    private JuegoEntity updateJuegos(JuegoEntity oUpdatedJuegoEntity) {
        JuegoEntity oJuegoEntity = oJuegoRepository.findById(oUpdatedJuegoEntity.getId()).get();
        oJuegoEntity.setTitulo(oUpdatedJuegoEntity.getTitulo());
        oJuegoEntity.setDesarrolladora(oUpdatedJuegoEntity.getDesarrolladora());
        oJuegoEntity.setPlataforma(oUpdatedJuegoEntity.getPlataforma());
        oJuegoEntity.setFechasalida(oUpdatedJuegoEntity.getFechasalida());
        oJuegoEntity.setGenero(oUpdatedJuegoEntity.getGenero());
        oJuegoEntity.setDuracion(oUpdatedJuegoEntity.getDuracion());     
        return oJuegoRepository.save(oJuegoEntity);
    }

    public Long delete(Long id) {
        oJuegoRepository.existsById(id);
        oJuegoRepository.deleteById(id);
        return id;
    }}