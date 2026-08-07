// Armazena os dados do sistema (Banco de Dados)

const mysql = require("mysql2");

const conexao = mysql.createConnection({
    host: 'localhost',
    port: 3308,
    user: 'root',
    password: '',
    database: 'Boletim'
});

module.exports = conexao;