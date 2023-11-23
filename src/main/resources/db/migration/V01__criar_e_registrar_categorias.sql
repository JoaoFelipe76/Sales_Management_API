CREATE TABLE categoria (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO categoria (nome) VALUES ('Injetores & Drivers');
INSERT INTO categoria (nome) VALUES ('Ignição');
INSERT INTO categoria (nome) VALUES ('Volantes');
INSERT INTO categoria (nome) VALUES ('Vestuário e Acessórios');
INSERT INTO categoria (nome) VALUES ('Peças de carro em geral');
