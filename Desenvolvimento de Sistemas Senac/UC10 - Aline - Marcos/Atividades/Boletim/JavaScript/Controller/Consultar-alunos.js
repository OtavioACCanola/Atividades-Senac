// Colocar o apendchild aqui

import { addInfoAluno } from '../View/AddTabela.js'; // Importações
import { obterAlunos } from '../Model/Alunos.js'; // Importações
import { calcularMedia } from '../Model/Media.js'; // Importações

function consultaAluno() {

    const linhaAluno = document.getElementById("CorpoTabela") // Pega o corpo da tabela para dar o append child
    
    linhaAluno.textContent = "";

    obterAlunos().then(function (listaAlunos) {
    
        listaAlunos.forEach(function (aluno) { // Percorre a lista obtida pelo método obterAlunos
            const notaTrabalho = Number.parseFloat(aluno.trabalho) // Pega a nota de trabalho obtida e converte para float
            const notaProva = Number.parseFloat(aluno.prova) // Pega a nota de prova obtida e converte para float
            const linha = addInfoAluno(aluno.nome, aluno.trabalho, aluno.prova, calcularMedia(notaTrabalho, notaProva)) // Faz a linha para adicionar a tabela
            linhaAluno.appendChild(linha) // Adiciona a linha na tabela
        });
    }); 
}

const btnConsultar = document.getElementById("BtnConsultarAluno")

btnConsultar.addEventListener("click", consultaAluno)

