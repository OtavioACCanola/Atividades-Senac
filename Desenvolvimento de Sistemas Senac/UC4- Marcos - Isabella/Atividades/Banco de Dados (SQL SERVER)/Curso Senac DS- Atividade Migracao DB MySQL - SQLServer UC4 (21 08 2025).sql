/* Legenda:
   Pintado Azul = NOT NULL
   Não Pintado Azul = S/ NOT NULL
   Pintado de Amarelo = PK
   Pintado de Vermelho = FK
   INT sem determinar quantidade
   Sem trocar o nome das variáveis 
   Pode pegar dados para insertar no CharGPT */

CREATE DATABASE Migracao
USE Migracao

CREATE TABLE tbl_endereco
(
	id INT IDENTITY PRIMARY KEY NOT NULL,
	cep INT, 
	logradouro VARCHAR(90) NOT NULL,
	bairro VARCHAR(50) NOT NULL, 
	cidade VARCHAR (50) NOT NULL ,
	estado CHAR (2) NOT NULL,
)

INSERT INTO tbl_endereco VALUES-- Inserir no mínimo 10 valores
(11000111, 'Rua das Flores', 'Centro', 'São Paulo', 'SP'),
(22000222, 'Av. Brasil', 'Copacabana', 'Rio de Janeiro', 'RJ'),
(33000333, 'Rua Minas', 'Savassi', 'Belo Horizonte', 'MG'),
(44000444, 'Rua Bahia', 'Barra', 'Salvador', 'BA'),
(55000555, 'Rua Recife', 'Boa Viagem', 'Recife', 'PE'),
(66000666, 'Av. Amazonas', 'Cidade Nova', 'Manaus', 'AM'),
(77000777, 'Rua Goiás', 'Setor Bueno', 'Goiânia', 'GO'),
(88000888, 'Av. Ipiranga', 'Centro Histórico', 'Porto Alegre', 'RS'),
(99000999, 'Rua Paraná', 'Centro', 'Curitiba', 'PR'),
(10101010, 'Rua Brasília', 'Asa Sul', 'Brasília', 'DF')

CREATE TABLE tbl_cliente
(
	cod_cliente INT IDENTITY PRIMARY KEY,
	nome_cliente VARCHAR(45) NOT NULL,
	cpf VARCHAR(11),
	data_nasc DATE,
	id_endereco INT,
	numero VARCHAR(10),
	complemento VARCHAR(20),
	FOREIGN KEY (id_endereco) REFERENCES tbl_endereco (id)
)

INSERT INTO tbl_cliente VALUES
('Ana Silva', '12345678901', '1990-05-12', 1, '123', 'Apto 101'),
('Carlos Souza', '23456789012', '1985-05-20', 2, '456', 'Casa'),
('Mariana Lima', '34567890123', '1992-05-15', 3, '789', 'Bloco B'),
('João Pedro', '45678901234', '1988-10-25', 4, '321', 'Fundos'),
('Fernanda Costa', '56789012345', '1995-12-30', 5, '654', 'Apto 202'),
('Lucas Rocha', '67890123456', '1993-06-18', 6, '987', 'Sala 3'),
('Patrícia Mendes', '78901234567', '1980-01-05', 7, '159', 'Loja 1'),
('Rafael Gomes', '89012345678', '1999-07-07', 8, '753', 'Apto 303'),
('Juliana Alves', '90123456789', '1987-09-09', 9, '852', 'Casa 2'),
('Bruno Ferreira', '01234567890', '1991-11-11', 10, '951', 'Cobertura')

CREATE TABLE tbl_pedido
(
	cod_pedido INT IDENTITY PRIMARY KEY,
	data_pedido DATE,
	data_entrega DATE,
	cod_cliente INT NOT NULL,
	FOREIGN KEY (cod_cliente) REFERENCES tbl_cliente (cod_cliente)
)

INSERT INTO tbl_pedido VALUES
('2025-07-01', '2025-08-05', 1),
('2025-05-02', '2025-08-06', 2),
('2025-06-03', '2025-08-07', 3),
('2025-04-04', '2025-08-09', 4),
('2025-04-05', '2025-08-10', 5),
('2025-05-06', '2025-08-12', 7),
('2025-06-07', '2025-08-13', 7),
('2025-07-08', '2025-08-15', 8),
('2025-04-09', '2025-08-16', 9),
('2025-04-10', '2025-08-18', 10)

