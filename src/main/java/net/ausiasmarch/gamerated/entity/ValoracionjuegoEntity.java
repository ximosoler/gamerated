package net.ausiasmarch.gamerated.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "valoracionjuego")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class ValoracionjuegoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nota;
 
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_juego")
    private JuegoEntity juego;

    @OneToMany(mappedBy = "valoracionjuego", fetch = FetchType.LAZY)
    private final List<UsuarioEntity> usuario;

    public ValoracionjuegoEntity() {
        this.usuario = new ArrayList<>();
    }

    public ValoracionjuegoEntity(Long id){
        this.id = id;
        this.usuario = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public JuegoEntity getJuego() {
        return juego;
    }

    public void setJuego(JuegoEntity juego) {
        this.juego = juego;
    }

    public int getUsuario() {
        return usuario.size();
    }
    
}
