package com.Springboot.Portafolio.controller;

import com.Springboot.Portafolio.model.Cliente;
import com.Springboot.Portafolio.service.IClienteService;
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
public class ClienteController {
    
    @Autowired
    private IClienteService cliser;
    
    
    @GetMapping("/clientes")
    public List<Cliente> getClientes(){
       List<Cliente> list= cliser.getCliente();
       return list;
    }
    
    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente clie){
        cliser.saveCliente(clie);
        return "El cliente se guardo con exito";
    }
    
    @GetMapping("/clientes/{id_cliente}")
    public Cliente findCliente(@PathVariable Long id_cliente){
      return  cliser.findCliente(id_cliente);
    }
    
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        cliser.deleteCliente(id_cliente);
        return "El cliente se elimino con exito";
    }
    
    @PutMapping("/clientes/editar/{id_cliente}")
    public String editCliente(@PathVariable Long id_cliente,
                                @RequestBody Cliente clie){
        cliser.editCliente(id_cliente, clie);
        return "El cliente se elimino con exito";
    }
    
}
