package com.example.precojusto.api.model;

public record CreateClienteRequest(String name, boolean desconto) {

    public String getNome() {
        return name;
    }

    public boolean getDesconto() {
        return desconto;
    }

}
