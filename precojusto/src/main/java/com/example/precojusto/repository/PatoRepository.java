package com.example.precojusto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.precojusto.repository.model.Pato;

public interface PatoRepository extends JpaRepository<Pato, Long> {
    
}
