package com.portfolio.sandrafabrizi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Proyectos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private String descripcionP;
    private String mesInicioP;
    private String anioInicioP;
    private String mesFinP;
    private String anioFinP;
    private String verP;
    private String repoP;
    
    //Constructor

    public Proyectos() {
    }

    public Proyectos(String nombreP, String descripcionP, String mesInicioP, String anioInicioP, String mesFinP, String anioFinP, String verP, String repoP) {
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.mesInicioP = mesInicioP;
        this.anioInicioP = anioInicioP;
        this.mesFinP = mesFinP;
        this.anioFinP = anioFinP;
        this.verP = verP;
        this.repoP = repoP;
    }
}
