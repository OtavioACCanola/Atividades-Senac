CREATE DATABASE Transactions
GO

USE Transactions
GO

CREATE TABLE TBL_Livros
(
	Id INT PRIMARY KEY IDENTITY NOT NULL,
	Titulo VARCHAR (70) NOT NULL,
	Autor VARCHAR (50) NOT NULL,
	QuantidadeDisponivel INT DEFAULT 0 NOT NULL,
	CHECK (QuantidadeDisponivel >= 0)
)
GO

CREATE TABLE TBL_Emprestimos
(
	Id INT PRIMARY KEY IDENTITY NOT NULL,
	UsuarioId INT NOT NULL,
	LivroId INT NOT NULL,
	DataEmprestimo DATETIME DEFAULT (GETDATE()) NOT NULL,
	Situacao CHAR (9) NOT NULL,
	CONSTRAINT FK_Emprestimos_Livros
		FOREIGN KEY (LivroId) REFERENCES TBL_Livros(Id),
		FOREIGN KEY (UsuarioId) REFERENCES TBL_Usuarios(Id)
)
GO


CREATE TABLE TBL_Usuarios
(
	Id INT PRIMARY KEY IDENTITY NOT NULL,
	Nome VARCHAR (150) NOT NULL,
	Idade INT NOT NULL,
	LivrosEmprestados INT NOT NULL
)

SELECT e.Id, l.Titulo, u.Nome FROM dbo.TBL_Emprestimos e INNER JOIN TBL_Livros l ON e.LivroId = l.Id INNER JOIN TBL_Usuarios u ON e.IdUsuario = u.Id
WHERE e.Situacao = 'Emprestado' AND u.Id = 1


CREATE TABLE TBL_Funcionarios
(
	Id INT IDENTITY PRIMARY KEY,
	Nome VARCHAR (100),
	Salario DECIMAL (10,2),
	Cargo VARCHAR (100)
)

INSERT INTO TBL_Livros VALUES
('Dom Casmurro', 'Machado de Assis', 3),
('Felipe Neto - O Livro', 'Felipe Neto', 1),
('Uma Aventura Minecraft', 'Tazercraft', 0)
GO

SELECT * FROM TBL_Livros
SELECT * FROM TBL_Usuarios
SELECT * FROM TBL_Emprestimos

--============== Estrutura sem Procedures ==============:

--BEGIN TRAN

---- Caso 1
--IF (SELECT QuantidadeDisponivel FROM TBL_Livros WHERE Id = 8) >= 0 
--BEGIN 
--		INSERT INTO TBL_Emprestimos VALUES
--		('Otávio', 8, GETDATE())
--	UPDATE TBL_Livros
--	SET QuantidadeDisponivel = QuantidadeDisponivel - 1
--	WHERE Id = 8
--	COMMIT
--END
--ELSE
--BEGIN
--	PRINT 'Não tem Livros Disponíveis no Estoque!'
--	ROLLBACK
--END

-- ============== DROPS e TRUNCATES ============== 


--TRUNCATE TABLE TBL_Livros
--TRUNCATE TABLE TBL_Emprestimos
--DROP TABLE TBL_Livros
--DROP TABLE TBL_Emprestimos

--TESTES PROCEDURES DE EMPRÉSTIMO

-- Deve funcionar (livro com 3)
EXEC dbo.sp_RealizarEmprestimo 'Aluno Teste 1', 1;

-- Deve funcionar 1 vez e depois bloquear (livro com 1)
EXEC sp_RealizarEmprestimo 'Aluno Teste 2', 2;
EXEC sp_RealizarEmprestimo 'Aluno Teste 3', 2;

-- Deve bloquear direto (livro com 0)
EXEC sp_RealizarEmprestimo 'Aluno Teste 4', 3;

SELECT * FROM TBL_Livros;
SELECT * FROM TBL_Emprestimos ORDER BY Id DESC;


-- 1) Fazer empréstimos
EXEC sp_RealizarEmprestimo 'Aluno A', 1;
EXEC sp_RealizarEmprestimo 'Aluno B', 1;

-- Verificar estoque e empréstimos
SELECT * FROM TBL_Livros;
SELECT * FROM TBL_Emprestimos ORDER BY Id DESC;

-- 2) Devolver um empréstimo
-- Pegue um Id real no SELECT de Emprestimos e use aqui:
EXEC sp_DevolverLivro @Id_Emprestimo = 10;

-- Conferir resultado
SELECT * FROM TBL_Livros;
SELECT * FROM TBL_Emprestimos ORDER BY Id DESC;

