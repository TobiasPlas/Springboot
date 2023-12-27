package com.Springboot.Portafolio.controller;

import com.Springboot.Portafolio.dto.dto_ventaMasAlta;
import com.Springboot.Portafolio.model.Producto;
import com.Springboot.Portafolio.model.Venta;
import com.Springboot.Portafolio.service.IVentaService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    private IVentaService venser;
    
    
    @GetMapping("/ventas")
    public List<Venta> getVentas(){
      List<Venta> list= venser.getVenta();
      return list;
    }
    
    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta venta){
        return venser.saveVenta(venta);
    }
    
   @GetMapping("/ventas/{codigo_venta}")
   public Venta findVenta(@PathVariable Long codigo_venta){
       return venser.findVenta(codigo_venta);
   }
    
   @DeleteMapping("/ventas/eliminar/{codigo_venta}")
   public String deleteVenta(@PathVariable Long codigo_venta){
     return venser.deleteVenta(codigo_venta);
   }
   
   @PutMapping("/ventas/editar/{codigo_venta}")
   public String editVenta(@PathVariable Long codigo_venta,
                            @RequestBody  Venta venta){
       return venser.editVenta(codigo_venta, venta);
   }
   
   @GetMapping("/ventas/productos/{codigo_venta}")
   public List<Producto> productosVenta(@PathVariable Long codigo_venta){
     List<Producto> lista= venser.productosVenta(codigo_venta);
       return lista;
   }
    
   @GetMapping("/ventas/dia/{fecha_venta}")
   public String ventaDia(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha_venta){     
       return venser.ventaDia(fecha_venta);
   }
   
   @GetMapping("/ventas/mayor_venta")
   public dto_ventaMasAlta mayorVenta(){
       return venser.mayorVenta();
   }
   
   
}
