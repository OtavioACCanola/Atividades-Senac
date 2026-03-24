-- ================================================
-- Stored Procedure: sp_AdicionarUsuario
-- Tema: Procedure para Inserção de novos Usuarios
-- ================================================

CREATE OR ALTER PROCEDURE sp_AdicionarUsuario
	@Nome VARCHAR (150), -- Criando Variável do nome do Usuario
	@Idade VARCHAR (150) -- Criando Variável da Idade do Usuario
AS
BEGIN
	
	-- SET NOCOUNT ON:
    -- - Evita mensagens automáticas "X linhas afetadas"
    -- - Ajuda em procedures (menos “poluição” no resultado)
	
	SET NOCOUNT ON; -- Não Recebe Mensagens no Terminal

	-- TRY...CATCH:
    -- - TRY: onde colocamos o "código normal"
    -- - CATCH: executa se ocorrer qualquer erro dentro do TRY

	BEGIN TRY 

	 -- =============================================================
        -- 1) INÍCIO DA TRANSAÇÃO
        -- A partir daqui: ou TUDO dá certo -> COMMIT
        -- ou QUALQUER problema -> ROLLBACK (desfaz tudo)
        -- =============================================================
        BEGIN TRAN;


		-- =============================================================
        -- 2) CONTROLE DE ESTOQUE 
        -- "Verifique se QuantidadeDisponivel > 0"
        --
        -- O que fazer?
        -- - Fazemos um Insert para criar o livro.
        -- =============================================================

		INSERT INTO TBL_Usuarios (Nome, Idade, LivrosEmprestados) VALUES
		(@Nome, @Idade, 0)

        -- @@ROWCOUNT:
        -- - Retorna quantas linhas foram afetadas pelo comando anterior
        -- - Se deu 1: atualizou (havia estoque)
        -- - Se deu 0: não atualizou (sem estoque)

		IF @@ROWCOUNT = 1
		BEGIN 

             -- Mensagem amigável para o aluno ver no SSMS
             PRINT 'Usuario Criado com Sucesso'
            -- - Após COMMIT, não dá para "desfazer" automaticamente

			COMMIT TRAN;

		END

        ELSE
            BEGIN 

            PRINT 'Ocorreu um Erro na Criação do Usuário'
            
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