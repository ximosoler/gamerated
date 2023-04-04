package net.ausiasmarch.gamerated.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ausiasmarch.gamerated.entity.ComentariojuegoEntity;

@Repository
public interface ComentariojuegoRepository extends JpaRepository<ComentariojuegoEntity, Long> {

    boolean existsById(String id);

    
}
