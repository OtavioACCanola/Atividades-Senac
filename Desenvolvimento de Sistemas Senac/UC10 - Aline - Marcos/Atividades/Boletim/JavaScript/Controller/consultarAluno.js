// É a Controller da parte Front do projeto (Navegador), conectando view e Model

function consultaAluno() {

    const linhaAluno = document.getElementById("CorpoTabela"); // Pega o corpo da tabela para dar mostrar os alunos

    linhaAluno.innerHTML == "";

    // linhaAluno.textContent = ""; // Limpa tudo antes de adicionar os alunos do json

    obterAlunos().then(function (listaAlunos) { // Vai pegar a lista Json obtida pelo método da model

        listaAlunos.forEach(function (aluno) { // Percorre a lista obtida da Model
            addInfoAluno(aluno.id, aluno.nome, aluno.trabalho, aluno.prova, aluno.media) // Faz a linha para adicionar a tabela
        });
    });
}

const btnConsultar = document.getElementById("BtnConsultarAluno")

btnConsultar.addEventListener("click", consultaAluno)