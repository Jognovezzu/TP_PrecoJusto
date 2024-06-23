package com.example.precojusto.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import java.util.List;

import jakarta.persistence.CascadeType;

@Entity
@Table(name = "PATO")
public class Pato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "nome", nullable = false, length = 100)
    private String nome;

    @ManyToOne
    private Pato mae;

    @OneToMany(mappedBy = "mae", cascade = CascadeType.ALL)
    private List<Pato> filhos;

    @Column(name = "nfilhos", nullable = false, columnDefinition = "int default 0")
    private int nfilhos;

    @Column(name = "disponivel", nullable = false, columnDefinition = "boolean default true")
    private boolean disponivel;

    @Column(name = "valor", nullable = false, columnDefinition = "double default 70.0")
    private int valor;

    public Pato() {}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pato getMae() {
        return mae;
    }

    public void setMae(Pato mae) {
        this.mae = mae;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getNfilhos() {
        return nfilhos;
    }

    public void setNfilhos(int nfilhos) {
        this.nfilhos = nfilhos;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public List<Pato> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<Pato> filhos) {
        this.filhos = filhos;
    }

    public void updateFilhos() {
        this.nfilhos++;
        if (this.nfilhos == 1) {
            this.valor = 50;
        } else if (this.nfilhos == 2) {
            this.valor = 25;            
        }
    }

    public Pato(String nome, Pato mae) {
        this.nome = nome;
        this.mae = mae;
        this.nfilhos = 0;
        this.disponivel = true;
        this.valor = 70;
    }
}

