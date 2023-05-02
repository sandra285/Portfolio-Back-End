package com.portfolio.sandrafabrizi.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoPersona {
   
    @NotBlank
    private String nombre;
    private String segnombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String img;
    @NotBlank
    private String titulo1;
    private String titulo2;
    @NotBlank
    private String sobremi;
    @NotBlank
    private String ciudad;
    @NotBlank
    private String provincia;
    @NotBlank
    private String pais;
    
    //Constructor

    public dtoPersona() {
    }

    public dtoPersona(String nombre, String segnombre, String apellido, String img, String titulo1, String titulo2, String sobremi, String ciudad, String provincia, String pais) {
        this.nombre = nombre;
        this.segnombre = segnombre;
        this.apellido = apellido;
        this.img = img;
        this.titulo1 = titulo1;
        this.titulo2 = titulo2;
        this.sobremi = sobremi;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
    }
    
    
}
