-- Inserindo dados nas tabelas com exemplos de clientes, fornecedores, produtos e pedidos

-- Clientes
INSERT INTO cliente (codigo, nome, cpf, email, telefone) VALUES (1, 'João da Silva', '12345678901', 'joao.silva@exemplo.com', '11999999999');
INSERT INTO cliente (codigo, nome, cpf, email, telefone) VALUES (2, 'Maria Souza', '10987654321', 'maria.souza@exemplo.com', '11888888888');
INSERT INTO cliente (codigo, nome, cpf, email, telefone) VALUES (3, 'Pedro Oliveira', '19283746509', 'pedro.oliveira@exemplo.com', '11777777777');
INSERT INTO cliente (codigo, nome, cpf, email, telefone) VALUES (4, 'Ana Santos', '91827364500', 'ana.santos@exemplo.com', '11666666666');
INSERT INTO cliente (codigo, nome, cpf, email, telefone) VALUES (5, 'Lucas Lima', '12312312399', 'lucas.lima@exemplo.com', '11555555555');

-- Fornecedores
INSERT INTO fornecedor (codigo, razao_social, nome_fantasia, cnpj, email, telefone) VALUES (1, 'Importadora Global Ltda', 'Global Import', '11222333000181', 'contato@globalimport.com', '11444444444');
INSERT INTO fornecedor (codigo, razao_social, nome_fantasia, cnpj, email, telefone) VALUES (2, 'Tech Supplies', 'TechPro', '99887766000192', 'vendas@techpro.com', '11333333333');
INSERT INTO fornecedor (codigo, razao_social, nome_fantasia, cnpj, email, telefone) VALUES (3, 'Mundo das Peças', 'PecasWorld', '55667788000103', 'suporte@pecasworld.com', '11222222222');
INSERT INTO fornecedor (codigo, razao_social, nome_fantasia, cnpj, email, telefone) VALUES (4, 'Alimentos Nacionais', 'Nacional Food', '33445566000114', 'vendas@nacionalfood.com', '11111111111');
INSERT INTO fornecedor (codigo, razao_social, nome_fantasia, cnpj, email, telefone) VALUES (5, 'Distribuidora Delta', 'Delta Dist', '22113344000125', 'contato@deltadist.com', '11900000000');

-- Produtos
-- Produtos Originais
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (1, 'Caneta Azul', 'Caneta azul, com tinta azul de alta qualidade.', 2.50);
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (2, 'Caderno Universitário', 'Caderno com 200 páginas e capa dura.', 15.90);
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (3, 'Garrafa Térmica', 'Garrafa de 500ml para bebidas quentes e frias.', 45.00);
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (4, 'Fone de Ouvido', 'Fone de ouvido com isolamento acústico.', 89.90);
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (5, 'Monitor Full HD', 'Monitor de 24 polegadas com resolução Full HD.', 799.99);

-- Produtos Adicionais para @OneToOne
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (6, 'Mouse Gamer', 'Mouse com alta precisão e RGB personalizável.', 150.00);
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (7, 'Teclado Mecânico', 'Teclado mecânico com switches Cherry MX.', 300.00);
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (8, 'Webcam HD', 'Webcam com resolução 1080p e microfone embutido.', 250.00);
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (9, 'HD Externo', 'HD externo de 1TB para armazenamento adicional.', 200.00);
INSERT INTO produto (codigo, nome, descricao, preco) VALUES (10, 'Impressora Multifuncional', 'Impressora com funções de impressão, digitalização e cópia.', 500.00);

-- Pedidos
INSERT INTO pedido (codigo, nome, cliente_codigo, fornecedor_codigo, data_de_inclusao, data_de_alteracao) VALUES (1, 'Pedido de João', 1, 1, CURRENT_DATE(), CURRENT_DATE());
INSERT INTO pedido (codigo, nome, cliente_codigo, fornecedor_codigo, data_de_inclusao, data_de_alteracao) VALUES (2, 'Pedido da Maria', 2, 2, CURRENT_DATE(), CURRENT_DATE());
INSERT INTO pedido (codigo, nome, cliente_codigo, fornecedor_codigo, data_de_inclusao, data_de_alteracao) VALUES (3, 'Pedido do Pedro', 3, 3, CURRENT_DATE(), CURRENT_DATE());
INSERT INTO pedido (codigo, nome, cliente_codigo, fornecedor_codigo, data_de_inclusao, data_de_alteracao) VALUES (4, 'Pedido da Ana', 4, 4, CURRENT_DATE(), CURRENT_DATE());
INSERT INTO pedido (codigo, nome, cliente_codigo, fornecedor_codigo, data_de_inclusao, data_de_alteracao) VALUES (5, 'Pedido do Lucas', 5, 5, CURRENT_DATE(), CURRENT_DATE());

-- Itens de Pedido
-- Itens para o Pedido de João
INSERT INTO item_pedido (id, pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (1, 1, 1, 10, 2.50);
INSERT INTO item_pedido (id, pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (2, 1, 2, 2, 15.90);

-- Itens para o Pedido da Maria
INSERT INTO item_pedido (id, pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (3, 2, 3, 1, 45.00);
INSERT INTO item_pedido (id, pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (4, 2, 4, 1, 89.90);

-- Itens para o Pedido do Pedro
INSERT INTO item_pedido (id, pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (5, 3, 5, 1, 799.99);
INSERT INTO item_pedido (id, pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (6, 3, 6, 3, 150.00);

-- Itens para o Pedido da Ana
INSERT INTO item_pedido (id, pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (7, 4, 7, 5, 300.00);
INSERT INTO item_pedido (id, pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (8, 4, 8, 2, 250.00);

-- Itens para o Pedido do Lucas
INSERT INTO item_pedido (id, pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (9, 5, 9, 1, 200.00);
INSERT INTO item_pedido (id, pedido_codigo, produto_codigo, quantidade, preco_unitario) VALUES (10, 5, 10, 1, 500.00);
