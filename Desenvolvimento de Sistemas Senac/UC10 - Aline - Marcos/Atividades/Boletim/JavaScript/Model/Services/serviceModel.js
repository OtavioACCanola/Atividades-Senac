// Regras do servidor, lógica de dados

const repositories = require("../Repositories/repositories")

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
    const alunos = alunosRepository.listar();
    const atualizados = alunos.map(a =>
        a.id == id ? { ...a, ...dados } : a
    );

    alunosRepository.salvarTodos(atualizados);
};

exports.excluir = (req, res) => {
    const alunos = repositories.listar();

    const novaLista = alunos.filter(aluno => aluno.id != id)
    repositories.salvarTodos(novaLista)
};
