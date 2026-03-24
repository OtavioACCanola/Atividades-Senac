-- ================================================
-- Stored Procedure: sp_RealizarEmpréstimo
-- Tema: Criação de um Método para Realizar Empréstimos
-- ================================================

CREATE OR ALTER PROCEDURE sp_RealizarEmprestimo 
	@Aluno VARCHAR (150), -- Criando Variável de que Está Pegando o Livro
	@Id_Livro INT -- Criando Variável do Id do Livro Pego
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
        -- 2) VALIDAR SE O LIVRO EXISTE
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

		IF NOT EXISTS (
			SELECT 1
			FROM TBL_Livros WITH (UPDLOCK, HOLDLOCK) -- Trava a Operação dessa Tabela enquanto Estiver Rodando a Procedure
			WHERE Id = @Id_Livro
		)
		BEGIN 
			
			-- RAISERROR:
            -- - Emite um erro controlado 
            -- - Severidade 16 indica erro de negócio (não é fatal pro servidor)
            -- - A seguir link com código e explicação de severidades
            -- -https://learn.microsoft.com/pt-br/sql/relational-databases/errors-events/database-engine-error-severities?view=sql-server-ver17
            RAISERROR('Id_Livro %d não existe.', 16, 1, @Id_Livro);

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

			INSERT INTO TBL_Emprestimos (Aluno, LivroId, Situacao) VALUES
			(@Aluno, @Id_Livro, 'Emprestado');

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