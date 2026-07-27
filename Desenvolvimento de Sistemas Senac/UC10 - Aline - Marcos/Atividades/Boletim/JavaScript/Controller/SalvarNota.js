// É a Controller da parte Front do projeto (Navegador), conectando view e Model


function salvarNotaAluno(e) {
    e.preventDefault()

    const txtNome = document.getElementById("TxtNome").value.trim();
    const nomeAluno = alterandoPrimeiraLetra(txtNome); // Altera a primeira letra para maíscula
    const txtNotaTrabalho = (document.getElementById("TxtNotaTrabalho").value.trim());
    const txtNotaProva = (document.getElementById("TxtNotaProva").value.trim());
    const media = calcularMedia(txtNotaProva, txtNotaTrabalho);
    // Validações
    if (isNull(txtNome) === true || isNull(txtNotaTrabalho) === true || isNull(txtNotaProva) === true) {
        mensagemErro("Todos os campos precisam estar preenchidos!");
    }
    else if (validarNota(txtNotaProva) === false || validarNota(txtNotaTrabalho) === false) {
        mensagemErro("Nota inválida!");
    }
    else {

        // Método de salvar o aluno no arquivo JSON
        fetch("http://localhost:3000/alunos", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                nome: nomeAluno,
                trabalho: txtNotaTrabalho,
                prova: txtNotaProva,
            })

        })
            .then(response => response.json())
            .then(dados => {

                addInfoAluno(dados.id, nomeAluno, txtNotaTrabalho, txtNotaProva, dados.media); // Adiciona a linha com as informações na tabela

                console.log("Aluno salvo: ", dados)

                mensagemSucesso("Aluno cadastrado com sucesso!"); // Mostra a mensagem

            });
    }
}

// AddEventListener para adicionar o Aluno
const BtnSalvar = document.getElementById("BtnSalvar");
BtnSalvar.addEventListener("click", salvarNotaAluno);