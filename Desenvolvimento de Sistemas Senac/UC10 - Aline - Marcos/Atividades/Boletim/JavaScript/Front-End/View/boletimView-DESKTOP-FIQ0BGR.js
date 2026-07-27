// É a view da parte Front do projeto (Navegador)

function criarColuna(valor) {
    const coluna = document.createElement("td");
    coluna.textContent = valor;                  // Criar a coluna e coloca o que vai ter de text nela
    return coluna
}

function criarColunaBotao(textContent) {
    const colunaBotao = document.createElement("td");
    const botao = document.createElement("button");
    botao.type = "button"
    botao.textContent = textContent  // Criar o botão e coloca o texto dele e as classes que vai ter
    botao.classList.add("btn", "btn-info", "btnExcluir")
    colunaBotao.appendChild(botao)
    return colunaBotao
}

function criarLinha(id, nome, notaProva, notaTrabalho, media) {

    const linha = document.createElement("tr");
    linha.className = "Aluno"                   // Cria a linha e coloca o nome dela
    linha.dataset.id = id

    linha.appendChild(criarColuna(id));
    linha.appendChild(criarColuna(nome));
    linha.appendChild(criarColuna(notaProva));
    linha.appendChild(criarColuna(notaTrabalho));
    linha.appendChild(criarColuna(media));
    linha.appendChild(criarColunaBotao("Excluir"));
    linha.appendChild(criarColunaBotao("Editar"));

    return linha
}

function excluirAluno(e) {
    const elementoClicado = e.target;
    // Captura o ID do aluno que salvamos no dataset da linha
    if (elementoClicado.classList.contains("btnExcluir")) {
        // Primeiro localizamos a linha onde está o ID, SEM APAGAR ELA!
        const linha = elementoClicado.closest("tr");
        return linha
    }
}

function alunoRecuperacao(linha, botao) {
    linha.classList.add("notaVermelha")
    botao.classList.add("notaVermelha")
}

function alterandoPrimeiraLetra(palavra) {
    let texto = palavra.charAt(0).toUpperCase() + palavra.slice(1)
    return texto
}

function mensagemSucesso(mensagem) {
    Swal.fire("Sucesso", mensagem, "success")
}

function mensagemErro(mensagem) {
    Swal.fire("Erro", mensagem, "error")
}

async function mensagemEditar(mensagem) {
    const { value: formValues } = await Swal.fire({
        title: "Editar Aluno",
        html: `
    <input id="swal-input1" class="swal2-input" placeholder="Nome:">
    <input id="swal-input2" class="swal2-input" placeholder="Nota Trabalho:">
    <input id="swal-input3" class="swal2-input" placeholder="Nota Prova:">
  `,
        focusConfirm: false,
        showCloseButton: true,
        showCancelButton: true,
        confirmButtonText: "Salvar",
        cancelButtonText: "Voltar",

        preConfirm: () => {
            return [document.getElementById("swal-input1").value, 
                    document.getElementById("swal-input2").value, 
                    document.getElementById("swal-input3").value];
        }
    });

    return formValues;
}