CREATE TABLE categoria (
	codigo BIGINT PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=UTF8MB4;

INSERT INTO categoria (nome) VALUES ('Acessórios Automotivos');
INSERT INTO categoria (nome) VALUES ('Som e Áudio');
INSERT INTO categoria (nome) VALUES ('Utilidades para Veículos');
INSERT INTO categoria (nome) VALUES ('Peças Eletrônicas');
INSERT INTO categoria (nome) VALUES ('Peças de Reposição');
