// É a view da parte Front do projeto (Navegador)

function addInfoAluno(id, nome, notaTrabalho, notaProva, media) {

    const tabela = document.getElementById("CorpoTabela") // Pegar o corpo da tabela
    const aluno = criarLinha(id, nome, notaProva, notaTrabalho, media); // Cria a Linha
    const botaoExcluir = aluno.querySelector(".btnExcluir")
    const botaoEditar = aluno.querySelectorAll(".btnEditar")
    const valorMedia = parseFloat(calcularMedia(parseFloat(notaTrabalho), parseFloat(notaProva))) // Pega o valor da média pelo método de calcular Média da Model
    if (validarNotaVermelha(valorMedia) == true) { // Se for nota vermelha ele adiciona as classes nota
        aluno.classList.add("notaVermelha")
        botaoExcluir.classList.add("notaVermelha")
    }
    else { // Se não for nota vermelha ele adiciona outras classes
        aluno.classList.add("AlunoNovo");
        botaoExcluir.classList.add("AlunoNovo");
    }
    tabela.appendChild(aluno)

    return aluno // Retorna a linha do Aluno
}

// AddEventListener para adicionar o Aluno
const btnSalvar = document.getElementById("BtnSalvar");
btnSalvar.addEventListener("click", salvarNotaAluno);