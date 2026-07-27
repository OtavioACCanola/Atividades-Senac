export function excluirAluno(event) {
    const botaoExcluir = event.target.closest(".btnExcluir")

    if (botaoExcluir) {
        const linha = botaoExcluir.closest("tr")

        linha.remove()
    }

}