
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author: Otávio Augusto Canola do Carmo
-- Create date: 16/09/25
-- Description:	Backup da base de dados
-- =============================================
ALTER PROCEDURE sp_FazerBackup
AS
BEGIN
	
	DECLARE @SQL VARCHAR(MAX) -- Numero máximo de caracteres para salvar

	SET @SQL = BACKUP DATABASE MercadoLivre
		TO DISK = 'C:\temp\BACKUP.bak'
		WITH FORMAT, INIT, NAME = 'Backup do banco MercadoLivre';

	EXEC(@SQL)

END
GO
