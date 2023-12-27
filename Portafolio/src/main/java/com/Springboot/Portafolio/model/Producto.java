package com.Springboot.Portafolio.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_producto;

    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
    
    @ManyToMany(mappedBy = "listaProductos")
    @JsonIgnore
    private List<Venta> listaVentas = new ArrayList() ;

   

    public Producto() { 
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible, ArrayList<Venta> listaVentas) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
        this.listaVentas = listaVentas;
    }

   
}
