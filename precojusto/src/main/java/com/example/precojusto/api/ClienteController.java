package com.example.precojusto.api;

import org.springframework.web.bind.annotation.RestController;


import com.example.precojusto.repository.model.Cliente;
import com.example.precojusto.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente postMethodName(@RequestBody Cliente cliente) {
        
        return clienteService.createCliente(cliente);
    }
    
    
}
