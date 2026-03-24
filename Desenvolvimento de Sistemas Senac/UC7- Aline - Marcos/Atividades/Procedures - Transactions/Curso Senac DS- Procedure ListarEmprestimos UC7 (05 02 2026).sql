-- ================================================
-- Stored Procedure: sp_Empréstimo
-- Tema: Criação de um Método para Realizar Empréstimos
-- ================================================

CREATE PROCEDURE sp_ListarEmprestimos
	
AS
BEGIN

	BEGIN TRY 

        BEGIN TRAN;

       SELECT IdUsuario, Id FROM TBL_Emprestimos
			
			-- RAISERROR:
            -- - Emite um erro controlado 
            -- - Severidade 16 indica erro de negócio (não é fatal pro servidor)
            -- - A seguir link com código e explicação de severidades
            -- -https://learn.microsoft.com/pt-br/sql/relational-databases/errors-events/database-engine-error-severities?view=sql-server-ver17
            RAISERROR('LivroId %d não existe.', 16, 1, @Id_Livro);

            -- ROLLBACK:
            -- - Desfaz qualquer alteração feita desde o BEGIN TRAN
            ROLLBACK TRAN;

            -- RETURN:
            -- - Encerra a procedure aqui mesmo
			RETURN; 
		END

		-- =============================================================
        -- 3) CONTROLE DE ESTOQUE 
        -- "Verifique se QuantidadeDisponivel > 0"
        --
        -- O que fazer?
        -- - Fazemos um UPDATE que só funciona se ainda houver estoque.
        -- - Isso garante que o decremento (-1) acontece "junto" da validação.
        -- =============================================================

		UPDATE TBL_Livros
		SET QuantidadeDisponivel = QuantidadeDisponivel - 1
		WHERE Id = @Id_Livro
			AND QuantidadeDisponivel > 0;

        -- @@ROWCOUNT:
        -- - Retorna quantas linhas foram afetadas pelo comando anterior
        -- - Se deu 1: atualizou (havia estoque)
        -- - Se deu 0: não atualizou (sem estoque)

		IF @@ROWCOUNT = 1
		BEGIN 

             -- =========================================================
            -- 4) INSERIR O EMPRÉSTIMO
            -- DataEmprestimo NÃO precisa ser informada
            -- pois tem DEFAULT(GETDATE()) na tabela.
            -- =========================================================

			INSERT INTO TBL_Emprestimos (IdUsuario, LivroId, Situacao) VALUES
			(@Id_Usuario, @Id_Livro, 'Emprestado');

            UPDATE TBL_Usuarios
            SET LivrosEmprestados = LivrosEmprestados + 1
            WHERE Id = @Id_Usuario

            -- COMMIT:
            -- - Confirma a transação
            -- - Após COMMIT, não dá para "desfazer" automaticamente

			COMMIT TRAN;

            -- Mensagem amigável para o aluno ver no SSMS

			PRINT 'Empréstimo Realizado com Sucesso! Estoque Decrementado em -1.';

		END
		ELSE
		BEGIN

            -- =========================================================
            -- 5) SEM ESTOQUE
            -- - Exibe mensagem
            -- - Cancela tudo (ROLLBACK)
            -- =========================================================

			PRINT 'Não há Exemplares Disponíveis para este Livro. Operação Cancelada';

			ROLLBACK TRAN;
		END

	END TRY
	BEGIN CATCH

         -- =============================================================
        -- TRATAMENTO DE ERRO (CATCH)
        --
        -- Se qualquer erro acontecer no TRY:
        -- 1) Se houver transação aberta -> ROLLBACK
        -- 2) Devolve a mensagem do erro
        -- =============================================================

         -- @@TRANCOUNT:
        -- - Diz quantas transações estão abertas no momento
        -- - Se > 0, temos algo para desfazer com segurança
        IF @@TRANCOUNT > 0
            ROLLBACK TRAN;

         -- Captura mensagem real do erro para exibir ao aluno
        DECLARE @Mensagem NVARCHAR(4000) = ERROR_MESSAGE();

        -- Repassa o erro de forma controlada
        RAISERROR(@Mensagem, 16, 1);
    END CATCH
END
GO