CREATE DATABASE IF NOT EXISTS loja_analytics;
USE loja_analytics;

CREATE TABLE categoria(
	id INT AUTO_INCREMENT PRIMARY KEY, 
    nome VARCHAR(50) NOT NULL
);

CREATE TABLE produto(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    preco DECIMAL(10,2) NOT NULL,
    categoria_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);

CREATE TABLE cliente(
	id INT AUTO_INCREMENT PRIMARY KEY, 
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    cidade VARCHAR(60) NOT NULL
);

CREATE TABLE pedido(
	id INT AUTO_INCREMENT PRIMARY KEY, 
    data_pedido DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    cliente_id INT NOT NULL, 
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE item_pedido( 
	id INT AUTO_INCREMENT PRIMARY KEY,
    quantidade INT NOT NULL,
    preco_unitario DECIMAL(10,2) NOT NULL,
    pedido_id INT NOT NULL,
    produto_id INT NOT NULL,
    FOREIGN KEY (pedido_id) REFERENCES pedido(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id)
);
	
	