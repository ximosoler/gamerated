package net.ausiasmarch.gamerated.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.ausiasmarch.gamerated.entity.ValoracionjuegoEntity;
@Repository
public interface ValoracionjuegoRepository extends JpaRepository<ValoracionjuegoEntity, Long> {

    boolean existsById(String id);

    
}
