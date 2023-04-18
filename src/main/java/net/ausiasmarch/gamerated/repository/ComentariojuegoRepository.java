package net.ausiasmarch.gamerated.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import net.ausiasmarch.gamerated.entity.ComentariojuegoEntity;


public interface ComentariojuegoRepository extends JpaRepository<ComentariojuegoEntity, Long> {

    boolean existsById(int id);
    Page<ComentariojuegoEntity> findByTextoIgnoreCaseContaining(String texto, Pageable oPageable);
/* Page<ComentariojuegoEntity> findByFechahoraIgnoreCaseContaining(String fechahora, Pageable oPageable);
    Page<ComentariojuegoEntity> findByUsuarioIgnoreCaseContaining(int id_usuario, Pageable oPageable);
    Page<ComentariojuegoEntity> findByJuegoIgnoreCaseContaining(int id_juego, Pageable oPageable);
    Page<ComentariojuegoEntity> findByComentarioIgnoreCaseContaining(int id_comentariojuego, Pageable oPageable);
    Page<ComentariojuegoEntity> findByUsuarioIgnoreCaseContainingAndJuegoIgnoreCaseContaining(int id_usuario, int id_juego, Pageable oPageable);*/ 

}
