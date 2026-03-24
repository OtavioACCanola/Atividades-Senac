USE LoginBanco
GO

-- Criação de um Login que poderá entrar no meu sql (Criando para o Usuário Windows da Máquina do Pedro)

CREATE LOGIN [senacedu\pedro.ppoliveira1] 
FROM WINDOWS;
GO

-- Criando usuário para poderá mexer na minha tabela

CREATE USER [senacedu\pedro.ppoliveira1] 
FOR LOGIN [senacedu\pedro.ppoliveira1]
GO

-- Dando as Funções que o usuário criado poderá realizar

GRANT SELECT -- Função que ele poderá designar na tabela
ON Usuarios -- Nome da Tabela que Poderá ser Modificada pelo Usuário
TO [senacedu\pedro.ppoliveira1] -- A pessoa destinada para a função