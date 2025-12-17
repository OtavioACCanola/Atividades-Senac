/*
Atividade: Crie um banco de dados chamado Spotify. Depois, crie uma tabela que armazene alguns dados de música. 
Inclua nessa tabela registros e, ao final, mostre todos os resultados dessa tabela que tenha como estilo "rock"
*/

CREATE DATABASE Spotify

USE Spotify

CREATE TABLE TBL_Musicas (
ID INT IDENTITY PRIMARY KEY,
Nome VARCHAR (100),
Genero VARCHAR (50),
Artista VARCHAR (100),
Data_Lancamento INT
)

SELECT * FROM TBL_Musicas
WHERE Genero= 'Rock'

INSERT INTO TBL_Musicas VALUES
('Deixa Tudo Como Ta', 'Pagade', 'Thiaguinho', 2019),
('Dont Look Back in Anger',	'Rock', 'Oasis', 1996),
('Final Feliz', 'MPB', 'Jorge Vercillo', 1996)