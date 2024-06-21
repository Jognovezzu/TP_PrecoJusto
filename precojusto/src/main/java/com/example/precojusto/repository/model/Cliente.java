package com.example.precojusto.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity(name = "CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name= "nome", nullable = false, length = 255)
    private String nome;

    @Column (name = "desconto", nullable = false)
    private boolean desconto;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public boolean getDesconto() {
        return desconto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente(String nome, boolean desconto) {
        this.nome = nome;
        this.desconto = desconto;
    }
}
