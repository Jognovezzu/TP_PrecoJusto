package com.example.precojusto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.precojusto.repository.model.Venda;

public interface VendaRepository extends JpaRepository <Venda, Long> {
    
}
