# Sistema de Gestão de Vendas ( api java com interface)

Este projeto é um dashboard de vendas completo que integra uma API desenvolvida em **Java (Spring Boot)** com um frontend moderno e responsivo em **React (Vite + TypeScript)**. O objetivo principal é visualizar os dados dos clientes, seus produtos e o valor final.

---

## Tecnologias Utilizadas

### Backend

- **Java 17**: Linguagem principal.
- **Spring Boot 3.x**: Framework para criação da API REST.
- **Spring Data JPA / Hibernate**: Para persistência e mapeamento objeto-relacional.
- **H2 Database**: Banco de dados em memória para agilidade no desenvolvimento.
- **Native Queries (SQL)**: Utilizadas para extrair relatórios personalizados de soma de vendas.

### Frontend

- **React 18** (Vite): Framework de interface.
- **TypeScript**: Tipagem estática para maior segurança do código.
- **Tailwind CSS v4**: Estilização moderna e responsiva baseada em utilitários.
- **Fetch API**: Comunicação assíncrona com o backend.

---

## Funcionalidades

- **Dashboard de Clientes:** Exibição dinâmica de cards com o total gasto por cada cliente.
- **Integração Full Stack:** Consumo de API REST em tempo real.
- **Tratamento de Dados:** Formatação de moedas (BRL) e tratamento de nomes no frontend.
- **Relatórios:** Soma automática de pedidos vinculada a cada cliente via banco de dados.

---

## Como rodar o projeto

### 1. Pré-requisitos

- Java 17 ou superior.
- Node.js (v18 ou superior).
- Maven (opcional, pode usar o wrapper `./mvnw`).

### 2. Configurando o Backend (Java)

1. Entre na pasta `api` (ou onde está o seu `pom.xml`).
2. Execute o servidor:
   ```bash
   ./mvnw spring-boot:run
   O servidor subirá em: http://localhost:8080.
   ```

Console do Banco H2: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:desafiodb).

3. Configurando o Frontend (React)
Entre na pasta frontend.

Instale as dependências:

Bash
npm install
Inicie a aplicação:

Bash
npm run dev
O dashboard estará disponível em: http://localhost:5173.

Fluxo de Teste
Como o banco de dados H2 é volátil (reinicia vazio), siga esta ordem para ver os dados no dashboard:

Cadastre um Cliente (POST em /api/clientes).

Cadastre um Produto (POST em /api/produtos).

Cadastre um Pedido vinculado ao cliente e produto (POST em /api/pedidos).

Clique no botão "Atualizar Dados" no Dashboard React.

Desenvolvido por Priscila Oliveira.
