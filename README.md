# API RESTful para Gerenciamento de Vendas de Acessórios Automotivos em Spring Boot

## Sobre
Esta API RESTful, desenvolvida em **Spring Boot**, é projetada para gerenciar a venda de acessórios automotivos. Utiliza **MySQL** para armazenar dados, sendo executado em um contêiner Docker. A API inclui funcionalidades para o registro de produtos, categorias e clientes.

## Funcionalidades
- **Registro de Produtos**: Adiciona e gerencia produtos de acessórios automotivos.
- **Registro de Categorias**: Adiciona e gerencia categorias para organizar os produtos.
- **Registro de Clientes**: Adiciona e gerencia informações de clientes.

## Tecnologias Utilizadas
- **Spring Boot**: Framework para desenvolvimento da API RESTful.
- **MySQL**: Sistema de gerenciamento de banco de dados relacional.
- **Docker**: Para contêinerização do banco de dados MySQL.

## Endpoints Principais
- **Produtos**:
  - `GET /produtos`: Retorna a lista de produtos.
  - `POST /produtos`: Adiciona um novo produto.
  - `PUT /produtos/{id}`: Atualiza um produto existente.
  - `DELETE /produtos/{id}`: Remove um produto.
- **Categorias**:
  - `GET /categorias`: Retorna a lista de categorias.
  - `POST /categorias`: Adiciona uma nova categoria.
  - `PUT /categorias/{id}`: Atualiza uma categoria existente.
  - `DELETE /categorias/{id}`: Remove uma categoria.
- **Clientes**:
  - `GET /clientes`: Retorna a lista de clientes.
  - `POST /clientes`: Adiciona um novo cliente.
  - `PUT /clientes/{id}`: Atualiza um cliente existente.
  - `DELETE /clientes/{id}`: Remove um cliente.

## Configuração do Banco de Dados

1. **Docker**:
   - Certifique-se de que o Docker esteja instalado e em execução.
   - Execute o seguinte comando para iniciar o contêiner MySQL:
     ```bash
     docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=acessorios -p 3306:3306 -d mysql:8.0
     ```

2. **Configuração do Spring Boot**:
   - Configure o acesso ao banco de dados MySQL no arquivo `application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/acessorios
     spring.datasource.username=root
     spring.datasource.password=root
     ```

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/JoaoFelipe76/api-acessorios-spring-boot.git
