const http = require("http");

const servidor = http.createServer(function(req, res) {
    res.write("Meu primeiro servidor com Node.js");
    res.end();
});

servidor.listen(3000);