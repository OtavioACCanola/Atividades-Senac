// Armazena os dados do sistema (Banco de Dados)

const fs = require("fs");
const conexao = require("../../DataBase/Conexao");

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
    const sql = "INSERT INTO Tbl_Aluno (nome, notaProva, notaTrabalho) VALUES (?, ?, ?)";

    conexao.query(sql, [aluno.nome, aluno.notaProva, aluno.notaTrabalho],(erro, resultado) => {
        if (erro) {
            throw erro;
        }

        callback(resultado);
    });
};

exports.salvarTodos = (lista) => {
    fs.writeFileSync("alunos.json", JSON.stringify(lista, null, 2));
};