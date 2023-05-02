package com.portfolio.sandrafabrizi.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoFormacion {
    
    @NotBlank
    private String nombreF;
    @NotBlank
    private String tituloF;
    @NotBlank
    private String mesInicioF;
    @NotBlank
    private String anioInicioF;
    private String mesFinF;
    private String anioFinF;
    
    //Constructor

    public dtoFormacion() {
    }

    public dtoFormacion(String nombreF, String tituloF, String mesInicioF, String anioInicioF, String mesFinF, String anioFinF) {
        this.nombreF = nombreF;
        this.tituloF = tituloF;
        this.mesInicioF = mesInicioF;
        this.anioInicioF = anioInicioF;
        this.mesFinF = mesFinF;
        this.anioFinF = anioFinF;
    }
}
