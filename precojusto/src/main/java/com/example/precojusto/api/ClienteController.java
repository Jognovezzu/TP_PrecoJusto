package com.example.precojusto.api;

import org.springframework.web.bind.annotation.RestController;


import com.example.precojusto.repository.model.Cliente;
import com.example.precojusto.service.ClienteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @PostMapping
    public Cliente createCliente(@RequestBody Cliente cliente) {
        
        return clienteService.createCliente(cliente);
    }

    @GetMapping
    public List <Cliente> getAllCliente() {
        return clienteService.getAllClientes();
    }
    
    
    
}
