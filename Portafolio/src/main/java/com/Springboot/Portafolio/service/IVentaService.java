package com.Springboot.Portafolio.service;

import com.Springboot.Portafolio.dto.dto_ventaMasAlta;
import com.Springboot.Portafolio.model.Producto;
import com.Springboot.Portafolio.model.Venta;
import java.time.LocalDate;
import java.util.List;



public interface IVentaService {

    public String saveVenta(Venta venta);

    public List<Venta> getVenta();

    public String deleteVenta(Long id);

    public Venta findVenta(Long id);

    public String editVenta(Long codigo_venta ,Venta venta);

    public List<Producto> productosVenta(Long codigo_venta);

    public String ventaDia(LocalDate fecha);

    public dto_ventaMasAlta mayorVenta();


    
    
}
