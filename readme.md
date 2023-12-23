# ODV E-commerce

Bem-vindo ao projeto E-commerce! Este é um sistema de comércio eletrônico desenvolvido em Java com Spring Boot, utilizando o Maven como gerenciador de dependências e o banco de dados H2. Permite a usuários comuns e vendedores realizar transações de compra e venda.

## Índice

- [Arquitetura](#arquitetura)
- [Configuração](#configuração)
- [Endpoints](#endpoints)

## Arquitetura

O projeto é desenvolvido utilizando uma arquitetura monolítica. Os principais serviços incluem:

- **Produtos:** Gerenciamento de produtos, categorias e ofertas.
- **Autenticação:** Autenticação de usuários comuns e vendedores.
- **Home:** Exibição de produtos recomendados e estatísticas.
- **Cadastro de Produtos:** Adição de novos produtos ao catálogo.
- **Carrinho:** Gerenciamento de carrinho e processo de checkout.
- **Checkout:** Confirmação de pedidos e informações do comprador.
- **Rastreamento de Entrega:** Informações sobre o status da entrega.

## Configuração

Certifique-se de ter as seguintes ferramentas instaladas:

- [Java](https://www.oracle.com/java/)
- [Maven](https://maven.apache.org/)
- [H2 Database](https://www.h2database.com/)

### Passos de Instalação:

1. Clone o repositório:

   ```bash
   git clone https://github.com/ODV-Squad/back-end-spring-boot.git
   
2. Navegue até o diretório do projeto:

    ```bash
   cd e-commerce

3. Compile o projeto:

    ```bash
   mvn clean install
   
4. Inicie a aplicação:

    ```bash
    java -jar target/back-end-spring-boot.jar
   
A aplicação estará disponível em http://localhost:8080

## Endpoints

A documentação dos endpoints estará disponível em http://localhost:8080/swagger-ui/index.html#/


