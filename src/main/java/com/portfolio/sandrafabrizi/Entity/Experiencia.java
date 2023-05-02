package com.portfolio.sandrafabrizi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experiencia {   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String areaE;
    private String puestoE;
    private String mesInicioE;
    private String anioInicioE;
    private String mesFinE;
    private String anioFinE;
    private String descripcionE;
    
    //Constructor
    public Experiencia() {
    }

    public Experiencia(String nombreE, String areaE, String puestoE, String mesInicioE, String anioInicioE, String mesFinE, String anioFinE, String descripcionE) {
        this.nombreE = nombreE;
        this.areaE = areaE;
        this.puestoE = puestoE;
        this.mesInicioE = mesInicioE;
        this.anioInicioE = anioInicioE;
        this.mesFinE = mesFinE;
        this.anioFinE = anioFinE;
        this.descripcionE = descripcionE;
    }
    
}
