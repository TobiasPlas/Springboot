package com.Springboot.Portafolio.service;


import com.Springboot.Portafolio.dto.dto_ventaMasAlta;
import com.Springboot.Portafolio.model.Producto;
import com.Springboot.Portafolio.model.Venta;
import com.Springboot.Portafolio.repository.VentaRepository;
import java.time.LocalDate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private VentaRepository venrepo;
  


    @Override
    public List<Venta> getVenta() {
    List<Venta> list=  venrepo.findAll();
    return list;
    }

    @Override
    public String deleteVenta(Long id) {
        venrepo.deleteById(id);
        return"Venta eliminada correctamente";
    }

    @Override
    public Venta findVenta(Long id) {
      return  venrepo.findById(id).orElse(null);
    }

    @Override
    public String editVenta(Long codigo_venta,Venta venta) {
        //Buscamos el producto que queremos editar
        Venta ven = this.findVenta(codigo_venta);
        //Le asignamos los valores recibidos 
        ven.setFecha_venta(venta.getFecha_venta());
        ven.setListaProductos(venta.getListaProductos());
        ven.setTotal(venta.getTotal());
        ven.setUnCliente(venta.getUnCliente());
        //Guardamos el producto con los valores cambiados
        venrepo.save(ven);
        return "La venta se edito con exito";
    }



    @Override
    public String saveVenta(Venta venta) {
        //Traemos la lista de productos de la venta 
        List<Producto> listaprod = venta.getListaProductos();
        
      Double sum=0.0;
//        recorremos la lista sumando los costos de los productos 
//        para obtener el total
        for(Producto e : venta.getListaProductos()){
            
            sum+=e.getCosto();
        }
       venta.setTotal(sum);
        //guardamos la fecha al momento de la venta
        venta.setFecha_venta(LocalDate.now());
        //se guarda en la base de datos
        venrepo.save(venta);
        return "el resultado es"+sum;
    }

    @Override
    public List<Producto> productosVenta(Long codigo_venta) {
        //buscamos la venta especificada 
        Venta venta = this.findVenta(codigo_venta);
        //devolvemos la lista de sus productos
        return venta.getListaProductos();
   }

    @Override
    public String ventaDia(LocalDate fecha) {
        List<Venta> lista= this.getVenta();
        Double total=0.0;
        int cantVenta=0;
        for(Venta e: lista){
            if(e.getFecha_venta().equals(fecha)){
                total+=e.getTotal();
                cantVenta+=1;
            }
            
        }
        String rta="La cantidad de ventas en la fecha de "+ fecha +" es de: "
                +cantVenta+". Monto total de todas las ventas: "+total;
        return rta;
    }

    @Override
    public dto_ventaMasAlta mayorVenta() {
        List<Venta> list=this.getVenta();
        Double costoVenta=0.0;
        dto_ventaMasAlta vent= new dto_ventaMasAlta();
        System.out.println(list);
        for(Venta e: list){
            if(e.getTotal()>costoVenta){
                vent.setApellidoClie(e.getUnCliente().getApellido());
                System.out.println(e.getUnCliente().getApellido());
                vent.setNombreClie(e.getUnCliente().getNombre());
                System.out.println(e.getUnCliente().getNombre());
                vent.setCan_productos(e.getListaProductos().size());
                System.out.println(e.getListaProductos().size());
                vent.setCodigo_venta(e.getCodigo_venta());
                System.out.println(e.getCodigo_venta());
                vent.setTotal(e.getTotal());
              costoVenta=e.getTotal();
            }
        }
        return vent;
    }

 
    
    
    
}
