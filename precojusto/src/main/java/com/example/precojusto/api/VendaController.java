package com.example.precojusto.api;

import org.springframework.web.bind.annotation.RestController;

import com.example.precojusto.repository.DTO.NotaDTO;
import com.example.precojusto.repository.DTO.VendaDTO;
import com.example.precojusto.service.VendaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api/v1/venda/")

public class VendaController {
    @Autowired
    private VendaService VendaService;
    
    //Rota para fazer uma venda
    @PostMapping
    public NotaDTO DoVenda(@RequestBody VendaDTO venda ) {
        return VendaService.DoVenda(venda.getId_cliente(), venda.getId_patos());

    }

    //Rota para pegar todas as vendas
    @GetMapping
    public List<NotaDTO> getVendas() {
        return VendaService.getVendas();
    }
    
    
}
