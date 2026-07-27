// Pegar a variável txtnome
// Pegar a variável txtNotaTrabalho
// Pegar a variável txtNotaProva
// Trocar o valor delas para o texto do input
// Pegar o valor do últido id com o quarryselector
// Colocar o valor para o últido no linhaId
// Verificar se o nome é o mesmo

import { createElement } from "react"

let id = 1

function criarLinha() {
    linha = createElement("tr")
}

function criarColuna() {
    coluna = createElement("td")
}

export function addInfoAluno(nome, notaTrabalho, notaProva, media) {

    const linhaAluno = document.getElementById("CorpoTabela")
    const novaLinha = criarLinha();
    const valorMedia = parseFloat(media)
    novaLinha.className = "Aluno"
    if (valorMedia < 7.0) {
        novaLinha.classList.add("notaVermelha")
    }
    else {
        novaLinha.classList.add("AlunoNovo")
    }
    criarColuna
    novaLinha.innerHTML = `     
            <th scope="row">${id}</th>
            <td class="Item">${nome}</td>
            <td class="Numeros">${notaTrabalho}</td>
            <td class="Numeros">${notaProva}</td>
            <td class="Numeros">${media}</td>
            <td><button type="button" class="btn btn-danger btnExcluir">Excluir</button></td>
`
    id++
    return novaLinha
}