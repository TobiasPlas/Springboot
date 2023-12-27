package com.Springboot.Portafolio.service;


import com.Springboot.Portafolio.model.Producto;
import java.util.ArrayList;
import java.util.List;


public interface IProductoService {
    
    public void saveProducto(Producto prod);
    
    public List<Producto> getProducto();
    
    public void deleteProducto(Long codigo_producto);
    
    public Producto findProducto(Long codigo_producto);
    
    public void editProducto (Long codigo_producto ,Producto prod);

    public List<Producto> faltaStock();
    
   
    
}
