package net.ausiasmarch.gamerated.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ausiasmarch.gamerated.entity.JuegoEntity;
@Repository
public interface JuegoRepository extends JpaRepository<JuegoEntity, Long> {

    boolean existsByTitulo(String titulo);

    
}
