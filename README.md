Sistema de Gestão de Vendas (API Java com Interface)
Este projeto é um dashboard de vendas completo que integra uma API desenvolvida em Java (Spring Boot) com um frontend moderno e responsivo em React (Vite + TypeScript). O objetivo principal é visualizar os dados dos clientes, seus produtos e o valor final.

Tecnologias Utilizadas:

Backend
Java 17: Linguagem principal.

Spring Boot 3.x: Framework para criação da API REST.

Spring Data JPA / Hibernate: Para persistência e mapeamento objeto-relacional.

H2 Database: Banco de dados em memória.

Native Queries (SQL): Para relatórios personalizados de soma de vendas.

Frontend
React 18 (Vite) e TypeScript.

Tailwind CSS v4: Estilização moderna.

Fetch API: Comunicação com o backend.

Como Testar a API (Postman):
Para facilitar a validação das rotas, disponibilizei os arquivos de configuração na pasta raiz do projeto:

Importe os arquivos: No Postman, clique em Import e selecione:

Desafio API - Sistemas de Vendas.postman_collection.json

Desenvolvimento local.postman_environment.json (ou o nome exato que salvou do ambiente).

Selecione o Ambiente: No canto superior direito do Postman, mude de "No Environment" para "Desenvolvimento local".

Use as Variáveis: As rotas já estão configuradas com {{base_url}}, o que permite rodar os testes instantaneamente.

Como Rodar o Projeto:

1. Backend (Java)
   Entre na pasta do backend.

Execute: ./mvnw spring-boot:run

O servidor subirá em: http://localhost:8080

H2 Console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:desafiodb)

2. Frontend (React)
   Entre na pasta frontend.

Instale as dependências: npm install

Inicie: npm run dev

O dashboard estará em: http://localhost:5173

Fluxo de Teste Sugerido:

Como o banco H2 reinicia vazio, use a Collection do Postman na seguinte ordem:

POST - Cadastrar Novo Cliente

POST - Cadastrar Novo Produto

POST - Realizar Pedido (Isso dará baixa no estoque e gerará o financeiro).

Dashboard: Clique em "Atualizar Dados" no React para ver os cards atualizados.

Desenvolvido por Priscila Oliveira.
