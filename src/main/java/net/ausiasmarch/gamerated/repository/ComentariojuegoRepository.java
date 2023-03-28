package net.ausiasmarch.gamerated.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.gamerated.entity.ComentariojuegoEntity;

public interface ComentariojuegoRepository extends JpaRepository<ComentariojuegoEntity, Long> {

    boolean existsById(String id);

    
}
