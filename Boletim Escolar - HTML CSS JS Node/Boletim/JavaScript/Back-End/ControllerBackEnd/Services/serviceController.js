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

exports.editar = (req, res) => {
    const idUrl = parseInt(req.params.id); 
    const dadosAluno = req.body; 
    dadosAluno.id = idUrl;

    if (!dadosAluno.id) {
        return res.status(400).json({ mensagem: "Erro: O ID do aluno não foi identificado na URL." });
    }

    modelBackSer.editar(dadosAluno, (resultado) => {
        // Agora que sabemos que o afetado é 1, ele vai pular esse IF direto para o sucesso!
        if (resultado.affectedRows === 0) {
            return res.status(404).json({ 
                mensagem: "Não foi possível editar: Aluno não encontrado com o ID informado." 
            });
        }

        // O Node vai responder isso aqui para o seu Frontend:
        return res.status(200).json({
            mensagem: "Aluno ajustado com Sucesso!"
        });
    });
};