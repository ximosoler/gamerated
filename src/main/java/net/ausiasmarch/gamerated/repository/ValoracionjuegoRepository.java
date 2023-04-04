package net.ausiasmarch.gamerated.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import net.ausiasmarch.gamerated.entity.ValoracionjuegoEntity;

public interface ValoracionjuegoRepository extends JpaRepository<ValoracionjuegoEntity, Long> {

    boolean existsById(String id);

    
}
