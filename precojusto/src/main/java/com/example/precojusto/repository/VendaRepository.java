package com.example.precojusto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.precojusto.repository.DTO.ReportProjection;
import com.example.precojusto.repository.model.Venda;

public interface VendaRepository extends JpaRepository <Venda, Long> {

    @Query(value = "SELECT p.nome AS pato_nome, p.disponivel AS pato_disponivel, p.valor " +
                    "AS pato_valor, c.nome " +
                    "AS cliente_nome, c.desconto AS cliente_desconto " +
                    "FROM precojusto.PATO p " +
                    "LEFT JOIN precojusto.VENDA_PATOS vp ON p.id = vp.id_pato " +
                    "LEFT JOIN precojusto.VENDA v ON vp.id_venda = v.id " +
                    "LEFT JOIN precojusto.CLIENTE c ON v.id_cliente = c.id " +
                    "ORDER BY p.nome", nativeQuery = true)
    List<ReportProjection> makeReport();
    
}
