# TESTE PRATICO - BACKEND - SPRING BOOT

## 1. DESCRIÇÃO:
Projeto do Backend para uma API RESTful de um sistema de Gerenciamento de Patos.

## 2. TECNOLOGIAS | FRAMEWORKS:
<div style="display: flex; justify-content: space-between; gap: 20px;">

  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/79/Spring_Boot.svg/512px-Spring_Boot.svg.png?20230616230349" alt="Spring Boot" title="Spring Boot" height="50" />
  <img src="https://www.svgrepo.com/show/184143/java.svg" alt="Java" title="Java" height="50" />
  <img src="https://upload.wikimedia.org/wikipedia/commons/4/4c/Typescript_logo_2020.svg" alt="TypeScript" title="TypeScript" height="50" >
  <img src="https://www.svgrepo.com/show/306591/postgresql.svg" alt="Postgres" title="Postgres" height="50" />
  <img src="https://www.svgrepo.com/show/349342/docker.svg" alt="Docker" title="Docker" height="50" />

</div>

## 3. EXECUTAR PROJETO LOCALMENTE:
### 3.1. PRÉ-REQUISITOS:
- Java 11
- Maven
- Docker
- Docker Compose

### 3.2. CLONAR REPOSITÓRIO:
```bash
git clone https://github.com/Jognovezzu/TP_PrecoJusto.git
```

### 3.3. EXECUTAR PROJETO:

O seguinte comando irá executar o projeto localmente, utilizando o Docker Compose para subir um container com o banco de dados PostgreSQL e a API Spring Boot.
```bash
cd TP_PrecoJusto
cd docker
docker-compose -f docker-compose up
```

### 4. DOCUMENTAÇÃO DAS ROTAS:
#### 4.1. Rotas:
- [GET] http://localhost:8080/api/v1/pato/ : Retorna todos os patos cadastrados
- [GET] http://localhost:8080/api/v1/patos/{id} : Retorna um pato específico
- [POST] http://localhost:8080/api/v1/pato/ : Cadastra um novo pato {nome, mae}
- [GET] http://localhost:8080/api/v1/cliente : Retorna todos os clientes cadastrados
- [POST] http://localhost:8080/api/v1/cliente : Cadastra um novo cliente {nome, desconto}
- [GET] http://localhost:8080/api/v1/venda/ : Retorna todas as vendas cadastradas
- [POST] http://localhost:8080/api/v1/venda/ : Cadastra uma nova venda {cliente, [idpatos]}
- [GET] http://localhost:8080/api/v1/report/pdf : Gera um relatório em PDF (Bugado)
- [GET] http://localhost:8080/api/v1/report/xlsx : Gera um relatório em Excel

### 5. DIAGRAMAS 
- Segue abaixo os diagramas e o cronograma do projeto em um arquivo PDF.
[Diagramas](Cronograma e Diagramas.pdf)
###  6. OBSERVAÇÕES:

- Apos a compilacao do projeto, foi verificado um erro na geracao do relatorio em PDF (Chegou a funcionar), o qual nao foi possivel corrigir a tempo. Mas deixo a seguir um print do relatorio gerado e o arquivo que fora gerado.

[Print PDF](Captura1.png)



[Relatorio em PDF](report.pdf)

- Print do documento Excel gerado (it's working)
[Print Excel](Captura2.png)
