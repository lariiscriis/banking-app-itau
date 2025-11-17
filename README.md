# 🏦 Banking API — Desafio Técnico Itaú

API REST para operações bancárias básicas desenvolvida com **Java 21**, **Spring Boot 3** e **H2 Database em memória**, seguindo os requisitos do desafio técnico do Itaú Unibanco.

---

## 📌 Sobre o Projeto

Este projeto implementa:

- ✔ Criação de contas  
- ✔ Consulta de saldo  
- ✔ Transferências  
- ✔ Armazenamento totalmente em memória  
- ✔ Documentação com Swagger  

Além do solicitado, o projeto também inclui:

- ✔ Depósitos  
- ✔ Saques  
- ✔ Tratamento global de exceções  
- ✔ Validações de CPF  
- ✔ Estrutura profissional em camadas  
- ✔ Testes unitários com Mockito  

---

## 🌍 Por que as classes e métodos estão em inglês?

As classes, métodos e camadas do sistema estão nomeados em inglês por uma razão importante:

> **O inglês é o padrão universal na indústria de tecnologia.**  

Escolhi seguir esse padrão para manter o código mais profissional, alinhado a projetos reais e acessível para qualquer desenvolvedor. 

---

## 🚀 Funcionalidades da API

### Funcionalidades do desafio
- Criar conta  
- Consultar saldo  
- Transferir valores  
- Impedir saldo negativo  
- Armazenar dados em memória  

### Funcionalidades extras (boas práticas)
- Depósito  
- Saque  
- Exceções personalizadas  
- Mensagens de erro claras  
- Documentação com Swagger UI  
- Testes unitários  
- Validar CPF  

---

## 🛠 Tecnologias Utilizadas

- Java 21  
- Spring Boot 3  
- Spring Web  
- Spring Data JPA  
- Spring Validation  
- H2 Database  
- Lombok  
- SpringDoc OpenAPI (Swagger)  
- Maven  
- Mockito & JUnit 5  

---

## 📦 Estrutura do Projeto
```
src/main/java/com/itau/desafiotecnico/larissa/banking/
├── config/
│ └── SwaggerConfig.java           # Configurações do Swagger
├── controller/
│ └── ClientController.java        # Endpoints REST
├── entity/
│ └── Client.java                  # Entidade da conta
├── exception/                     # Pasta responsável por armazenar as exceções do projeto e o tratamento global delas
│ ├── DuplicateClientException.java
│ ├── InvalidCpfException.java
│ ├── ClientNotFoundException.java
│ └── GlobalExceptionHandler.java
├── repository/
│ └── ClientRepository.java        # Repositório JPA
├── service/
│ └── ClientService.java           # Regras de negócio
├── validation/
│ └── ClientValidation.java        # Validações da entidade Client
└── BankingAppItauApplication.java # Classe principal
```
---

## 🎯 Endpoints da API

### Contas
| Método | Endpoint                  | Descrição |
|--------|---------------------------|-----------|
| POST   | `/clients`                | Criar nova conta |
| GET    | `/clients/{id}/balance`   | Consultar saldo |

### Operações Bancárias
| Método | Endpoint     | Descrição |
|--------|--------------|-----------|
| POST   | `/deposit`   | Realizar depósito |
| POST   | `/withdraw`  | Realizar saque |
| POST   | `/transfer`  | Transferência entre contas |

---

## 🚀 Como Executar

### Pré-requisitos
- Java 21  
- Maven 3.6+

### Passo a passo

**1️⃣ Clonar o repositório**
```bash
git clone https://github.com/lariiscriis/banking-app-itau
cd banking-app-itau
```

**2️⃣ Executar a aplicação**
```
mvn spring-boot:run
```


**🌐 Endpoints importantes**

`Swagger UI`
http://localhost:8080/swagger-ui/index.html

`H2 Console`
http://localhost:8080/h2-console

---

### **🧪 Testando a API**
1 - Via Swagger UI

2 - Inicie o projeto

3 - Acesse: http://localhost:8080/swagger-ui/index.html

4 - Clique em Try it out

5 - Execute qualquer requisição pela interface interativa


---

### 📚 Conclusão

Este projeto cumpre todos os requisitos do desafio técnico e adiciona boas práticas importantes, apresentando uma API organizada, clara, documentada e funcional.
