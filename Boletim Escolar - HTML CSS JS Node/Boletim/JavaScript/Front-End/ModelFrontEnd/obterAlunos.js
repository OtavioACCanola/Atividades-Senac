function obterAlunos() { // Método para obter os alunos do arquivo JSON
    return fetch("http://localhost:3000/alunos")
        .then(res => res.json());
}