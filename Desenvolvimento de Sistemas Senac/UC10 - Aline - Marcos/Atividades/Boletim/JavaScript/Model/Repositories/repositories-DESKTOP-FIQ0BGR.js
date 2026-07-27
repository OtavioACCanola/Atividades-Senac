// repositories
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


exports.salvarTodos = (lista) => {
    fs.writeFileSync("alunos.json", JSON.stringify(lista, null, 2));
};