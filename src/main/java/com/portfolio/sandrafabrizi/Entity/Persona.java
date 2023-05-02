package com.portfolio.sandrafabrizi.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "El texto no cumple con la longitud")
    private String nombre;
    
    private String segnombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "El texto no cumple con la longitud")
    private String apellido;
    
    @Size(min = 1, max = 255, message = "El texto no cumple con la longitud")
    private String img;
    
    @NotNull
    @Size(min = 1, max = 50, message = "El texto no cumple con la longitud")
    private String titulo1;
    
    private String titulo2;
    
    @NotNull
    @Size(min = 1, max = 255, message = "El texto no cumple con la longitud")
    private String sobremi;
    
    @NotNull
    @Size(min = 1, max = 50, message = "El texto no cumple con la longitud")
    private String ciudad;
    
    @NotNull
    @Size(min = 1, max = 50, message = "El texto no cumple con la longitud")
    private String provincia;
     
    @NotNull
    @Size(min = 1, max = 50, message = "El texto no cumple con la longitud")
    private String pais;
    
    //Constructor
    
    public Persona() {
    }

    public Persona(String nombre, String segnombre, String apellido, String img, String titulo1, String titulo2, String sobremi, String ciudad, String provincia, String pais) {
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

