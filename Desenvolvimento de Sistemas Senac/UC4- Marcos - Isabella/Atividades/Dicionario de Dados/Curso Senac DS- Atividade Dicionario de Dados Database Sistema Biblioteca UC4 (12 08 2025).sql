/* Você foi contratado para desenvolver o banco de dados de uma biblioteca onlime que precisa gerenciar informações sobre livros, usuários e empréstimos
Sua tarefa inicial é documentar as tabelas e campos que farão parte do banco de dados, criando um dicionário de dados que servirá como referência para a equipe de desenvolvimento,

O dicionário deve conteter:
- Nome da Tabela
- Descrição da Tabela
- Nome do Campo
- Tipo de Dado
- Descrição do Campo 

Dicas:
- Pense em quais informações são essenciais para o funcionamento do sistema
- Considere que um livro pode ter mais de um autor e que um usuário pode realizar vários empréstimos */

CREATE DATABASE BibliotecaON
USE BibliotecaON

CREATE TABLE TBL_Clientes 
(
	ID INT IDENTITY PRIMARY KEY,
	Nome VARCHAR(100),
	Data_Nascimento DATE
)

CREATE TABLE TBL_Emprestimos
(
	ID INT IDENTITY PRIMARY KEY,
	Data_Devolucao DATE,
	Data_Emprestimo DATE
)

CREATE TABLE TBL_Clientes_Emprestimos
(
	ID_Usuario_Emprestimo INT IDENTITY PRIMARY KEY,
	ID_Usuarios INT,
	ID_Emprestimos INT,
	FOREIGN KEY (ID_Usuarios) REFERENCES TBL_Clientes(ID),
	FOREIGN KEY (ID_Emprestimos) REFERENCES TBL_Emprestimos(ID)
)

CREATE TABLE TBL_Livros
(
	ID INT IDENTITY PRIMARY KEY,
	Genero VARCHAR(100),
	Nome VARCHAR(100)
)

CREATE TABLE TBL_Autor
(
	ID INT IDENTITY PRIMARY KEY,
	Nome VARCHAR(100),
	Genero CHAR(1)
)

CREATE TABLE TBL_Livros_Autor
(
	ID_Autor_Livros INT IDENTITY PRIMARY KEY,
	ID_Autor INT,
	ID_Livros INT,
	FOREIGN KEY (ID_Autor) REFERENCES TBL_Autor(ID),
	FOREIGN KEY (ID_Livros) REFERENCES TBL_Livros(ID)
)

INSERT INTO TBL_Clientes VALUES
('Maria Silva', '1985-03-12'),
('João Pereira', '1990-07-25'),
('Ana Costa', '1978-12-05')

INSERT INTO TBL_Emprestimos VALUES
('2025-02-10', '2025-01-05'),
('2025-02-15', '2025-01-08'),
('2025-02-20', '2025-01-12')

INSERT INTO TBL_Clientes_Emprestimos VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO TBL_Autor VALUES
('Carlos Drummond', 'M'),
('Clarice Lispector', 'F'),
('Machado de Assis', 'M');

INSERT INTO TBL_Livros VALUES
('Poesia', 'A Rosa do Povo'),
('Romance', 'A Hora da Estrela'),
('Romance', 'Dom Casmurro');

INSERT INTO TBL_Livros_Autor VALUES
(1, 1),
(2, 2),
(3, 3);

SELECT * FROM TBL_Clientes_Emprestimos
SELECT * FROM TBL_Livros_Autor