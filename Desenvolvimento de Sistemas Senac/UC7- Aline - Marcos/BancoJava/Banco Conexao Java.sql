CREATE DATABASE JavaBanco
GO --Serve para o código ir direto, sem precisar ficar selecionando

USE JavaBanco
GO

CREATE TABLE Usuarios(
	ID INT IDENTITY(1,1) PRIMARY KEY, -- No parênteses o valor da esquerda é onde começa e o da direita que encrementa de 1 em 1
	UserName VARCHAR(50) NOT NULL UNIQUE,
	Senha VARCHAR(50) NOT NULL
)
GO

INSERT INTO Usuarios (UserName, Senha) VALUES
('Admin', '1234'), 
('Aline', 'senha')

SELECT * FROM Usuarios