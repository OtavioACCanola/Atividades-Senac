-- Atividade Joins e Subconsultas

CREATE DATABASE Sacolao
USE Sacolao

CREATE TABLE TBL_Fornecedores
(
	ID_Fornecedor INT IDENTITY PRIMARY KEY,
	Nome_Fornecedor VARCHAR(50) NOT NULL
)

INSERT INTO TBL_Fornecedores VALUES
('Frutas S.A'),
('Naturais LTDA'),
('Orgânicos RIO')

CREATE TABLE TBL_Produtos
(
	ID_Produto INT IDENTITY PRIMARY KEY,
	Nome_Produto VARCHAR(50),
	ID_Fornecedor INT,
	FOREIGN KEY (ID_Fornecedor) REFERENCES TBL_Fornecedores(ID_Fornecedor)
)

INSERT INTO TBL_Produtos VALUES
('Maça', 1),
('Banana', 2),
('Batata', NULL),
('Tomate', 3)

SELECT f.Nome_Fornecedor, p.Nome_Produto FROM TBL_Fornecedores f
INNER JOIN TBL_Produtos p ON p.ID_Fornecedor = f.ID_Fornecedor

SELECT p.Nome_Produto AS 'No_Po', f.Nome_Fornecedor From TBL_Produtos p
LEFT JOIN TBL_Fornecedores f ON p.ID_Fornecedor = f.ID_Fornecedor

CREATE TABLE TBL_Aluno
(
	ID_Aluno INT IDENTITY PRIMARY KEY,
	Nome VARCHAR(100)
)

INSERT INTO TBL_Aluno VALUES
('João Silva'),
('Maria Oliveira'),
('Pedro Santos')

CREATE TABLE TBL_Cursos
(
	ID_Curso INT IDENTITY PRIMARY KEY,
	Nome VARCHAR(100)
)

INSERT INTO TBL_Cursos VALUES
('Python'),
('SQL'),
('Java')

CREATE TABLE TBL_Matriculas
(
	ID INT IDENTITY PRIMARY KEY,
	ID_Aluno int,
	ID_Curso int,
	DataMatricula DATE,
	FOREIGN KEY (ID_Aluno) REFERENCES TBL_Aluno (ID_Aluno),
	FOREIGN KEY (ID_Curso) REFERENCES TBL_Cursos (ID_Curso)
)

INSERT INTO TBL_Matriculas VALUES
(1,1,'2023-01-15'),
(1,2,'2023-02-20'),
(2,1,'2023-01-20'),
(2,2,'2023-03-05'),
(3,1,'2023-02-01')

SELECT a.Nome FROM TBL_Aluno a
INNER JOIN TBL_Matriculas m ON a.ID_Aluno = m.ID_Aluno
WHERE ID_Curso= 1