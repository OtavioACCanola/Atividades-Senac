USE LoginBanco
GO

-- Deletando o Usuário Todos e o Guest
REVOKE CONNECT FROM guest

SELECT sp.name
FROM sys.server_role_members srm
JOIN sys.server_principals sp
ON srm.member_principal_id = sp.principal_id
JOIN sys.server_principals sr
ON srm.role_principal_id = sr.principal_id
WHERE sr.name = 'sysadmin';


ALTER SERVER ROLE sysadmin DROP MEMBER [\Todos];

EXEC sp_droprolemember 'db_owner', 'senacedu\pedro.ppoliveira1'

GRANT CONNECT TO [senacedu\pedro.ppoliveira1];



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
ON TBL_Usuarios -- Nome da Tabela que Poderá ser Modificada pelo Usuário
TO [senacedu\pedro.ppoliveira1] -- A pessoa destinada para a função

GRANT INSERT -- Função que ele poderá designar na tabela
ON TBL_Usuarios -- Nome da Tabela que Poderá ser Modificada pelo Usuário
TO [senacedu\pedro.ppoliveira1] -- A pessoa destinada para a função

-- Tirando as Funções que o usuário criado não poderá realizar mais
REVOKE SELECT
ON TBL_Usuarios
FROM [senacedu\pedro.ppoliveira1]

-- Bloqueando Completamente as Funções para que o Usuário não possa mais usar
DENY SELECT -- Tira as Funções que ele conseguia fazer
ON TBL_Usuarios
TO [senacedu\pedro.ppoliveira1]

SELECT name
FROM sys.server_principals
WHERE is_disabled = 0

SELECT name, type_desc
FROM sys.server_principals

SELECT * FROM fn_my_permissions(null, 'DATABASE')

