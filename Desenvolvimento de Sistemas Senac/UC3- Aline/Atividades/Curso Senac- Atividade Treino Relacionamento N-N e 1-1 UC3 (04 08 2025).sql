/* Você está desenvbolvendo um sistema de gerenciamento de uma loja de roupas. 
Cada produto pode ser classificado em várias categorias, e cada categoria pode conter vários produtos (N:N)

- Ao final da criação das tabelas, exiba todos os regitros de cada uma */

CREATE DATABASE Loja_Roupa
USE Loja_Roupa

CREATE TABLE TBL_Produto
(
ID_Produto INT PRIMARY KEY IDENTITY,
Preco DECIMAL(7,2),
Nome VARCHAR(100),
Quantidade_Estoque INT,
Posicao_Estoque VARCHAR(100)
)

INSERT INTO TBL_Produto VALUES
('149.90',	'Fone de Ouvido JBL', 25, 'A01'),
('23.50', 'Arroz Tio João', 2, 'B03'),
('12.99', 'Shampoo Seda', 40, 'C07'),
('9.50', 'Caderno 96 folhas', 4, 'D02'),
('8.20', 'Desinfetante Veja', 35, 'E05')

CREATE TABLE TBL_Categoria
(
ID_Categoria INT PRIMARY KEY IDENTITY,
Descricao VARCHAR(100)
)

INSERT INTO TBL_Categoria VALUES
('Eletrônicos'),
('Alimentos'),
('Higiene Pessoal'),
('Papelaria'),
('Limpeza Doméstica')

CREATE TABLE TBL_Produto_Categoria /* Relacinamento N:N das tabelas TBL_Produto e TBL_Categoria, pois foi
criado uma nova TBL, contendo as FKs de cada uma */
(
ID_Categoria INT,
ID_Produto INT,
PRIMARY KEY (ID_Categoria, ID_Produto),
FOREIGN KEY (ID_Categoria) REFERENCES TBL_Categoria (ID_Categoria),
FOREIGN KEY (ID_Produto) REFERENCES TBL_Produto (ID_Produto)
)

INSERT INTO TBL_Produto_Categoria VALUES
(1,1),
(2,2),
(3,3),
(4,4),
(5,5)

CREATE TABLE TBL_Estoque -- Relacinamento 1:1 com a Tabela TBL_Produto, pois a propria PK também é FK
(
ID_Estoque INT PRIMARY KEY,
Posicao_Estoque VARCHAR(100)
FOREIGN KEY (ID_Estoque) REFERENCES TBL_Produto (ID_Produto)
)

INSERT INTO TBL_Estoque VALUES
(1, '34E'),
(2, '14A'),
(3, '12H'),
(4, '10P'),
(5, '5L')

SELECT * FROM TBL_Produto
SELECT * FROM TBL_Categoria
SELECT * FROM TBL_Produto_Categoria
SELECT * FROM TBL_Estoque

DROP TABLE TBL_Produto
TRUNCATE TABLE TBL_Produto_Categoria