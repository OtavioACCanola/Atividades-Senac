const fs = require("fs");

exports.validarAluno = (req, res, next) => {

    const { nome, notaProva, notaTrabalho,  media } = req.body;

    // valida nome
    if (!nome || nome.trim() === "") {
        return res.status(400).json({
            erro: "O nome é obrigatório"
        });
    }

    // valida nota trabalho
    if (notaTrabalho === undefined || isNaN(notaTrabalho)) {
        return res.status(400).json({
            erro: "A nota do trabalho é obrigatória"
        });
    }

    if (notaTrabalho < 0 || notaTrabalho > 10) {
        return res.status(400).json({
            erro: "A nota do trabalho deve estar entre 0 e 10"
        });
    }

    // valida nota prova
    if (notaProva === undefined || isNaN(notaProva)) {
        return res.status(400).json({
            erro: "A nota da prova é obrigatória"
        });
    }

    if (notaProva < 0 || notaProva > 10) {
        return res.status(400).json({
            erro: "A nota da prova deve estar entre 0 e 10"
        });
    }

    if (media === undefined || isNaN(media)) {
        return res.status(400).json ({
            erro: "A nota da média é obrigatória"
        })        
    }

    next();
}
