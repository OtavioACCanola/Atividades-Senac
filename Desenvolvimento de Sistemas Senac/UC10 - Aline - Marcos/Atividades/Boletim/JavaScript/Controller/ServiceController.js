// Recebe o fetch, direciona para a ação correta

const { raw } = require("mysql2");
const modelSer = require("../Model/Services/serviceModel")

exports.listar = (req, res) => {
    modelSer.listar((resultado) => {
        res.json(resultado);
    })
}

exports.cadastrar = (req, res) => {
    const aluno = req.body;
    modelSer.cadastrar(aluno, ()=> {
        res.status(201).json ({
            mensagem: "Aluno Inserido com Sucesso!"
        });       
    });
}

exports.excluir = (req, res) => {
    const id = parseInt(req.parms.id);
    modelSer.excluir(id);
    res.json({
        mensagem: "Aluno excluído!"
    })
}