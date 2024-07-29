
# API de Gerenciamento de Inventário

Este repositório contém uma API RESTful desenvolvida em Java utilizando Spring Boot para gerenciar o inventário de produtos de um banco de dados.

## Funcionalidades

- Adicionar, atualizar, deletar e buscar produtos
- Atualizar quantidade em estoque de produtos

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal utilizada.
- **Spring Boot**: Framework para criação da aplicação.
- **Spring Data JPA**: Framework para persistência de dados.
- **H2 Database**: Banco de dados para testes.
- **Maven**: Gerenciador de dependências e build.

## Como Executar o Projeto

1. Clone o repositório:
   ```sh
   git clone https://github.com/lucasggmoreira/api-gerenciamento-inventario.git
   ```

2. Navegue até o diretório do projeto:
   ```sh
   cd api-gerenciamento-inventario
   ```

3. Compile e execute o projeto:
   ```sh
   mvn spring-boot:run
   ```

4. A API estará disponível em `http://localhost:8081`.

## Endpoints

### Produtos

- **Adicionar um novo produto**
  - `POST /produtos`
  - Exemplo de Request Body:
    ```json
    {
       "nome": "Salsicha",
       "quantidade": 3,
       "preco": 12.50
    }
    ```

- **Atualizar informações de um produto**
  - `PUT /produtos/{id}`
  - Exemplo de Request Body:
    ```json
    {
       "nome": "Salsicha",
       "quantidade": 10,
       "preco": 22.50
    }
    ```

- **Deletar um produto**
  - `DELETE /produtos/{id}`

- **Buscar informações sobre produtos**
  - `GET /produtos`

- **Buscar informações sobre um produto específico**
  - `GET /produtos/{id}`

- **Atualizar quantidade em estoque de um produto**
  - `PATCH /produtos/{id}/estoque`
  - Exemplo de Request Body:
    ```json
    {
      "quantidade": 50
    }
    ```

- **Atualizar o preço de um produto**
  - `PATCH /produtos/{id}/preco`
  - Exemplo de Request Body:
    ```json
    {
      "preco": 25.50
    }
    ```

## Estrutura do Projeto

- **controllers**: Define os endpoints da API.
- **exceptions**: Contém exceções personalizadas.
- **repository**: Interage com o banco de dados.
- **models**: Define as entidades do banco de dados.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
