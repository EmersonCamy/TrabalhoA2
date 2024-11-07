-- Inserindo dados nas tabelas
-- Clientes
INSERT INTO cliente (codigo, nome, cpf, email, telefone) VALUES (1, 'João Silva', '12345678901', 'joao.silva@example.com', '111111111');
INSERT INTO cliente (codigo, nome, cpf, email, telefone) VALUES (2, 'Maria Souza', '10987654321', 'maria.souza@example.com', '222222222');
INSERT INTO cliente (codigo, nome, cpf, email, telefone) VALUES (3, 'Pedro Oliveira', '19283746509', 'pedro.oliveira@example.com', '333333333');
INSERT INTO cliente (codigo, nome, cpf, email, telefone) VALUES (4, 'Ana Santos', '91827364500', 'ana.santos@example.com', '444444444');
INSERT INTO cliente (codigo, nome, cpf, email, telefone) VALUES (5, 'Lucas Lima', '12312312399', 'lucas.lima@example.com', '555555555');

-- Fornecedores
INSERT INTO fornecedor (codigo, razao_social, nome_fantasia, cnpj, email, telefone) VALUES (1, 'Fornecedor Ltda', 'Fornecedor 1', '11222333000181', 'fornecedor1@example.com', '666666666');
INSERT INTO fornecedor (codigo, razao_social, nome_fantasia, cnpj, email, telefone) VALUES (2, 'Empresa XYZ', 'Fornecedor 2', '99887766000192', 'fornecedor2@example.com', '777777777');
INSERT INTO fornecedor (codigo, razao_social, nome_fantasia, cnpj, email, telefone) VALUES (3, 'ABC Importações', 'Fornecedor 3', '55667788000103', 'fornecedor3@example.com', '888888888');
INSERT INTO fornecedor (codigo, razao_social, nome_fantasia, cnpj, email, telefone) VALUES (4, 'Tech Solutions', 'Fornecedor 4', '33445566000114', 'fornecedor4@example.com', '999999999');
INSERT INTO fornecedor (codigo, razao_social, nome_fantasia, cnpj, email, telefone) VALUES (5, 'Global Trade', 'Fornecedor 5', '22113344000125', 'fornecedor5@example.com', '1010101010');

-- Produtos
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (1, 'Produto A', 'Descrição do Produto A', 10.0);
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (2, 'Produto B', 'Descrição do Produto B', 20.0);
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (3, 'Produto C', 'Descrição do Produto C', 30.0);
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (4, 'Produto D', 'Descrição do Produto D', 40.0);
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (5, 'Produto E', 'Descrição do Produto E', 50.0);

-- Pedidos
INSERT INTO pedido (codigo, nome, cliente_codigo, fornecedor_codigo, data_de_inclusao, data_de_alteracao) VALUES (1, 'Pedido 1', 1, 1, CURRENT_DATE(), CURRENT_DATE());
INSERT INTO pedido (codigo, nome, cliente_codigo, fornecedor_codigo, data_de_inclusao, data_de_alteracao) VALUES (2, 'Pedido 2', 2, 2, CURRENT_DATE(), CURRENT_DATE());
INSERT INTO pedido (codigo, nome, cliente_codigo, fornecedor_codigo, data_de_inclusao, data_de_alteracao) VALUES (3, 'Pedido 3', 3, 3, CURRENT_DATE(), CURRENT_DATE());
INSERT INTO pedido (codigo, nome, cliente_codigo, fornecedor_codigo, data_de_inclusao, data_de_alteracao) VALUES (4, 'Pedido 4', 4, 4, CURRENT_DATE(), CURRENT_DATE());
INSERT INTO pedido (codigo, nome, cliente_codigo, fornecedor_codigo, data_de_inclusao, data_de_alteracao) VALUES (5, 'Pedido 5', 5, 5, CURRENT_DATE(), CURRENT_DATE());

-- Itens para o Pedido 1
INSERT INTO item_pedido (pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (1, 1, 2, 10.0);
INSERT INTO item_pedido (pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (1, 2, 1, 20.0);

-- Itens para o Pedido 2
INSERT INTO item_pedido (pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (2, 3, 5, 30.0);
INSERT INTO item_pedido (pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (2, 4, 2, 40.0);

-- Itens para o Pedido 3
INSERT INTO item_pedido (pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (3, 5, 1, 50.0);
INSERT INTO item_pedido (pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (3, 1, 3, 10.0);

-- Itens para o Pedido 4
INSERT INTO item_pedido (pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (4, 2, 4, 20.0);
INSERT INTO item_pedido (pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (4, 3, 2, 30.0);

-- Itens para o Pedido 5
INSERT INTO item_pedido (pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (5, 4, 5, 40.0);
INSERT INTO item_pedido (pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (5, 5, 2, 50.0);
