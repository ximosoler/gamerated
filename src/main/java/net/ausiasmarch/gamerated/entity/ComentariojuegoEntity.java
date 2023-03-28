package net.ausiasmarch.gamerated.entity;


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
    private String fechahora;
 
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_usuario")
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_juego")
    private JuegoEntity juego;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_comentariojuego")
    private ComentariojuegoEntity comentariojuego;

 


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

    public String getFechahora() {
        return fechahora;
    }

    public void setFechahora(String fechahora) {
        this.fechahora = fechahora;
    }

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

    public ComentariojuegoEntity getComentariojuego() {
        return comentariojuego;
    }
    public void setComentariojuego(ComentariojuegoEntity comentariojuego) {
        this.comentariojuego = comentariojuego;
    }

    
}
