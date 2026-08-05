

USE loja_analytics;

-- 1.
SELECT p.id, p.nome, c.nome AS categoria
FROM produto p
JOIN categoria c ON p.categoria_id = c.id;

-- 2.
SELECT pe.id AS pedido_id, cl.nome AS cliente, pe.data_pedido
FROM pedido pe
JOIN cliente cl ON pe.cliente_id = cl.id;

-- 3.
SELECT ip.id, ip.pedido_id, pr.nome AS produto, ip.quantidade, ip.preco_unitario
FROM item_pedido ip
JOIN produto pr ON ip.produto_id = pr.id;

-- 4.
SELECT pe.id AS pedido_id, cl.nome AS cliente, pe.data_pedido, pe.status
FROM pedido pe
JOIN cliente cl ON pe.cliente_id = cl.id
WHERE pe.status = 'CONCLUIDO';

-- 5.
SELECT pr.id, pr.nome AS produto, pr.preco
FROM produto pr
JOIN categoria c ON pr.categoria_id = c.id
WHERE c.nome = 'Eletrônicos';

-- 6.
SELECT pe.id AS pedido_id, cl.nome AS cliente, cl.cidade, pe.data_pedido
FROM pedido pe
JOIN cliente cl ON pe.cliente_id = cl.id
WHERE cl.cidade = 'São Paulo';

-- 7.
SELECT ip.pedido_id, pr.nome AS produto, ip.quantidade, ip.preco_unitario
FROM item_pedido ip
JOIN produto pr ON ip.produto_id = pr.id;

-- 8.
SELECT ip.pedido_id, pr.nome AS produto, ip.quantidade, ip.preco_unitario,
       (ip.quantidade * ip.preco_unitario) AS subtotal
FROM item_pedido ip
JOIN produto pr ON ip.produto_id = pr.id;
