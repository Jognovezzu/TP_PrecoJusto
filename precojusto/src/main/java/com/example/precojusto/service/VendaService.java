package com.example.precojusto.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.precojusto.repository.ClienteRepository;
import com.example.precojusto.repository.PatoRepository;
import com.example.precojusto.repository.VendaRepository;
import com.example.precojusto.repository.DTO.NotaDTO;
import com.example.precojusto.repository.DTO.ReportProjection;
import com.example.precojusto.repository.model.Cliente;
import com.example.precojusto.repository.model.Pato;
import com.example.precojusto.repository.model.Venda;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private PatoRepository patoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
    
    public NotaDTO DoVenda (Long id_cliente, List<Long> id_patos) {
        Cliente cliente = clienteRepository.findById(id_cliente).orElseThrow();
        List<Pato> patos = patoRepository.findAllById(id_patos);


        double total = 0;
        for (Pato pato : patos) {
            if (pato.getNfilhos() == 0) {
                total += 70;
            } else if (pato.getNfilhos() == 1) {
                total += 50;
            } else if (pato.getNfilhos() == 2) {
                total += 25;
            }
        }

        if (cliente.getDesconto()) {
            total *= 0.8;
        }

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setPatos(patos);
        venda.setDataVenda(LocalDate.now());
        venda.setValorTotal(total);
        
        for (Pato pato : patos) {
            pato.setDisponivel(false);
        }
        vendaRepository.save(venda);

        NotaDTO nota = new NotaDTO();
        nota.setId_venda(venda.getId());
        nota.setId_cliente(cliente.getId());
        nota.setData_venda(venda.getDataVenda());
        nota.setValor_total(venda.getValorTotal());

        return nota;
    
    }

    public List<NotaDTO> getVendas() {
        List<Venda> vendas = vendaRepository.findAll();
        List<NotaDTO> notas = new ArrayList<>();
        for (Venda venda : vendas) {
            NotaDTO nota = new NotaDTO();
            nota.setId_venda(venda.getId());
            nota.setId_cliente(venda.getCliente().getId());
            nota.setData_venda(venda.getDataVenda());
            nota.setValor_total(venda.getValorTotal());
            List<Long> id_patos = new ArrayList<>();
            for (Pato pato : venda.getPatos()) {
                id_patos.add(pato.getId());
            }
            nota.setId_patos(id_patos);
            notas.add(nota);
        }
        return notas;
        
    }

    public List<ReportProjection> makeReport() {
        return vendaRepository.makeReport();
    }
}
