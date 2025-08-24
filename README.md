# Projeto Spring Boot - Explorando Padrões de Projeto

Este projeto é um exemplo de aplicação Spring Boot que demonstra a implementação de **padrões de projeto clássicos** (GoF) na prática, utilizando o framework Spring. Especificamente, exploramos os padrões:

- **Singleton**: Implementado automaticamente pelos beans do Spring.
- **Strategy**: Para diferentes métodos de pagamento.
- **Facade**: `PagamentoController` atua como fachada para o serviço de pagamentos.

---

## Estrutura do Projeto

padroes/
│
├── src/main/java/com/exemplo/padroes/
│ ├── PadroesApplication.java
│ ├── controller/
│ │ └── PagamentoController.java
│ ├── service/
│ │ └── PagamentoService.java
│ └── pagamento/
│ ├── PagamentoStrategy.java
│ ├── Pix.java
│ ├── Cartao.java
│ └── Boleto.java
│
├── src/main/resources/
│ └── application.properties
│
└── pom.xml
---

## Diagrama de Classes

```plaintext```
             +------------------------+
             | PagamentoController    |  <-- Facade
             +------------------------+
             | - pagamentoService     |
             +------------------------+
             | + pagar(metodo, valor)|
             +-----------+------------+
                         |
                         v
             +------------------------+
             | PagamentoService       |  <-- Singleton + Strategy
             +------------------------+
             | - estrategias: Map     |
             +------------------------+
             | + processarPagamento() |
             +-----------+------------+
                         |
           +-------------+-------------+
           |             |             |
           v             v             v
     +---------+    +---------+    +---------+
     | Pix     |    | Cartao  |    | Boleto  |   <-- Strategy
     +---------+    +---------+    +---------+
     | + pagar()|   | + pagar()|   | + pagar()|
     +---------+    +---------+    +---------+
     
O PagamentoController expõe a API REST e atua como Facade.

O PagamentoService gerencia as estratégias de pagamento e é injetado pelo Spring (Singleton).

Cada implementação de PagamentoStrategy representa um método de pagamento (Pix, Cartão, Boleto).

Tecnologias Utilizadas
Java 21

Spring Boot 3.5.5

Maven

Padrões de Projeto GoF: Singleton, Strategy, Facade

Como Executar
Clonar o projeto:

git clone <URL_DO_SEU_REPOSITORIO>
Entrar na pasta do projeto:

cd padroes
Rodar a aplicação via Maven:

./mvnw spring-boot:run  # Linux/Mac
mvnw spring-boot:run    # Windows PowerShell
Testar a API no navegador ou Postman:

Pagamento via PIX:

GET http://localhost:8080/pagamento?metodo=pix&valor=50
Pagamento via Cartão:

GET http://localhost:8080/pagamento?metodo=cartao&valor=100
Pagamento via Boleto:

GET http://localhost:8080/pagamento?metodo=boleto&valor=70
Se o método de pagamento não existir, retorna:

Método de pagamento inválido. Use: cartao, pix ou boleto.
Observações
Todos os beans do Spring são Singleton por padrão.

O padrão Strategy permite adicionar novos métodos de pagamento sem alterar o código do serviço.

PagamentoController serve como Facade, expondo uma interface simples para o cliente.

Para adicionar um novo método de pagamento, basta criar uma classe que implemente PagamentoStrategy e anotá-la com @Component("nomeDoMetodo").

