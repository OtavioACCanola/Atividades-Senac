CREATE DATABASE Boletim;
USE Boletim;

CREATE TABLE Tbl_Aluno
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255),
    notaProva DECIMAL(4,2),
    notaTrabalho DECIMAL(4,2),
    media DECIMAL(4,2)
)

SELECT * FROM Tbl_Aluno