CREATE TABLE tbl_produto
(
	cod_produto INT IDENTITY PRIMARY KEY,
	nome_produto VARCHAR(100) NOT NULL,
	desc_produto VARCHAR(100) NOT NULL,
	unid_medida VARCHAR(2) NOT NULL,
	estoque_atual INT,
	estoque_min INT,
	estoque_max INT,
	valor DECIMAL(10,2) NOT NULL
)

INSERT INTO tbl_produto VALUES
('Notebook Dell', 'Notebook Inspiron 15', 'UN', 20, 5, 50, 3500.00),
('Mouse Logitech', 'Mouse sem fio', 'UN', 100, 20, 200, 120.00),
('Teclado Mecânico', 'Teclado gamer RGB', 'UN', 50, 10, 100, 300.00),
('Monitor Samsung', 'Monitor LED 24"', 'UN', 30, 5, 70, 900.00),
('Impressora HP', 'Impressora multifuncional', 'UN', 15, 3, 40, 650.00),
('HD Externo', 'HD 1TB Seagate', 'UN', 40, 8, 100, 400.00),
('Pendrive 64GB', 'Pendrive Sandisk', 'UN', 200, 50, 300, 60.00),
('Cadeira Gamer', 'Cadeira ergonômica', 'UN', 25, 5, 60, 1200.00),
('Smartphone Samsung', 'Galaxy S22', 'UN', 35, 10, 80, 4500.00),
('Tablet Apple', 'iPad 10ª Geração', 'UN', 18, 4, 40, 5200.00)

CREATE TABLE tbl_itempedido
(
	qtde INT NOT NULL,
	i_cod_pedido INT NOT NULL,
	i_cod_produto INT NOT NULL,
	i_valor DECIMAL (10,2) NOT NULL
	FOREIGN KEY (i_cod_pedido) REFERENCES tbl_pedido (cod_pedido),
	FOREIGN KEY (i_cod_produto) REFERENCES tbl_produto (cod_produto)
)

INSERT INTO tbl_itempedido VALUES
(2, 1, 2, 240.00),   
(1, 1, 3, 300.00),   
(1, 2, 1, 3500.00),  
(2, 2, 4, 1800.00),  
(1, 3, 7, 650.00),   
(3, 4, 7, 180.00),   
(1, 5, 8, 1200.00),  
(1, 6, 9, 4500.00),  
(1, 7, 10, 5200.00), 
(2, 8, 6, 800.00)

-- Atividade 3
SELECT * FROM tbl_cliente
WHERE data_nasc
BETWEEN '1960' AND '1990'

-- Atividade 4
SELECT COUNT(*) AS Total, MONTH(data_nasc) AS Mês 
FROM tbl_cliente
GROUP BY MONTH(data_nasc)
ORDER BY Total DESC

-- Atividade 5
SELECT COUNT(*) AS Total, MONTH(data_pedido) AS Mês
FROM tbl_pedido
GROUP BY (MONTH(data_pedido))
ORDER BY Total DESC

-- Atividade 6
SELECT MIN(valor) AS Valor_Mínimo
FROM tbl_produto                       -- Essas duas linhas mostram o mínimo valor da tabela, sem mostrar ela inteira
--GROUP BY (valor)
--ORDER BY Valor_Mínimo ASC

-- Atividade 7
SELECT qtde, i_cod_produto
FROM tbl_itempedido
ORDER BY (qtde) ASC

-- Atividade 8
SELECT SUM(estoque_atual) AS SomaTotal
FROM tbl_produto

-- Atividade 9
SELECT AVG(estoque_atual) AS MédiaTotal
FROM tbl_produto

-- Atividade 10
SELECT SUM(valor * estoque_atual) AS ValorTotalProdutos -- Faz o calculo de todos os produtos, até os que se repetem, com o valor deles
FROM tbl_produto


-- SELECTs Comuns
SELECT * FROM tbl_cliente
SELECT * FROM tbl_pedido
SELECT * FROM tbl_produto
SELECT * FROM tbl_endereco
SELECT * FROM tbl_itempedido














TRUNCATE TABLE tbl_Cliente
TRUNCATE TABLE tbl_Endereco
TRUNCATE TABLE tbl_Pedido
TRUNCATE TABLE tbl_Produto
TRUNCATE TABLE tbl_itempedido

DROP TABLE tbl_cliente
DROP TABLE tbl_endereco
DROP TABLE tbl_pedido
DROP TABLE tbl_produto
DROP TABLE tbl_itempedido