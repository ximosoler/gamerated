package net.ausiasmarch.gamerated.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "usuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class UsuarioEntity {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nick;
    private String tipocuenta;
 

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pass;
    
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private final List<ValoracionjuegoEntity> valoracionjuego;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private final List<ComentariojuegoEntity> comentariojuego;

    public UsuarioEntity() {
        this.valoracionjuego = new ArrayList<>();
        this.comentariojuego = new ArrayList<>();
    }

    public UsuarioEntity(Long id){
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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipocuenta() {
        return tipocuenta;
    }

    public void setTipocuenta(String tipocuenta) {
        this.tipocuenta = tipocuenta;
    }

    public int getValoracionjuego() {
        return valoracionjuego.size();
    }
    
    public int getComentariojuego() {
        return comentariojuego.size();
    }

}
