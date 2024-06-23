package com.example.precojusto.repository.DTO;

import java.time.LocalDate;
import java.util.List;

public class NotaDTO {
    private Long id_venda;
    private Long id_cliente;
    private List <Long> id_patos;
    private LocalDate data_venda;
    private double valor_total;

    public Long getId_venda() {
        return id_venda;
    }

    public void setId_venda(Long id_venda) {
        this.id_venda = id_venda;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public List<Long> getId_patos() {
        return id_patos;
    }

    public void setId_patos(List<Long> id_patos) {
        this.id_patos = id_patos;
    }

    public LocalDate getData_venda() {
        return data_venda;
    }

    public void setData_venda(LocalDate data_venda) {
        this.data_venda = data_venda;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
    
}
