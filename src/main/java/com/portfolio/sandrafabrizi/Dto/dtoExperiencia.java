package com.portfolio.sandrafabrizi.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoExperiencia {
    
    @NotBlank
    private String nombreE;
    @NotBlank
    private String areaE;
    @NotBlank
    private String puestoE;
    @NotBlank
    private String mesInicioE;
    @NotBlank
    private String anioInicioE;
  
    private String mesFinE;
    private String anioFinE;
    
    @NotBlank
    private String descripcionE;


    //Constructor
    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String areaE, String puestoE, String mesInicioE, int añoInicioE, String mesFinE, int añoFinE, String descripcionE) {
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
