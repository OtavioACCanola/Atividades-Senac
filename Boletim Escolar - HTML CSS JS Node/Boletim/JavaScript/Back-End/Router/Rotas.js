// Recebe o fetch, direciona para a ação correta

const express = require("express");
const router = express.Router();
const controllerBack = require("../ControllerBackEnd/Services/serviceController")
const validation = require("../Validations/validationsBackEnd")


router.get("/alunos", controllerBack.listar);
router.post("/alunos", validation.validarAluno, controllerBack.cadastrar);
router.delete("/alunos/:id", controllerBack.excluir);
router.put("/alunos/:id", controllerBack.editar)

module.exports = router;
