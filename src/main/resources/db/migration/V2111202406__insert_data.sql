
INSERT INTO Cozinha (id, nome) VALUES (1, 'Tailandesa');
INSERT INTO Cozinha (id, nome) VALUES (2, 'Indiana');
INSERT INTO Cozinha (id, nome) VALUES (3, 'Brasileira');
INSERT INTO Cozinha (id, nome) VALUES (4, 'Japonesa');

INSERT INTO Restaurante (id, nome, taxa_frete, cozinha_id) VALUES (1, 'Thai Gourmet', 10, 1);
INSERT INTO Restaurante (id, nome, taxa_frete, cozinha_id) VALUES (2, 'Thai Delivery', 9.50, 1);
INSERT INTO Restaurante (id, nome, taxa_frete, cozinha_id) VALUES (3, 'Tuk Tuk Comida Indiana', 15, 2);

INSERT INTO Estado (id, nome) VALUES (1, 'Minas Gerais');
INSERT INTO Estado (id, nome) VALUES (2, 'São Paulo');
INSERT INTO Estado (id, nome) VALUES (3, 'Ceará');

INSERT INTO Cidade (id, nome, estado_id) VALUES (1, 'Uberlândia', 1);
INSERT INTO Cidade (id, nome, estado_id) VALUES (2, 'Belo Horizonte', 1);
INSERT INTO Cidade (id, nome, estado_id) VALUES (3, 'São Paulo', 2);
INSERT INTO Cidade (id, nome, estado_id) VALUES (4, 'Campinas', 2);
INSERT INTO Cidade (id, nome, estado_id) VALUES (5, 'Fortaleza', 3);

INSERT INTO Forma_Pagamento (id, descricao) VALUES (1, 'Cartão de crédito');
INSERT INTO Forma_Pagamento (id, descricao) VALUES (2, 'Cartão de débito');
INSERT INTO Forma_Pagamento (id, descricao) VALUES (3, 'Dinheiro');

INSERT INTO Permissao (id, nome, descricao) VALUES (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
INSERT INTO Permissao (id, nome, descricao) VALUES (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');
