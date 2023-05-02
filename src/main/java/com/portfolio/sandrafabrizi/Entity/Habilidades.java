package com.portfolio.sandrafabrizi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Habilidades {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreH;
    private int porcentajeH;
    
    //Constructor
    
    public Habilidades() {
    }

    public Habilidades(String nombreH, int porcentajeH) {
        this.nombreH = nombreH;
        this.porcentajeH = porcentajeH;
    }
    
}
