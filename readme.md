# ODV E-commerce

Bem-vindo ao projeto E-commerce! Este � um sistema de com�rcio eletr�nico desenvolvido em Java com Spring Boot, utilizando o Maven como gerenciador de depend�ncias e o banco de dados H2. Permite a usu�rios comuns e vendedores realizar transa��es de compra e venda.

## �ndice

- [Arquitetura](#arquitetura)
- [Configura��o](#configura��o)
- [Endpoints](#endpoints)

## Arquitetura

O projeto � desenvolvido utilizando uma arquitetura monol�tica. Os principais servi�os incluem:

- **Produtos:** Gerenciamento de produtos, categorias e ofertas.
- **Autentica��o:** Autentica��o de usu�rios comuns e vendedores.
- **Home:** Exibi��o de produtos recomendados e estat�sticas.
- **Cadastro de Produtos:** Adi��o de novos produtos ao cat�logo.
- **Carrinho:** Gerenciamento de carrinho e processo de checkout.
- **Checkout:** Confirma��o de pedidos e informa��es do comprador.
- **Rastreamento de Entrega:** Informa��es sobre o status da entrega.

## Configura��o

Certifique-se de ter as seguintes ferramentas instaladas:

- [Java](https://www.oracle.com/java/)
- [Maven](https://maven.apache.org/)
- [H2 Database](https://www.h2database.com/)

### Passos de Instala��o:

1. Clone o reposit�rio:

   ```bash
   git clone https://github.com/ODV-Squad/back-end-spring-boot.git
   
2. Navegue at� o diret�rio do projeto:

    ```bash
   cd e-commerce

3. Compile o projeto:

    ```bash
   mvn clean install
   
4. Inicie a aplica��o:

    ```bash
    java -jar target/back-end-spring-boot.jar
   
A aplica��o estar� dispon�vel em http://localhost:8080

## Endpoints

A documenta��o dos endpoints estar� dispon�vel em http://localhost:8080/swagger-ui/index.html#/


