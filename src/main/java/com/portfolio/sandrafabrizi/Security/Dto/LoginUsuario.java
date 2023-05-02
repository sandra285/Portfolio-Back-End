package com.portfolio.sandrafabrizi.Security.Dto;

import javax.validation.constraints.NotBlank;

public class LoginUsuario {
    
    @NotBlank
    private String nombreUsuario;
    
    @NotBlank
    private String password;
    
    //Getter y setter

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
