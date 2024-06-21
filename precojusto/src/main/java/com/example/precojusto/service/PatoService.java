package com.example.precojusto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.precojusto.api.model.CreatePatoRequest;
import com.example.precojusto.repository.PatoRepository;
import com.example.precojusto.repository.model.Pato;

@Service
public class PatoService {
    @Autowired
    private PatoRepository patoRepository;

    public Pato createPato(CreatePatoRequest pato) {
        return patoRepository.save(new Pato(pato.getNome(), pato.getMae()));
    }

}
