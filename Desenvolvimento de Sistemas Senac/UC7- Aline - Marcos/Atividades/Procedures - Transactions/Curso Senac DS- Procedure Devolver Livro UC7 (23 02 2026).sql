-- =====================================================================
-- SP: sp_DevolverLivro
-- - BEGIN TRAN
-- - Verifica se o empréstimo existe
-- - Confere o LivroId associado
-- - Incrementa estoque (+1)
-- - Remove o empréstimo (para indicar devolução)
-- - COMMIT ou ROLLBACK
-- =====================================================================

CREATE OR ALTER PROCEDURE sp_DevolverLivro
    @Id_Emprestimo INT,
    @Msg_Retorno NVARCHAR(200) OUTPUT 
AS
BEGIN
    SET NOCOUNT ON;

    BEGIN TRY
        -- Abre transação (incrementa @@TRANCOUNT)
        BEGIN TRAN;

        IF NOT EXISTS (SELECT 1 FROM TBL_Emprestimos WHERE Id = @ID_Emprestimo)
        BEGIN
            SET @Msg_Retorno = 'Empréstimo não encontrado.';
            SELECT @Msg_Retorno;

            ROLLBACK TRAN;
            RETURN;
        END

        DECLARE @LivroId INT;

        SELECT @LivroId = LivroId
        FROM TBL_Emprestimos
        WHERE Id = @Id_Emprestimo;

        UPDATE TBL_Livros
        SET QuantidadeDisponivel = QuantidadeDisponivel + 1
        WHERE Id = @LivroId;

        -- Fazer um Jeito para Não deletar (Colocar uma coluna na TBL_Emprestimos de Situação)
        UPDATE TBL_Emprestimos
        SET Situacao = 'Devolvido'
        WHERE Id = @Id_Emprestimo;

        UPDATE TBL_Usuarios
        SET LivrosEmprestados = LivrosEmprestados - 1
        -- COMMIT reduz @@TRANCOUNT
        COMMIT TRAN;

        SET @Msg_Retorno = 'Devolução realizada com sucesso!';
        SELECT @Msg_Retorno

    END TRY
    BEGIN CATCH

        -- =========================================================
        -- @@TRANCOUNT indica quantas transações estão abertas.
        --
        -- Se for maior que 0:
        -- significa que ainda existe uma transação ativa
        -- e precisamos desfazer para evitar inconsistência.
        --
        -- Isso é MUITO importante em TRY/CATCH.
        -- =========================================================
        IF @@TRANCOUNT > 0
            ROLLBACK TRAN;

        DECLARE @Mensagem NVARCHAR(4000) = ERROR_MESSAGE();
        RAISERROR(@Mensagem, 16, 1);
    END CATCH
END
GO
