-- ================================================
-- Template generated from Template Explorer using:
-- Create Procedure (New Menu).SQL
--
-- Use the Specify Values for Template Parameters 
-- command (Ctrl-Shift-M) to fill in the parameter 
-- values below.
--
-- This block of comments will not be included in
-- the definition of the procedure.
-- ================================================
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:	Otávio Augusto Canola do Carmo>
-- Create date: 09/09/25
-- Description:	Procedure que insere informações para TBL_Livros
-- =============================================
CREATE PROCEDURE SP_Inserir_Livros_I
(
	@Titulo VARCHAR(100) ,
	@Autor VARCHAR(100),
	@Ano_Publicacao INT,
	@Genero VARCHAR(50)
)
AS
BEGIN
	INSERT INTO TBL_Livros VALUES
	(@Titulo, @Autor, @Ano_Publicacao, @Genero)
END
GO -- Para criar uma Procedure você seleciona a procedure do CREATE PROCEDURE até o GO e executa o comando para criar

EXEC SP_Inserir_Livros_I 'Doncasmurro','Machado de Asis', 1890, 'Romance'
EXEC SP_Inserir_Livros_I 'oi', 'h', 78, 'asjd'
SELECT * FROM TBL_Livros