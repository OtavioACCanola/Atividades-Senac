// É a Model da parte Front do projeto (Navegador)

function validarNota(valor) {
    if(isNaN(valor) || valor < 0 || valor > 10) {
        return false;
    }
    else {
        return true;
    }
}

function validarNotaVermelha(valor) {
    if(valor < 7) {
        return true;
    }
    else if(valor >=7) {
        return false;
    }
}

function isNull(valor) {
    if(valor === ""){
        return true;
    }
    else if(valor != ""){
        return false;
    }
}