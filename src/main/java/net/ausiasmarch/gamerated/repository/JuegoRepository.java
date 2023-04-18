package net.ausiasmarch.gamerated.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import net.ausiasmarch.gamerated.entity.JuegoEntity;

public interface JuegoRepository extends JpaRepository<JuegoEntity, Long> {

    boolean existsById(int id);
    Page<JuegoEntity> findByTituloIgnoreCaseContaining(String titulo, Pageable oPageable);
    /*Page<JuegoEntity> findByDesarrolladoraIgnoreCaseContaining(String desarrolladora, Pageable oPageable);
    Page<JuegoEntity> findByPlataformaIgnoreCaseContaining(String plataforma, Pageable oPageable);
    Page<JuegoEntity> findByFechasalidaIgnoreCaseContaining(String fechasalida, Pageable oPageable);
    Page<JuegoEntity> findByGeneroIgnoreCaseContaining(String genero, Pageable oPageable);
    Page<JuegoEntity> findByDuracionIgnoreCaseContaining(int duracion, Pageable oPageable);
    Page<JuegoEntity> findByDesarrolladoraIgnoreCaseContainingAndPlataformaIgnoreCaseContaining(String desarrolladora,String plataforma, Pageable oPageable);
    Page<JuegoEntity> findByDesarrolladoraIgnoreCaseContainingAndGeneroIgnoreCaseContaining(String desarrolladora,String genero, Pageable oPageable);
    Page<JuegoEntity> findByPlataformaIgnoreCaseContainingAndGeneroIgnoreCaseContaining(String plataforma,String genero, Pageable oPageable); */


    
}
