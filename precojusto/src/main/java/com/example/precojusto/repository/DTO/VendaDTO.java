package com.example.precojusto.repository.DTO;

import java.util.List;

public class VendaDTO {
    private Long id;
    private Long id_cliente;
    private List<Long> id_patos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
