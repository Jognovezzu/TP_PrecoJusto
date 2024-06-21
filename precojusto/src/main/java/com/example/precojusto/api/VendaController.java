package com.example.precojusto.api;

import org.springframework.web.bind.annotation.RestController;

import com.example.precojusto.repository.model.Venda;
import com.example.precojusto.service.VendaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api/v1/venda")

public class VendaController {
    @Autowired
    private VendaService VendaService;
    
    @PostMapping
    public Venda DoVenda(@RequestParam Long id_cliente, @RequestParam List<Long> id_patos) {
        return VendaService.DoVenda(id_cliente, id_patos);

    }

    @GetMapping
    public List<Venda> getVendas() {
        return VendaService.getVendas();
    }
    
    
}
