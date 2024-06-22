-- Script para criação das tabelas Pato, Cliente e Venda

-- Tabela Cliente
CREATE TABLE CLIENTE (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    desconto BOOLEAN NOT NULL
);

-- Tabela Pato
CREATE TABLE PATO (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    mae VARCHAR(255),
    id_mae BIGINT,
    nfilhos INT DEFAULT 0,
    disponivel BOOLEAN,
    CONSTRAINT fk_mae FOREIGN KEY (id_mae) REFERENCES pato(id)
);

-- Tabela Venda
CREATE TABLE VENDA (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente BIGINT NOT NULL,
    data_venda DATE NOT NULL,
    valor_total DOUBLE NOT NULL,
    CONSTRAINT fk_venda_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

-- Tabela de relacionamento entre Venda e Pato
CREATE TABLE venda_patos (
    id_venda BIGINT NOT NULL,
    id_pato BIGINT NOT NULL,
    PRIMARY KEY (id_venda, id_pato),
    CONSTRAINT fk_venda_patos_venda FOREIGN KEY (id_venda) REFERENCES venda(id),
    CONSTRAINT fk_venda_patos_pato FOREIGN KEY (id_pato) REFERENCES pato(id)
);
