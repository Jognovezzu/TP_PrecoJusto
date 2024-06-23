package com.example.precojusto.api;

import org.springframework.web.bind.annotation.RestController;

import com.example.precojusto.api.model.CreatePatoRequest;
import com.example.precojusto.repository.DTO.PatoDTO;
import com.example.precojusto.repository.DTO.PatoVendidoProjection;
import com.example.precojusto.service.PatoService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/pato/")
public class PatoController {
    private final PatoService patoService;

    public PatoController( PatoService patoService){
        this.patoService = patoService;
    }

    @PostMapping
    public String create(@RequestBody CreatePatoRequest pato) {
        return patoService.createPato(pato);
    }

    @GetMapping("/{id}")
    public PatoDTO getPatoById(@PathVariable Long id) {
        return patoService.getPatoById(id);
    }
    

    @GetMapping
    public ResponseEntity<List<PatoDTO>> getAll(){
        List <PatoDTO> patos = patoService.getAll();
        return ResponseEntity.ok(patos);
    }

    @GetMapping("/vendidos/")
    public ResponseEntity<List<PatoVendidoProjection>> getVendidos(){
        List <PatoVendidoProjection> patos = patoService.getVendidos();
        return ResponseEntity.ok(patos);
    }
    
    
}
