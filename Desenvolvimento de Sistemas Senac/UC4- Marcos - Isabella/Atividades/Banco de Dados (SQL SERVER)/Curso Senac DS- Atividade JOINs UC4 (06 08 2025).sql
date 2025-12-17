-- Atividade JOINS

CREATE DATABASE Hortifruti
USE Hortifruti

CREATE TABLE TBL_Fornecedores
(
	ID_Fornecedores INT IDENTITY PRIMARY KEY,
	Nome_Fornecedor VARCHAR(50) NOT NULL
)

INSERT INTO TBL_Fornecedores VALUES
('Frutas S.A.'),
('Naturais LTDA'),
('Orgânicos RIO'),
('Hort')

CREATE TABLE TBL_Produtos
(
	ID_Produto INT IDENTITY PRIMARY KEY,
	Nome_Produto VARCHAR(50),
	ID_Fornecedor INT,
	FOREIGN KEY (ID_Fornecedor) REFERENCES TBL_Fornecedores (ID_Fornecedores)
)

INSERT INTO TBL_Produtos VALUES
('Maça', 1),
('Banana', 2),
('Batata', NULL),
('Tomate', 3)

SELECT f.Nome_Fornecedor, p.Nome_Produto FROM TBL_Fornecedores f /* Para trocar a ordem, precisamos trocar a ordem do SELECT, na hora de colocar o nome dos campos do 
lado do SELECT */
INNER JOIN TBL_Produtos p ON p.ID_Fornecedor = f.ID_Fornecedores

SELECT p.Nome_Produto, f.Nome_Fornecedor FROM TBL_Fornecedores f /* Tipo Assim */
INNER JOIN TBL_Produtos p ON p.ID_Fornecedor = f.ID_Fornecedores

SELECT p.Nome_Produto, p.ID_Fornecedor FROM TBL_Produtos p -- Nessa tabela, vem tudo de produto, pois está a esquerda do LEFT JOIN
LEFT JOIN TBL_Fornecedores f ON p.ID_Fornecedor = f.ID_Fornecedores -- É comum relacionar a Chave primaria de uma tabela com a FK da outra tabela

SELECT p.Nome_Produto, f.Nome_Fornecedor FROM TBL_Produtos p -- Nessa tabela, vem tudo de fornecedor, pois está a esquerda do LEFT JOIN
RIGHT JOIN TBL_Fornecedores f ON p.ID_Fornecedor = f.ID_Fornecedores

SELECT p.Nome_Produto, f.Nome_Fornecedor FROM TBL_Produtos p -- Nessa tabela, vem todas as informações das duas tabelas
FULL JOIN TBL_Fornecedores f ON p.ID_Fornecedor = f.ID_Fornecedores

SELECT * FROM TBL_Fornecedores