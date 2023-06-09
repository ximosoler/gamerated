package net.ausiasmarch.gamerated.entity;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "comentariojuego")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class ComentariojuegoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;


    //private LocalDateTime fechahora;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_juego")
    private JuegoEntity juego;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
/*
    public LocalDateTime getFechahora() {
        return fechahora;
    }

    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }
*/
    public UsuarioEntity getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public JuegoEntity getJuego() {
        return juego;
    }
    public void setJuego(JuegoEntity juego) {
        this.juego = juego;
    }



    
}
