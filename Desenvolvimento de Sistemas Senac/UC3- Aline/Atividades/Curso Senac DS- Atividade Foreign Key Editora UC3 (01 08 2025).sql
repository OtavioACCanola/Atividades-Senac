/* Atividade FOREGN KEY Livro e Autor 

1) Você foi  contratado para criar um banco de dados para gerenciamento de um sistema de livros e seus autores.
Cada autor pode escrever vários livros, mas cada livro tem apenas um autor.

Ao final da criação das tabelas, exiba todos os registros de cada uma	
*/

CREATE DATABASE Editora
USE Editora

CREATE TABLE TBL_Autores
(
ID_Autor INT IDENTITY PRIMARY KEY,
Nome VARCHAR (50),
Data_Nascimento DATE,
Sexo CHAR (1),
)

CREATE TABLE TBL_Livros
(
ID_Livro INT IDENTITY PRIMARY KEY,
Titulo VARCHAR (100),
Genero VARCHAR (50),
Data_Lancamento DATE,
ID_Autor INT,
FOREIGN KEY (ID_Autor) REFERENCES TBL_Autores(ID_Autor)
)

INSERT INTO TBL_Livros VALUES
('O Nome do Vento', 'Fantasia', '2007-03-27', 1),
('1984', 'Distopia', '1949-06-08', 2),
('A Culpa é das Estrelas', 'Romance', '2012-01-10', 3),
('O Código Da Vinci', 'Suspense', '2003-04-03', 4),
('O Hobbit', 'Aventura', '1937-09-21', 5)

INSERT INTO TBL_Autores VALUES
('Patrick Rothfuss', '1973-06-06', 'M'),
('Jane Austen', '1775-12-16', 'F'),
('J.K. Rowling', '1965-07-31', 'F'),
('Dan Brown', '1964-06-22', 'M'),
('Chimamanda Ngozi Adichie', '1977-09-15', 'F')

SELECT * FROM TBL_Autores
ORDER BY ID_Autor ASC

SELECT * FROM TBL_Livros
ORDER BY ID_Livro ASC

TRUNCATE TABLE TBL_Livros
