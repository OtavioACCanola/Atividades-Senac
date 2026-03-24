-- ================================================
-- Stored Procedure: sp_AdicionarLivro
-- Tema: Procedure para Inserção de novos livros
-- ================================================

CREATE OR ALTER PROCEDURE sp_AdicionarLivro
	@titulo VARCHAR (150), -- Criando Variável do Titulo do Livro
	@Autor VARCHAR (150), -- Criando Variável do Autor do Livro
    @Quantidade INT -- Criando Variável da Quantidade de Livros
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
        -- 2) VALIDAR SE O LIVRO JÁ EXISTE
        --
        -- EXISTS:
        -- - Retorna TRUE se a consulta encontrar qualquer linha
        --
        -- SELECT 1:
        -- - É só um "marcador" (mais leve do que trazer colunas)
        --
        -- WITH (UPDLOCK, HOLDLOCK):
        -- - UPDLOCK: já pega um lock de atualização na linha
        -- - HOLDLOCK: segura o lock até o fim da transação
        -- Objetivo: evitar concorrência (2 alunos pegarem o último exemplar)
        -- =============================================================

		IF EXISTS (
			SELECT 1
			FROM TBL_Livros WITH (UPDLOCK, HOLDLOCK) -- Trava a Operação dessa Tabela enquanto Estiver Rodando a Procedure
			WHERE Titulo = @titulo
		)
		BEGIN 
			
			-- RAISERROR:
            -- - Emite um erro controlado 
            -- - Severidade 16 indica erro de negócio (não é fatal pro servidor)
            -- - A seguir link com código e explicação de severidades
            -- -https://learn.microsoft.com/pt-br/sql/relational-databases/errors-events/database-engine-error-severities?view=sql-server-ver17
            RAISERROR('Já existe um livro com esse nome.', 16, 1, @Titulo);

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
        -- - Fazemos um Insert para criar o livro.
        -- =============================================================

        IF @Quantidade > 0 
            
            BEGIN
    		
                INSERT INTO TBL_Livros (Titulo, Autor, QuantidadeDisponivel, Disponivel) VALUES
	    	    (@titulo, @Autor, @Quantidade, 'Sim')

                -- @@ROWCOUNT:
                -- - Retorna quantas linhas foram afetadas pelo comando anterior
                -- - Se deu 1: atualizou (havia estoque)
                -- - Se deu 0: não atualizou (sem estoque)

		        IF @@ROWCOUNT = 1
		        BEGIN 
            
                    -- Mensagem amigável para o aluno ver no SSMS
                    PRINT 'Livro Criado com Sucesso'
                    -- Após COMMIT, não dá para "desfazer" automaticamente
         
    	    		COMMIT TRAN;
                END
            END

       ELSE
            
           BEGIN
                
                 PRINT 'Não é Possível Criar um Livro sem exemplares ou com exemplares negativos'

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