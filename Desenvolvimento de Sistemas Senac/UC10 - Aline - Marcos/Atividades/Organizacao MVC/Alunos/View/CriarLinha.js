function criarLinha(aluno) {
            const tr = document.createElement("tr");
            tr.dataset.id = aluno.id;

            tr.innerHTML = `
        <td>${aluno.nome}</td>
        <td>${aluno.trabalho}</td>
        <td>${aluno.prova}</td>
        <td>${calcularMedia(aluno.trabalho, aluno.prova)}</td>
        <td>
            <button class="editar">Editar</button>
            <button class="excluir">Excluir</button>
        </td>
    `;

            return tr;
        }