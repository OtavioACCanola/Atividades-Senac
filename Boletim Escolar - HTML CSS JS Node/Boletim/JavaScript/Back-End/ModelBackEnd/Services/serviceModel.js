// Regras do servidor, lógica de dados

const repositories = require("../Repositories/repositoriesModel")

exports.listar = (callback) => { // req: O que o cliente pediu, como parâmetros, header e body ; res: O que o servidor vai responder 
    repositories.listar((resultado) => {
        callback(resultado)
    }); // Variável que contém o array gerado pela função
}

exports.cadastrar = (aluno, callback) => {
    repositories.inserirAluno(aluno, (resultado) => {
        callback(resultado)
    });
};

exports.atualizarAluno = (id, dados) => {
    const alunos = repositories.listar();
    const atualizados = alunos.map(a =>
        a.id == id ? { ...a, ...dados } : a
    );

    repositories.salvarTodos(atualizados);
};

exports.excluir = (id, callback) => {
    console.log("oi")
    repositories.excluirAluno(id, (resultado) => {
        callback(resultado)
    });
};

exports.editar = (aluno, callback) => {
    repositories.editar(aluno, callback);
};
