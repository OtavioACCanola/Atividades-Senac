const express = require("express");
const rotas = express.Router();
const controller = require("../Controller Model/ControllerBackEnd");

app.get('/pedidos', controller.listar());
app.post('/pedidos', controller.salvar());
app.put('/pedidos/:id', controller.editar());
app.delete('/pedidos/:id', controller.excluir());

module.exports = rotas;