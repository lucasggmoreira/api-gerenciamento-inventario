# API de Gerenciamento de Inventário

Este repositório contém uma API RESTful desenvolvida em Java utilizando Spring Boot para gerenciar o inventário de produtos de um banco de dados.

## Funcionalidades

- Adicionar, atualizar, deletar e buscar produtos

## Tecnologias Utilizadas

- **Java**: Linguagem de programação principal utilizada.
- **Spring Boot**: Framework para criação da aplicação.
- **Spring Data JPA**: Framework para persistência de dados.
- **H2 Database**: Banco de dados para testes.
- **Flyway**: Ferramenta para migração de banco de dados.
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

4. A API estará disponível em `http://localhost:8080`.

## Endpoints

- **Adicionar um novo produto**
  - `POST /produtos`
    - **nome**: Obrigatório (String)
    - **preco**: Opcional (padrão: `0.0`)
    - **quantidade**: Opcional (padrão: `0`)
  
  - Exemplo de Request Body:
    ```json
    {
       "nome": "Salsicha",
       "preco": 12.50,
       "quantidade": 3
    }
    ```

- **Buscar informações sobre os produtos**
  - `GET /produtos`


- **Buscar informações sobre um produto específico**
  - `GET /produtos/{id}`


- **Atualizar informações de um produto**
  - `PUT /produtos/{id}`

  - Exemplo de Request Body:
    ```json
    {
       "nome": "Salsicha",
       "preco": 22.50,
       "quantidade": 10
    }
    ```

- **Deletar um produto**
  - `DELETE /produtos/{id}`



## Estrutura do Projeto

- **controllers**: Define os endpoints da API.
- **domain**: Define os modelos do projeto e as entidades do banco de dados.
- **infra**: Contém tratamento de Exceptions e outras funções do projeto.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
