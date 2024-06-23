package com.example.precojusto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.precojusto.repository.DTO.PatoVendidoProjection;
import com.example.precojusto.repository.model.Pato;

public interface PatoRepository extends JpaRepository<Pato, Long> {

    @Query("SELECT p FROM Pato p WHERE p.nome = ?1")
    Pato findByNome(String nome);


    @Query("SELECT p FROM Pato p LEFT JOIN FETCH p.filhos")
    List <Pato> findAllWithFilhos();

    @Query(value = "SELECT p.nome AS nome_pato, v.data_venda, c.nome AS nome_cliente " +
                    "FROM venda_patos vp " +
                    "JOIN pato p ON vp.id_pato = p.id " +
                    "JOIN venda v ON vp.id_venda = v.id " +
                    "JOIN cliente c ON v.id_cliente = c.id", nativeQuery = true)
List<PatoVendidoProjection> findPatosVendidos();

    
}
