package com.Springboot.Portafolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Setter @Getter
@Entity
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigo_venta;

    private LocalDate fecha_venta;
    private Double total;
    
    @ManyToMany(fetch = FetchType.LAZY)
      @JoinTable(
        name = "venta_producto",
        joinColumns = @JoinColumn(name = "venta_id",referencedColumnName = "codigo_venta"),
        inverseJoinColumns = @JoinColumn(name = "producto_id",referencedColumnName = "codigo_producto")
    )
    private List<Producto> listaProductos = new ArrayList();
    
    
    
    @ManyToOne
    @JoinColumn(name="Cliente",referencedColumnName = "id_cliente")
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, ArrayList<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }



}
