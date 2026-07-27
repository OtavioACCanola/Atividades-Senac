const model = require("../Model/ModelLanchonete");

exports.listar = (req, res) => {
    res.json(model.lerPedidos());
}

exports.salvar = (req, res) => {
    const pedidos = model.lerPedidos();
    const novoPedido = req.body;

    novoPedido.id = model.gerarId(pedidos);
    novoPedido.status = "Em preparo";

    pedidos.push(novoPedido);
    model.salvarPedidos(pedidos);

    res.status(201).json(novoPedido);
};

exports.editar = (req, res) => {
    const id = parseInt(req.params.id);
    const pedidos = model.lerPedidos();

    const novaLista = pedidos.map(pedido => {
        if (pedido.id === id) {
            pedido.status = req.body.status;
        }
        return pedido;
    });

    model.salvarPedidos(novaLista);
    res.json({ mensagem: "Status atualizado" });
};

exports.excluir = (req, res) => {
    const id = parseInt(req.params.id);
    const pedidos = model.lerPedidos();

    const novaLista = pedidos.filter(p => p.id !== id);
    model.salvarPedidos(novaLista);

    res.json({ mensagem: "Pedido removido" });
}