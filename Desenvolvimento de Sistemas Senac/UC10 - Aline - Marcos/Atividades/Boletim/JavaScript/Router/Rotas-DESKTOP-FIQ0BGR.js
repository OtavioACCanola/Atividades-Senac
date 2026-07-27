const express = require("express");
const router = express.Router();
const Controller= require("../Controller/ServiceController")


router.get("/alunos", Controller.listar);
router.post("/alunos", Controller.cadastrar);
router.delete("/alunos/:id", Controller.excluir);

module.exports = router;
