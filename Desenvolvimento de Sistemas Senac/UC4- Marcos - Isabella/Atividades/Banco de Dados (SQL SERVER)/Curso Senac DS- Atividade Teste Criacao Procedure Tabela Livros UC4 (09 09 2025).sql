USE Aprendendo_Procedure

CREATE TABLE TBL_Livros
(
	ID INT IDENTITY PRIMARY KEY,
	Titulo VARCHAR(100),
	Autor VARCHAR(100),
	Ano_Publicacao INT,
	Genero VARCHAR(50)
)

DROP Table TBL_Livros
TRUNCATE TABLE TBL_Livros
SELECT * FROM TBL_Livros
