package com.Springboot.Portafolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dto_ventaMasAlta {
     
   private Long codigo_venta;
   private Double total;
   private int can_productos;
   private String nombreClie;
   private String apellidoClie;

    public dto_ventaMasAlta() {
    }

    public dto_ventaMasAlta(Long codigo_venta, Double total, int can_productos, String nombreClie, String apellidoClie) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.can_productos = can_productos;
        this.nombreClie = nombreClie;
        this.apellidoClie = apellidoClie;
    }
   
    
}
