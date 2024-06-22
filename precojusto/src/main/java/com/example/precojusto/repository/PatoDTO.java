package com.example.precojusto.repository;

import java.util.List;

public class PatoDTO {
    private Long id;
    private String nome;
    private String mae;
    private int numeroFilhos;
    private boolean disponivelParaVenda;
    private List<PatoDTO> filhos;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setMae(String mae) {
        this.mae = mae;
    }

    public int getNumeroFilhos() {
        return numeroFilhos;
    }

    public void setNumeroFilhos(int numeroFilhos) {
        this.numeroFilhos = numeroFilhos;
    }

    public boolean isDisponivelParaVenda() {
        return disponivelParaVenda;
    }

    public void setDisponivelParaVenda(boolean disponivelParaVenda) {
        this.disponivelParaVenda = disponivelParaVenda;
    }

    public List<PatoDTO> getFilhos() {
        return filhos;
    }

    public void setFilhos(List<PatoDTO> filhos) {
        this.filhos = filhos;
    }
}
