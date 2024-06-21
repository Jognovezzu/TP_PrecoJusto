package com.example.precojusto.api;

import org.springframework.web.bind.annotation.RestController;

import com.example.precojusto.api.model.CreatePatoRequest;
import com.example.precojusto.repository.model.Pato;
import com.example.precojusto.service.PatoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1/pato")
public class PatoController {
    private final PatoService patoService;

    public PatoController( PatoService patoService){
        this.patoService = patoService;
    }

    @PostMapping
    public Pato postMethodName(@RequestBody CreatePatoRequest pato) {
        
        return patoService.createPato(pato);
    }
    
}
