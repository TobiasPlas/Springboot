package com.Springboot.Portafolio.controller;

import com.Springboot.Portafolio.model.Producto;
import com.Springboot.Portafolio.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService prodser;
    
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto prod){
        prodser.saveProducto(prod);
        
        return "El producto se guardo con exito";
    }
       
    @GetMapping("/productos")
    public List<Producto> getProductos(){
       List<Producto>lista= prodser.getProducto();
       return lista;
    }
    
    @GetMapping("/productos/{codigo_producto}")
    public Producto findProducto(@PathVariable Long codigo_producto){
     Producto prod= prodser.findProducto(codigo_producto);
     return prod;
    }
    
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto){
        prodser.deleteProducto(codigo_producto);
        return "El producto se elimino con exito";
    }
    
    @PutMapping("/productos/editar/{codigo_producto}")
    public void editProducto(@PathVariable Long codigo_producto,@RequestBody Producto produ){
       prodser.editProducto(codigo_producto, produ);
    }
    
    @GetMapping("/productos/stock")
    public List<Producto> faltaStock(){
      List<Producto> lista=  prodser.faltaStock();
     return lista;       
    }
    
    
}
