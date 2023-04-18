package net.ausiasmarch.gamerated.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "juego")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class JuegoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

    private String titulo;
    private String desarrolladora;
    private String plataforma;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime fechasalida;

    private String genero;
    private int duracion;


    @OneToMany(mappedBy = "juego", fetch = FetchType.LAZY)
    private final List<ValoracionjuegoEntity> valoracionjuego;

    @OneToMany(mappedBy = "juego", fetch = FetchType.LAZY)
    private final List<ComentariojuegoEntity> comentariojuego;


    public JuegoEntity() {
        this.valoracionjuego = new ArrayList<>();
        this.comentariojuego = new ArrayList<>();
    }

    public JuegoEntity(Long id){
        this.id = id;
        this.valoracionjuego = new ArrayList<>();
        this.comentariojuego = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String juegoEntity) {
        this.titulo = juegoEntity;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public LocalDateTime getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(LocalDateTime fechasalida) {
        this.fechasalida = fechasalida;
    }
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getValoracionjuego() {
        return valoracionjuego.size();
    }
    
    public int getComentariojuego() {
        return comentariojuego.size();
    }


    
}
