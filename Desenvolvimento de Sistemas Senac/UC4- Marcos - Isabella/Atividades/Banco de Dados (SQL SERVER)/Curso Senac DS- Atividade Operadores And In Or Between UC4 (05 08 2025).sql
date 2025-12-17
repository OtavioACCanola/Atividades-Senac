CREATE DATABASE Lojao
USE Lojao

CREATE TABLE TBL_Vendas
(
ID_Venda INT IDENTITY PRIMARY KEY,
Nome_Cliente VARCHAR (50),
Nome_Produto VARCHAR (50),
Quantidade INT,
Preco_Total DECIMAL(10,2),
Data_Venda DATE
)

INSERT INTO TBL_Vendas VALUES
('Ana Silva', 'Notebook Dell', 1, '3500.00', GETDATE()),
('João Pereira',	'Smartphone Samsung',	2,	'4800.00', GETDATE()),
('Maria Oliveira',	'Fone de Ouvido JBL',	3,	'750.00', GETDATE()),
('Lucas Santos', 'Monitor LG', 1,	'1200.00',	GETDATE()),
('Fernanda Souza', 'Impressora Epson', 1,	'950.00',	GETDATE()),
('Bruno Carvalho', 'Tablet Lenovo', 2,	'2600.00',	GETDATE()),
('Camila Andrade', 'Teclado Mecânico', 4,	'1200.00',	GETDATE()),
('Rafael Almeida', 'Mouse Sem Fio', 5,	'450.00',	GETDATE()),
('Juliana Costa','Câmera Canon', 1,	'3200.00',	GETDATE()),
('Pedro Martins', 'HD Externo 1TB', 3, '900.00', GETDATE())

SELECT * FROM TBL_Vendas
WHERE Nome_Produto
IN ('Mouse sem fio', 'Câmera Canon')

SELECT * FROM TBL_Vendas
WHERE Quantidade
BETWEEN 2 AND 3

SELECT * FROM TBL_Vendas
WHERE Nome_Cliente= 'Lucas Santos'
OR Nome_Produto= 'Câmera Canon'

SELECT * FROM TBL_Vendas
WHERE Nome_Cliente= 'Bruno Carvalho'
AND Nome_Produto= 'Tablet Lenovo'
