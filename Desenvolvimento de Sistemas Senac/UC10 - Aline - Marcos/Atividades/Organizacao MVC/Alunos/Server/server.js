const express = require('express');
const cors = require('cors');
const alunoRotas = require("./Rotas")

const app = express();
app.use(cors());
app.use(express.json());
app.use(express.static('public'));

app.use(alunoRotas)

app.listen(3000, () => {
    console.log("Servidor rodando em http://localhost:3000");
});
