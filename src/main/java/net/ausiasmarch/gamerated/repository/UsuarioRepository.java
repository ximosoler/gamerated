package net.ausiasmarch.gamerated.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.gamerated.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    boolean existsByNick(String nick);

    
}
