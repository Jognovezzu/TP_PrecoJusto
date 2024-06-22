package com.example.precojusto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.precojusto.repository.model.Pato;

public interface PatoRepository extends JpaRepository<Pato, Long> {

    @Query("SELECT p FROM Pato p WHERE p.nome = ?1")
    Pato findByNome(String nome);


    @Query("SELECT p FROM Pato p LEFT JOIN FETCH p.filhos")
    List <Pato> findAllWithFilhos();
}
