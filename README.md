# TrabalhoA2 - Emerson Serrou Camy

## Relação entre Entidades

A imagem abaixo representa a relação entre as entidades `Pedido`, `ItemPedido` e `Produto`:

![Relação entre Pedido, ItemPedido e Produto](A2/Relação.jpeg)

## Endpoints da API

A API expõe os seguintes endpoints para manipulação das entidades:

### Clientes
- `GET /clientes`: Retorna todos os clientes.
- `GET /clientes/{codigo}`: Retorna um cliente específico pelo código.
- `POST /clientes`: Cria um novo cliente.
- `PUT /clientes/{codigo}`: Atualiza um cliente existente.
- `DELETE /clientes/{codigo}`: Exclui um cliente.

### Fornecedores
- `GET /fornecedores`: Retorna todos os fornecedores.
- `GET /fornecedores/{codigo}`: Retorna um fornecedor específico pelo código.
- `POST /fornecedores`: Cria um novo fornecedor.
- `PUT /fornecedores/{codigo}`: Atualiza um fornecedor existente.
- `DELETE /fornecedores/{codigo}`: Exclui um fornecedor.

### Produtos
- `GET /produtos`: Retorna todos os produtos.
- `GET /produtos/{codigo}`: Retorna um produto específico pelo código.
- `POST /produtos`: Cria um novo produto.
- `PUT /produtos/{codigo}`: Atualiza um produto existente.
- `DELETE /produtos/{codigo}`: Exclui um produto.

### Pedidos
- `GET /pedidos`: Retorna todos os pedidos, incluindo os itens associados.
- `GET /pedidos/{codigo}`: Retorna um pedido específico pelo código.
- `POST /pedidos`: Cria um novo pedido.
- `PUT /pedidos/{codigo}`: Atualiza um pedido existente.
- `DELETE /pedidos/{codigo}`: Exclui um pedido.

### Itens de Pedido
- `GET /itenspedido`: Retorna todos os itens de pedido.
- `GET /itenspedido/{id}`: Retorna um item de pedido específico pelo ID.
- `POST /itenspedido`: Cria um novo item de pedido.
- `PUT /itenspedido/{id}`: Atualiza um item de pedido existente.
- `DELETE /itenspedido/{id}`: Exclui um item de pedido.

## Configuração do Banco de Dados

A aplicação utiliza um banco de dados H2 em memória, facilitando o desenvolvimento e testes com dados temporários carregados automaticamente.

### Estrutura de Configuração
- **Arquivo de Configuração Principal**: `application.properties`  
  Configura as propriedades essenciais do banco de dados e da aplicação.  
  Caminho: `A2/src/main/resources/application.properties`

- **Script de Dados Iniciais**: `data.sql`  
  Contém instruções SQL para carregar dados de exemplo automaticamente ao iniciar a aplicação.  
  Caminho: `A2/src/main/resources/data.sql`

### Detalhes do Banco de Dados
- **Banco de Dados**: H2 em memória (`jdbc:h2:mem:testdb`)
- **Console H2**: Acessível em `/h2-console` para visualização e verificação dos dados.
- **Usuário**: `sa`
- **Senha**: *(em branco)*

Com essas configurações, basta iniciar a aplicação e acessar o console H2 para visualizar os dados carregados do `data.sql`.

