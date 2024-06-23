package com.example.precojusto.repository.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;

@Entity(name = "VENDA")
public class Venda {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn (name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
        name = "venda_patos",
        joinColumns = @JoinColumn(name = "id_venda"),
        inverseJoinColumns = @JoinColumn(name = "id_pato")
    )
    private List<Pato> patos = new ArrayList<>();

    @Column (name = "data_venda", nullable = false)
    private LocalDate dataVenda;

    @Column (name = "valor_total", nullable = false)
    private double valor_total;

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Pato> getPatos() {
        return patos;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public double getValorTotal() {
        return valor_total;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPatos(List<Pato> patos) {
        this.patos = patos;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void setValorTotal(double valorTotal) {
        this.valor_total = valorTotal;
    }
    

}
