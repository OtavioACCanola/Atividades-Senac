function salvarNotaAluno(event) {
    event.preventDefault()

    const txtNome = document.getElementById("TxtNome").value.trim();
    const txtNotaTrabalho = (document.getElementById("TxtNotaTrabalho").value.trim());
    const txtNotaProva = (document.getElementById("TxtNotaProva").value.trim());
    const regexNumero = /.*[0-9]/;
    const regexNome = /[^0-9]/;


    if (txtNome === "" || txtNotaTrabalho === "" || txtNotaProva === "") {
        swall.fire("Erro", "Todos os campos precisam estar preenchidos!", "error")
    }
    else if (regexNumero.test(txtNotaProva) || regexNumero.test(txtNotaTrabalho)) {
        swall.fire("Erro", "Os campos de nota precisam ser numéricos!", "error")
    }
    else if (regexNome.test(txtNome)) {
        swall.fire("Erro", "O Nome não pode conter números", "error")
    }
    else {
        swall.fire("Sucesso", "Aluno cadastrado com sucesso!", "success")
    }
}

const BtnSalvar = document.getElementById("BtnSalvar");
const txtNome = document.getElementById("TxtNome").value.trim();
const txtNotaTrabalho = (document.getElementById("TxtNotaTrabalho").value.trim());
const txtNotaProva = (document.getElementById("TxtNotaProva").value.trim());

BtnSalvar.addEventListener("click", salvarNotaAluno);