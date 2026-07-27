CREATE DATABASE Boletim;
USE Boletim;

CREATE TABLE Tbl_Aluno
(
	id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    notaProva DECIMAL(4,2) NOT NULL,
    notaTrabalho DECIMAL(4,2) NOT NULL
);

INSERT INTO Tbl_Aluno (nome, notaProva, notaTrabalho, media) VALUES 
("Otavio", 10.0, 10.0, 10.0);

SELECT * FROM Tbl_Aluno

TRUNCATE TABLE Tbl_Aluno

DROP TABLE Tbl_Aluno
