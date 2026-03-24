CREATE DATABASE DBO_Biblioteca
GO

USE DBO_Biblioteca

CREATE TABLE TBL_Usuarios
(
	Id INT PRIMARY KEY IDENTITY NOT NULL,
	Nome VARCHAR (100) NOT NULL,
	Idade INT NOT NULL,
	Livros_Emprestados INT NOT NULL,
	Id_Livros INT NOT NULL,
	FOREIGN KEY (Id_Livros) REFERENCES TBL_Livros(id)
)
GO

CREATE TABLE TBL_Funcionarios
(
	Id INT PRIMARY KEY IDENTITY NOT NULL,
	Nome VARCHAR (100) NOT NULL,
	Salario DECIMAL (9,2) NOT NULL
)
GO

CREATE TABLE TBL_Livros
(
	Id INT PRIMARY KEY IDENTITY NOT NULL,
	Titulo VARCHAR (100) NOT NULL,
	Autor VARCHAR (100) NOT NULL,
	Disponível BIT NOT NULL
)
GO

SELECT name
FROM sys.database_principals
WHERE type_desc IN ('SQL_USER', 'WINDOWS_USER')

REVOKE CONNECT FROM guest

SELECT sp.name
FROM sys.server_role_members srm
JOIN sys.server_principals sp
ON srm.member_principal_id = sp.principal_id
JOIN sys.server_principals sr
ON srm.member_principal_id = sr.principal_id
WHERE sr.name = 'sysadmin'