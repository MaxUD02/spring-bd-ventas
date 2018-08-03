package com.parachutes.springsqliteventas.controller;

import com.parachutes.springsqliteventas.business.ClienteBusiness;
import com.parachutes.springsqliteventas.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteBusiness clienteBusiness;

    @GetMapping("/cliente")
    public List<Cliente> getAllClientes(){
        return clienteBusiness.getAllClientes();
    }

    @GetMapping("/cliente/{codigoCliente}")
    public Cliente getClienteById(@PathVariable int codigoCliente){
        return clienteBusiness.getClienteById(codigoCliente);
    }

    @PostMapping("/cliente")
    public Cliente insertCliente(@RequestBody Cliente cliente){
        int codigoCliente = clienteBusiness.insertCliente(cliente);
        cliente.setIdCliente(codigoCliente);
        return cliente;
    }

    @PutMapping("/cliente")
    public Cliente updateCliente(@RequestBody Cliente cliente){
        clienteBusiness.updateCliente(cliente);
        return cliente;
    }

    @DeleteMapping("/cliente/{codigoCliente}")
    public Cliente deleteCliente(@PathVariable int codigoCliente){
        Cliente clienteAEliminar = clienteBusiness.getClienteById(codigoCliente);
        clienteBusiness.deleteCliente(codigoCliente);
        return clienteAEliminar;
    }

}
