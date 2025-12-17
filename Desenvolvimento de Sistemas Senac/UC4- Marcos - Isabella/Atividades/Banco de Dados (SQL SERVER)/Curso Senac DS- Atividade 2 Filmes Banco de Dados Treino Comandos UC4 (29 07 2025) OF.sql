/* Crie um banco de dados chamado cinema. Dentro desse banco, crie uma tabela chamada filmes, como os seguintes campos:
- ID (Inteiro, Identity e Chave Primária)
- Titulo (Texto)
- Diretor (Texto)
- Gênero (Texto)
- Ano (Inteiro)
- Classificação (Texto)
Insira pelo menos 6 registros com diferentes gêneros (ação, comédia, drana, terror, ficção, etc)
Faça uma consulta SQL que retorne todos os filmes com o gênero 'Comédia'.
Adicione uma nova coluna chamada NotaFilme do tipo decimal (3,1).
Use o comando update para atualizar os valores da coluna NotaFilme para cada um dos registros
*/

CREATE DATABASE Cinema
USE Cinema

CREATE TABLE TBL_Filmes(
ID INT IDENTITY PRIMARY KEY,
Titulo VARCHAR (100),
Diretor VARCHAR (50),
Genero VARCHAR (50),
Ano INT,
Classificacao VARCHAR (2)
)

INSERT INTO TBL_Filmes VALUES
('Como Treinar Seu Dragao', 'Chris Sanders e Dean DeBlols', 'Animaçao', 2010, '10'),
('Superman', 'James Gunn', 'Super-Héroi', 2025, '14'),
('Pixels', 'Chris Columbus', 'Ficção Científica', 2015, '14'),
('Quarteto Fantástico: Primeiros Passos', 'Matt Shakman', 'Ação', 2025, '12'),
('Como se Fosse a Primeira Vez', 'Peter Segal', 'Comédia', 2004, 'L'),
('Kimi no Na wa', 'Makoto Shinkai', 'Romance', 2016, '12')

SELECT * FROM TBL_Filmes
WHERE Genero= 'Comédia'

ALTER TABLE TBL_Filmes
ADD NotaFilme DECIMAL(3,1)

UPDATE TBL_Filmes
SET NotaFilme= 8.3
WHERE id= 1

UPDATE TBL_Filmes
SET NotaFilme= 7.6
WHERE id= 2

UPDATE TBL_Filmes
SET NotaFilme= 5.6
WHERE id= 3

UPDATE TBL_Filmes
SET NotaFilme= 7.2
WHERE id= 4

UPDATE TBL_Filmes
SET NotaFilme= 6.8
WHERE id= 5

UPDATE TBL_Filmes
SET NotaFilme= 8.4
WHERE id= 6