package com.portfolio.sandrafabrizi.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoHabilidades {
    
    @NotBlank
    private String nombreH;
    @NotBlank
    private int porcentajeH;
    
    public dtoHabilidades() {
    }

    public dtoHabilidades(String nombreH, int porcentajeH) {
        this.nombreH = nombreH;
        this.porcentajeH = porcentajeH;
    }
    
}
