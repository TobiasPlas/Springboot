
package com.Springboot.Portafolio.service;

import com.Springboot.Portafolio.model.Cliente;
import com.Springboot.Portafolio.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicio implements IClienteService {

    @Autowired
    private ClienteRepository clirep;
    
    
    @Override
    public void saveCliente(Cliente clie) {
        clirep.save(clie);      
    }

    @Override
    public List<Cliente> getCliente() {
        List<Cliente> lista=clirep.findAll();
        return lista;
    }

    @Override
    public void deleteCliente(Long id) {
        clirep.deleteById(id);
    }

    @Override
    public Cliente findCliente(Long id) {
       return clirep.findById(id).orElse(null);
    }

    @Override
    public void editCliente(Long id_cliente, Cliente clie) {
        //Buscamos el producto que queremos editar
        Cliente cli=this.findCliente(id_cliente);
        //Le asignamos los valores recibidos 
        cli.setApellido(clie.getApellido());
        cli.setDni(clie.getDni());
        cli.setNombre(clie.getNombre());
        
         //Guardamos el producto con los valores cambiados
         this.saveCliente(cli);
       
    }

   
    
}
