// Importar função excluir view

import {excluirAluno} from "../View/ExcluirView.js";

const tabela = document.getElementById("CorpoTabela")

tabela.addEventListener("click", excluirAluno)