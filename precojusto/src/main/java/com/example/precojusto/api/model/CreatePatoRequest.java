package com.example.precojusto.api.model;

public record CreatePatoRequest(String nome, String mae) {
    
        public String getNome() {
            return nome;
        }
    
        public String getMae() {
            return mae;
        }
}
    

