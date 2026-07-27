const fs = require("fs");

function calcularMedia(t, p) {
    return ((Number(t) + Number(p)) / 2).toFixed(1);
}

function gerarId(alunos) {
    return alunos.length > 0 ? alunos[alunos.length - 1].id + 1 : 1;
}

function lerAlunos() {
    const dados = fs.readFileSync('alunos.json', 'utf-8');
    return JSON.parse(dados);
}

function salvarAlunos(lista) {
    fs.writeFileSync('alunos.json', JSON.stringify(lista, null, 2));
}

module.exports = {
    lerAlunos,
    salvarAlunos,
    gerarId,
    calcularMedia
};