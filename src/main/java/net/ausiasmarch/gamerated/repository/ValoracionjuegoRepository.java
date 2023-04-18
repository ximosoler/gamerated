package net.ausiasmarch.gamerated.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import net.ausiasmarch.gamerated.entity.ValoracionjuegoEntity;

public interface ValoracionjuegoRepository extends JpaRepository<ValoracionjuegoEntity, Long> {

    boolean existsById(int id);
    Page<ValoracionjuegoEntity> findByUsuarioIgnoreCaseContaining(int id_usuario, Pageable oPageable);
    /*Page<ValoracionjuegoEntity> findByJuegoIgnoreCaseContaining(int id_juego, Pageable oPageable);
    Page<ValoracionjuegoEntity> findByNotaIgnoreCaseContaining(int nota, Pageable oPageable);
    Page<ValoracionjuegoEntity> findByUsuarioIgnoreCaseContainingAndJuegoIgnoreCaseContaining(int id_usuario,int id_juego, Pageable oPageable);
    Page<ValoracionjuegoEntity> findByJuegoIgnoreCaseContainingAndNotaIgnoreCaseContaining(int id_juego,int nota, Pageable oPageable);*/


    
}
