package com.Springboot.Portafolio.service;

import com.Springboot.Portafolio.model.Cliente;
import java.util.List;


public interface IClienteService {
    
       public void saveCliente(Cliente clie);

    public List<Cliente> getCliente();

    public void deleteCliente(Long id);

    public Cliente findCliente(Long id);

    public void editCliente(Long id_cliente,Cliente clie);

    
    
}
