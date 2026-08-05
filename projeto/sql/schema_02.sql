USE loja_analytics;

INSERT INTO produto (nome, preco, categoria_id) VALUES
('Notebook', 3500.00, 1),
('Mouse', 80.00, 1),
('Teclado', 150.00, 1),
('Smartphone', 2200.00, 1),
('Livro Clean Code', 90.00, 2),
('Livro Java Efetivo', 120.00, 2), 
('Camiseta', 60.00, 3),
('Calça Jeans', 150.00, 3),
('Tênis', 250.00, 3),
('Café', 25.00, 4),
('Chocolate', 15.00, 4),
('Arroz', 30.00, 4);

INSERT INTO cliente (nome, email, cidade) VALUES
('Ana Silva', 'ana@email.com', 'São Paulo'),
('Bruno Costa', 'bruno@email.com', 'Rio de Janeiro'),
('Carla Souza', 'carla@email.com', 'Belo Horizonte'),
('Diego Alves', 'diego@email.com', 'Curitiba'),
('Elaine Prado', 'elaine@email.com', 'São Paulo'),
('Fabio Nunes', 'fabio@email.com', 'Porto Alegre'),
('Gabriela Reis', 'gabriela@email.com', 'Salvador'),
('Hugo Martins', 'hugo@email.com', 'São Paulo');

INSERT INTO pedido (cliente_id, data_pedido, status) VALUES
(1, '2025-01-05', 'CONCLUIDO'),
(1, '2025-02-10', 'CONCLUIDO'),
(1, '2025-03-15', 'CONCLUIDO'),
(2, '2025-01-20', 'CONCLUIDO'),
(2, '2025-04-02', 'CONCLUIDO'),
(3, '2025-01-11', 'CONCLUIDO'),
(3, '2025-02-25', 'CANCELADO'),
(4, '2025-03-01', 'CONCLUIDO'),
(4, '2025-05-18', 'CONCLUIDO'),
(4, '2025-05-30', 'CONCLUIDO'),
(5, '2025-02-14', 'CONCLUIDO'),
(5, '2025-06-01', 'CONCLUIDO'),
(6, '2025-01-29', 'CONCLUIDO'),
(6, '2025-04-19', 'CONCLUIDO'),
(7, '2025-03-22', 'CONCLUIDO'),
(7, '2025-06-10', 'CONCLUIDO'),
(8, '2025-02-02', 'CONCLUIDO'),
(8, '2025-03-09', 'CONCLUIDO'),
(8, '2025-04-25', 'CONCLUIDO'),
(1, '2025-06-15', 'CONCLUIDO');

INSERT INTO item_pedido (pedido_id, produto_id, quantidade, preco_unitario) VALUES
(1, 1, 1, 3500.00), (1, 2, 1, 80.00),
(2, 5, 2, 90.00),
(3, 4, 1, 2200.00), (3, 3, 1, 150.00),
(4, 7, 3, 60.00), (4, 9, 1, 250.00),
(5, 10, 5, 25.00), (5, 11, 10, 15.00),
(6, 1, 1, 3500.00),
(7, 8, 2, 150.00),
(8, 2, 2, 80.00), (8, 3, 1, 150.00),
(9, 9, 2, 250.00),
(10, 4, 1, 2200.00),
(11, 5, 1, 90.00),
(12, 12, 4, 30.00),
(13, 7, 5, 60.00),
(14, 10, 2, 25.00), (14, 11, 3, 15.00),
(15, 1, 1, 3500.00), (15, 4, 1, 2200.00),
(16, 9, 1, 250.00),
(17, 2, 1, 80.00),
(18, 8, 1, 150.00), (18, 9, 1, 250.00),
(19, 10, 10, 25.00),
(20, 1, 2, 3500.00);