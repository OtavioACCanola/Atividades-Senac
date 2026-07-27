const express = require("express");
const router = express.Router();
const controller = require("../Controller/alunoController");

router.get("/alunos", controller.listar);
router.post("/alunos", controller.salvar);
router.delete("/alunos/:id", controller.excluir);

module.exports = router;