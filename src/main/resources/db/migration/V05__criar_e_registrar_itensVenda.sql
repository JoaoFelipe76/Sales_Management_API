CREATE TABLE item_venda (
    codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
    codigo_produto BIGINT NOT NULL,
    codigo_venda BIGINT NOT NULL,
    quantidade INTEGER NOT NULL,
    preco_vendido DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (codigo_produto) REFERENCES produto(codigo),
    FOREIGN KEY (codigo_venda) REFERENCES venda(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido) VALUES (1, 1, 2, 399.98);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido) VALUES (2, 1, 1, 79.99);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido) VALUES (3, 2, 3, 149.97);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido) VALUES (4, 2, 2, 139.98);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido) VALUES (5, 3, 1, 29.99);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido) VALUES (6, 3, 2, 259.98);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido) VALUES (7, 4, 1, 49.99);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido) VALUES (8, 4, 1, 129.99);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido) VALUES (5, 5, 4, 159.96);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido) VALUES (2, 5, 2, 69.98);
INSERT INTO item_venda(codigo_produto, codigo_venda, quantidade, preco_vendido) VALUES (6, 6, 2, 139.98);

