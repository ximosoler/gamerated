package net.ausiasmarch.gamerated.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.gamerated.entity.JuegoEntity;

public interface JuegoRepository extends JpaRepository<JuegoEntity, Long> {

    boolean existsByTitulo(String titulo);

    
}
