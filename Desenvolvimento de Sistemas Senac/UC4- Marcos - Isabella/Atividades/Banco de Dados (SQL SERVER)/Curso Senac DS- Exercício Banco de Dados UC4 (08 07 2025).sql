CREATE DATABASE Loja
USE Loja

CREATE TABLE tbl_Vendas --Usar o TAB para dar espaços para escrever comandos
(
	ID_Vendas INT IDENTITY,
	Data_Venda DATE,
	Preco DECIMAL (7,2),
	Nome_Cliente VARCHAR (255),
	Nome_Vendedor VARCHAR (255),
)

CREATE TABLE tbl_Produtos(
	ID_Produtos INT IDENTITY,
	Nome VARCHAR (255),
	Preco DECIMAL,
	Tipo VARCHAR (255)
	)

SELECT * FROM tbl_Vendas
SELECT * FROM tbl_Produtos

INSERT INTO tbl_Vendas VALUES
('2025-07-08', '17.50', 'Marcos', 'Nathan'),
('2025-10-02', '100.00', 'Otávio', 'Gustavo'),
('2012-04-13', '10000', 'Alfredo', 'Apolo'),
('2015-10-02', '100.00', 'Zoroastro', 'José'),
('8010-04-09', '8000.00', 'Luiz_XD', 'Lucas_:)'),
('8010-06-10', '8000.00', 'Luiz_XD', 'Lucas_:)'),
('2014-09-20', '80', 'Pedro', 'Betriz'),
('2009-08-30', '30', 'Aline', 'Isabella'),
('8000-10-24', '50', 'João', 'Kelly'),
('2045-05-25', '60', 'Yasmin', 'Edna'),
('1010-10-10', '70', 'Mônica', 'Rita')

INSERT INTO tbl_Produtos VALUES
('Arroz', '17.35', 'Alimento'),
('Pneu', '400.00', 'Carro'),
('Shampoo', '35.90', 'Higiene'),
('Mostarda', '10.90', 'Alimento'),
('Casaco', '95.90', 'Roupa'),
('Chocolate', '15.90', 'Alimento'),
('TV Smart 4K', '1545.90', 'Eletrônico'),
('Fígado', '29.90', 'Alimento'),
('Game God Of War PS4', '80.00', 'Eletrônico'),
('Pirulito', '7.90', 'Alimento')

TRUNCATE TABLE tbl_Vendas
TRUNCATE TABLE tbl_Produtos

DROP TABLE tbl_Vendas
DROP TABLE tbl_Produtos

GETDATE() --Pega a data atual