CREATE DATABASE LoginBanco;
GO

USE LoginBanco;
GO

CREATE TABLE TBL_Usuarios
(
	Id INT PRIMARY KEY IDENTITY(1,1),
	Nome VARCHAR(100) NOT NULL,
	Email VARCHAR(100) NOT NULL UNIQUE,
	Senha VARCHAR(50) NOT NULL
);
GO

INSERT INTO TBL_Usuarios (Nome, Email, Senha) VALUES
('Otávio', 'otavio@gmail.com', '123');

SELECT * FROM TBL_Usuarios