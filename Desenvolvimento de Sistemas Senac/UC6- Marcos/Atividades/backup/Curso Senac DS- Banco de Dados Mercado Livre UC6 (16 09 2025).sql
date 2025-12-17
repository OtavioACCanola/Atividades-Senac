CREATE DATABASE MercadoLivre
USE MercadoLivre

CREATE TABLE TBL_Produtos
(
	ID INT PRIMARY KEY IDENTITY,
	Nome VARCHAR(50),
	Tipo_Produto VARCHAR(50)
)

INSERT INTO TBL_Produtos VALUES
('Esponja','limpeza')
