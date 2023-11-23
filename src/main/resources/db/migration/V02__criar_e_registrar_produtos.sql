CREATE TABLE produto (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	descricao VARCHAR(100) NOT NULL,
	quantidade INTEGER NOT NULL,
	preco_custo DECIMAL(10,2) NOT NULL,
	preco_venda DECIMAL(10,2) NOT NULL,
	observacao VARCHAR(500),
	codigo_categoria BIGINT NOT NULL,
	FOREIGN KEY (codigo_categoria) REFERENCES categoria(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) VALUES
('Injectores de Combustível - Conjunto de 4 peças', 10, 120.00, 199.99, 'Kit de injetores de alta performance', 1),
('Driver de Alto-falante Profissional', 20, 45.00, 79.99, 'Driver de alta potência para sistemas de som', 1);

INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) VALUES
('Tapete de Borracha para Carros', 50, 12.00, 29.99, 'Tapete resistente e fácil de limpar', 5),
('Cadeirinha para Bebê - Grupo 0+', 30, 70.00, 129.99, 'Cadeira de segurança para bebês', 5);

INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) VALUES
('Vela de Ignição de Platina - Conjunto de 4', 15, 20.00, 49.99, 'Velas de ignição de alta qualidade', 2),
('Bobina de Ignição para Veículos a Gasolina', 25, 35.00, 69.99, 'Bobina de alta tensão para sistemas de ignição', 2);

INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) VALUES
('Sensor de Velocidade do Veículo', 40, 15.00, 39.99, 'Sensor de velocidade para o sistema de freios ABS', 5),
('Sensor de Temperatura do Motor', 30, 12.00, 29.99, 'Sensor de temperatura para monitorar o motor', 5);

INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) VALUES
('Volante Esportivo em Couro', 15, 80.00, 149.99, 'Volante esportivo revestido em couro para carros de corrida', 3);

INSERT INTO produto (descricao, quantidade, preco_custo, preco_venda, observacao, codigo_categoria) VALUES
('Macacão para Corrida Esportiva', 10, 150.00, 299.99, 'Macacão de alta resistência para pilotos de corrida', 4);


