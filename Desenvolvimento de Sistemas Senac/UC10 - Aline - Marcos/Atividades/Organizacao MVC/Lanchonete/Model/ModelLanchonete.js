const { fchmod } = require("node:fs");

function lerPedidos() {
    const dados = fs.readFileSync('pedidos.json', 'utf-8');
    return JSON.parse(dados);
}

function salvarPedidos(lista) {
    fs.writeFileSync('pedidos.json', JSON.stringify(lista, null, 2));
}

function gerarId(pedidos) {
    return pedidos.length > 0 ? pedidos[pedidos.length - 1].id + 1 : 1;
}

module.exports = {
    lerPedidos,
    salvarPedidos,
    gerarId
}