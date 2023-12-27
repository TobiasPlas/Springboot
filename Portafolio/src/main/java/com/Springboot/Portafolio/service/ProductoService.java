package com.Springboot.Portafolio.service;

import com.Springboot.Portafolio.model.Producto;
import com.Springboot.Portafolio.repository.ProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private ProductoRepository prodrep;

    @Override
    public void saveProducto(Producto prod) {
        prodrep.save(prod);
    }

    @Override
    public List<Producto> getProducto() {
        List<Producto> listaProd = prodrep.findAll();
        return listaProd;
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        prodrep.deleteById(codigo_producto);
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        //Buscamos el producto en la base de datos,si no lo encuentra devuelve null
        return prodrep.findById(codigo_producto).orElse(null);
    }

    @Override
    public void editProducto(Long codigo_producto, Producto prod) {
        //Buscamos el producto que queremos editar
        Producto proedit = this.findProducto(codigo_producto);

        //Le asignamos los valores recibidos 
        proedit.setCantidad_disponible(prod.getCantidad_disponible());
        proedit.setCosto(prod.getCosto());
        proedit.setMarca(prod.getMarca());
        proedit.setNombre(prod.getNombre());

        //Guardamos el producto con los valores cambiados
        this.saveProducto(proedit);
    }

    @Override
    public List<Producto> faltaStock() {
        //traemos todos los productos
        List<Producto> lista = this.getProducto();
        List<Producto> faltaStock = new ArrayList();
       
        //recorremos la lista de todos los productos
        for(Producto e :lista){
            //verificamos que productos quedan menos de 5 en stock
            if(e.getCantidad_disponible()<5){
              faltaStock.add(e);
            }
        }  
        return faltaStock;
    }
    
}
