const fs = require("fs");

function gerarId(alunos) {
    return alunos.length > 0 ? alunos[alunos.length - 1].id + 1 : 1;
}

// Função para ler o arquivo JSON
function lerAlunos() {
    const dados = fs.readFileSync("alunos.json", "utf-8"); // As informações dos alunos, nota, nome, etc, vão vir como String, texto único, ou seja, não é separado por cada coisa
    // Retorna os dados já convertidos em JSON
    return JSON.parse(dados) // Separa a String em um array que podemos acessar com POO
}

function salvarAlunos(listaAlunos) {
    fs.writeFileSync('alunos.json', JSON.stringify(listaAlunos, null, 2))
}

module.exports = {
    lerAlunos,
    salvarAlunos, 
    gerarId, 
}