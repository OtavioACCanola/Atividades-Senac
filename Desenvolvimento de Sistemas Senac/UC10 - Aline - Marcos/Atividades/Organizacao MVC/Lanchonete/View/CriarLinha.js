function criarLinha(pedido) {
    const tr = document.createElement("tr");
    tr.dataset.id = pedido.id;

    tr.innerHTML = `
        <td>${pedido.cliente}</td>
        <td>${pedido.lanche}</td>
        <td>${pedido.status}</td>
        <td>
            <button class="avancar">Avançar Status</button>
            <button class="excluir">Excluir</button>
        </td>
    `;

    return tr;
}