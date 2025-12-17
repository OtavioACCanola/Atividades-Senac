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

/* Crie uma tabela chamada Playlist. Inclua nessa tabela ao menos 10 playlists diferentes e seus dados como: 
Criador, duração, quantidade de músicas, etc
Ao final faça:
- Exiba todas as playlists en orden alfabética pelo nome de cada uma
- Exiba somente o nome das playlists que comecem com a letra "A" (Se não tiver nenhuma, escolha outra letra)
*/

CREATE TABLE TBL_Playlist (
ID INT IDENTITY PRIMARY KEY,
Nome VARCHAR (100),
Criador VARCHAR (50),
Duracao VARCHAR (15),
Quantidade_Musica INT,
Data_Criacao DATE
)

INSERT INTO TBL_Playlist VALUES
('Balocobaco', 'Milton', '2h', 40, '2012-10-02'),
('Pagode', 'Thiaguinho', '4h30min', 120, '2010-04-25'),
('Rock', 'Oasis', '2h45', 68, '2017-05-16'),
('Pop', 'Taylor Swift', '3h30min', 90, '2012-05-25'),
('MPB', 'Jorge Vercillo', '45min', 30, '2010-03-15'),
('Pop', 'Bruno Mars', '8h', 80, '2016-08-09'),
('Rock', 'New Radical', '45min', 30, '2009-02-28'),
('Samba', 'Zeca', '32min', 16, '2007-04-09'),
('MOB', 'Tim Maia', '4h35min', 92, '1997-05-31'),
('Sertanejo', 'Chitãozinho e Xororó', '3min', 1, '2006-09-25')

SELECT * FROM TBL_Playlist 
ORDER BY Nome ASC

SELECT * FROM TBL_Playlist
WHERE Nome LIKE 'P%'

/* No banco do Spotify, vamos criar uma nova tabela para armazenar informações sobre álbuns. Esta tabela deve conter os seguintes dados: nome do álbum, ano de lançamento, número de músicas, artistas e gênero.
Insira pelo menos 10 álbuns diferentes ns tabela, com dados fictícios para nome, artista, ano de lançamento, número de músicas e gênero.
- Exiba todos os álbuns em ordem decrescente pelo ano de lançamento;
- Exiba somente o nome dos álbuns que pertençam ao gênero "Rock";
- Exiba o nome e o artista dos álbuns que tenham mais de 10 músicas */

CREATE TABLE Albuns (
ID INT IDENTITY PRIMARY KEY,
Nome_Album VARCHAR (100),
Ano_Lancamento INT,
Numero_Musicas INT,
Artista VARCHAR (100),
Genero VARCHAR (50)
)

INSERT INTO Albuns VALUES
('Divide', 2017, 16, 'ED Sheeran', 'Pop'),  
('Thriller', 1982, 9, 'Michael Jackson', 'Pop'),  
('Back in Black', 1980, 10, 'AC/DC', 'Rock'),
('25', 2015, 11, 'Adele', 'Soul'), 
('AM', 2013, 12, 'Artic Monkeys', 'Rock'),  
('1989', 2014, 13, 'Taylor Swift', 'Pop'),  
('Random Access Memories', 2013, 13, 'Daft Punk', 'Eletrônico'),  
('The Eminem Show', 2002, 20, 'Eminem', 'Rap'),  
('Nevermind', 1991, 12, 'Nirvana', 'Rock'),  
('El Mal Querer', 2018, 11, 'Rosalía', 'Pop')  

SELECT * FROM Albuns 
ORDER BY Ano_Lancamento DESC

SELECT * FROM Albuns
WHERE Genero= 'Rock'

SELECT Nome_Album, Artista, Numero_Musicas
FROM Albuns
WHERE Numero_Musicas > 10










