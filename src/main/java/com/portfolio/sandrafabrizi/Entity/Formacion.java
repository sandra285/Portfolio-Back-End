package com.portfolio.sandrafabrizi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Formacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreF;
    private String tituloF;
    private String mesInicioF;
    private String anioInicioF;
    private String mesFinF;
    private String anioFinF;
    
    //Constructor

    public Formacion() {
    }

    public Formacion(String nombreF, String tituloF, String mesInicioF, String anioInicioF, String mesFinF, String anioFinF) {
        this.nombreF = nombreF;
        this.tituloF = tituloF;
        this.mesInicioF = mesInicioF;
        this.anioInicioF = anioInicioF;
        this.mesFinF = mesFinF;
        this.anioFinF = anioFinF;
    }
}
