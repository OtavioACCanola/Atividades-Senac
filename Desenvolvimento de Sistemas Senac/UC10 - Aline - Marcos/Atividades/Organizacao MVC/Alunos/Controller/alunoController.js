const model = require("../Model/alunoModel.js")
const view = require("../View/CriarLinha.js")

    exports.listar = (req, res) => {
        res.json(model.lerAlunos());
    };

    exports.salvar = (req, res) => {
        const alunos = model.lerAlunos();
        const novoAluno = req.body;

        novoAluno.id = model.gerarId(alunos);
        alunos.push(novoAluno);

        model.salvarAlunos(alunos);
        res.status(201).json(novoAluno);

    };

    exports.excluir = (req, res) => {
        const id = parseInt(req.params.id);
        const alunos = model.lerAlunos();

        const novaLista = alunos.filter(a => a.id !== id);
        model.salvarAlunos(novaLista);

        res.json({mensagem: "Aluno excluído!"});
    }

