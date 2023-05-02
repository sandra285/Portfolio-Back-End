package com.portfolio.sandrafabrizi.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyectos {
    
    @NotBlank
    private String nombreP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String mesInicioP;
    @NotBlank
    private String anioInicioP;
    private String mesFinP;
    private String anioFinP;
    private String verP;
    private String repoP;
    
    //Constructores

    public dtoProyectos() {
    }

    public dtoProyectos(String nombreP, String descripcionP, String mesInicioP, String anioInicioP, String mesFinP, String anioFinP, String verP, String repoP) {
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
