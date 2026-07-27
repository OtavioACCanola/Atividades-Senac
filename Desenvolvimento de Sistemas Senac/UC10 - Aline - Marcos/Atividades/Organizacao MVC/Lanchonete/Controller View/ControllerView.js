function carregarPedidos() {
    fetch("http://localhost:3000/pedidos")
        .then(res => res.json())
        .then(pedidos => {
            const tabela = document.querySelector("#tabela-pedidos");
            tabela.innerHTML = "";
            pedidos.forEach(p => tabela.appendChild(criarLinha(p)));
        });
}

document.getElementById("form-pedido").addEventListener("submit", function(e) {
    e.preventDefault();

    const pedido = {
        cliente: cliente.value,
        lanche: lanche.value
    };

    fetch("http://localhost:3000/pedidos", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(pedido)
    })
    .then(() => carregarPedidos());
});

document.querySelector("#tabela-pedidos").addEventListener("click", function(e) {
    const linha = e.target.closest("tr");
    const id = linha.dataset.id;

    if (e.target.classList.contains("excluir")) {
        fetch(`http://localhost:3000/pedidos/${id}`, { method: "DELETE" })
            .then(() => carregarPedidos());
    }

    if (e.target.classList.contains("avancar")) {
        const statusAtual = linha.children[2].textContent;
        let novoStatus = "Pronto";

        if (statusAtual === "Pronto") novoStatus = "Entregue";

        fetch(`http://localhost:3000/pedidos/${id}`, {
            method: "PUT",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ status: novoStatus })
        })
        .then(() => carregarPedidos());
    }
})