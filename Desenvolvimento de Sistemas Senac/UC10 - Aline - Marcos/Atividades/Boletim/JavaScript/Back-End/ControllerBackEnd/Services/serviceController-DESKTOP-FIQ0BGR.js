// Recebe o fetch, direciona para a ação correta

const { raw } = require("mysql2");
const modelBackSer = require("../../ModelBackEnd/Services/serviceModel")

exports.listar = (req, res) => {
    modelBackSer.listar((resultado) => {
        res.json(resultado);
    })
}

exports.cadastrar = (req, res) => {
    const aluno = req.body;
    modelBackSer.cadastrar(aluno, () => {
        res.status(201).json({
            mensagem: "Aluno Inserido com Sucesso!"
        });
    });
}

exports.excluir = (req, res) => {
    const aluno = req.body;
    const id = parseInt(req.params.id);
    modelBackSer.excluir(id, () => {
        res.status(201).json({
            mensagem: "Aluno Deletado com Sucesso!"
        });
    });
};

/* Terminar o Editar */
exports.editar = (req, res) => {
    const dadosAluno = req.body;
    modelBackSer.editar(dadosAluno.nome, dadosAluno.notaTrabalho, dadosAluno.notaProva, dadosAluno.media, dadosAluno.id, () => {
        res.status(201).json({
            mensagem: "Aluno editado com Sucesso"
        })
    })

}