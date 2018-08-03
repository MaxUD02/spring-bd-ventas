package com.parachutes.springsqliteventas.business;


import com.parachutes.springsqliteventas.model.Cliente;
import com.parachutes.springsqliteventas.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteBusiness {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes(){
        return clienteRepository.getAllClientes();
    }

    public Cliente getClienteById(int codigoCliente){
        return clienteRepository.getClienteById(codigoCliente);
    }

    public int insertCliente(Cliente cliente){
        return clienteRepository.insertCliente(cliente);
    }

    public int updateCliente(Cliente cliente){
        return clienteRepository.updateCliente(cliente);
    }

    public int deleteCliente(int codigoCliente){
        return clienteRepository.deleteCliente(codigoCliente);
    }
}
