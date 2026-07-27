// Armazena os dados do sistema (Banco de Dados)

const fs = require("fs");
const conexao = require("../../../DataBase/Conexao");

exports.listar = (callback) => {
    const sql = "SELECT * FROM Tbl_Aluno";

    conexao.query(sql, (erro, resultado) => {
        if (erro) {
            throw erro;
        }

        callback(resultado);
    });
};

exports.inserirAluno = (aluno, callback) => {
    const sql = "INSERT INTO Tbl_Aluno (nome, notaProva, notaTrabalho, media) VALUES (?, ?, ?, ?)";

    conexao.query(sql, [aluno.nome, aluno.notaProva, aluno.notaTrabalho, aluno.media], (erro, resultado) => {
        if (erro) {
            throw erro;
        }

        callback(resultado);
    });
};

exports.excluirAluno = (id, callback) => {
    const sql = "DELETE FROM Tbl_Aluno WHERE id = ?";

    conexao.query(sql, [id], (erro, resultado) => {
        if (erro) {
            throw erro;
        }

        callback(resultado);
    });
};

exports.editar = (aluno, callback) => {
    const sql = "UPDATE Tbl_Aluno SET nome = ?, notaProva = ?, notaTrabalho = ?, media = ? WHERE id = ?";

    conexao.query(sql, [aluno.nome, aluno.notaProva, aluno.notaTrabalho, aluno.media, aluno.id], (erro, resultado) => {
        if (erro) {
            throw erro;
        };
        callback(resultado);
    });
};