package net.ausiasmarch.gamerated.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import net.ausiasmarch.gamerated.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    boolean existsByNick(String nick);

    Page<UsuarioEntity> findByNickIgnoreCaseContaining(String nick, Pageable oPageable);

    Page<UsuarioEntity> findByTipocuentaIgnoreCase(String tipocuenta, Pageable oPageable);

    Page<UsuarioEntity> findByNickIgnoreCaseContainingAndTipocuentaIgnoreCase(String nick, String tipocuenta,
            Pageable oPageable);

}
