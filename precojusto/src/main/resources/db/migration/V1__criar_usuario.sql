-- Script para criação das tabelas Pato, Cliente e Venda

CREATE SCHEMA IF NOT EXISTS precojusto;

-- Tabela Cliente
CREATE TABLE IF NOT EXISTS precojusto.CLIENTE (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    desconto BOOLEAN NOT NULL
);

-- Tabela Pato
CREATE TABLE IF NOT EXISTS precojusto.PATO (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    mae VARCHAR(255),
    id_mae BIGINT,
    valor INT DEFAULT 70,
    nfilhos INT DEFAULT 0,
    disponivel BOOLEAN,
    CONSTRAINT fk_mae FOREIGN KEY (id_mae) REFERENCES precojusto.pato(id)
);

CREATE TABLE IF NOT EXISTS precojusto.VENDA (
    id SERIAL PRIMARY KEY,
    id_cliente BIGINT NOT NULL,
    data_venda DATE NOT NULL,
    valor_total FLOAT NOT NULL,
    CONSTRAINT fk_venda_cliente FOREIGN KEY (id_cliente) REFERENCES precojusto.cliente(id)
);

CREATE TABLE IF NOT EXISTS precojusto.VENDA_PATOS (
    id_venda BIGINT NOT NULL,
    id_pato BIGINT NOT NULL,
    PRIMARY KEY (id_venda, id_pato),
    CONSTRAINT fk_venda_patos_venda FOREIGN KEY (id_venda) REFERENCES precojusto.venda(id),
    CONSTRAINT fk_venda_patos_pato FOREIGN KEY (id_pato) REFERENCES precojusto.pato(id)
);


-- Inserção de dados
INSERT INTO precojusto.cliente (nome, desconto) VALUES ('João', TRUE);
INSERT INTO precojusto.cliente (nome, desconto) VALUES ('Maria', FALSE);

INSERT INTO precojusto.pato (nome, mae, id_mae, valor, nfilhos, disponivel) VALUES ('Pato 1', NULL, NULL, 70, 0, TRUE);
INSERT INTO precojusto.pato (nome, mae, id_mae, valor, nfilhos, disponivel) VALUES ('Pato 2', NULL, NULL, 70, 0, TRUE);
