package com.example.precojusto.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

@Entity
@Table(name = "PATO")
public class Pato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name= "nome", nullable = false, length = 100)
    private String nome;

    @Column (name = "mae", nullable = false, length = 100)
    private String mae;

    @Column (name = "nfilhos", nullable = false, length = 100, columnDefinition = "int default 0")
    private int nfilhos;

    @Column (name = "disponivel", nullable = false, length = 100, columnDefinition = "boolean default true")
    private boolean disponivel;



    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMae() {
        return mae;
    }

    public int getNfilhos() {
        return nfilhos;
    }

    public Pato (String nome, String mae) {
        this.nome = nome;
        this.mae = mae;
    }


    

    
}
