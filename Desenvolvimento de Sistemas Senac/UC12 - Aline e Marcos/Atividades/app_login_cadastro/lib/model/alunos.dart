import 'dart:typed_data';

class Alunos {
  final String nome;
  final String email;
  final String curso;
  final String turma;
  final Uint8List? fotoPerfil;

  Alunos({
    required this.nome,

    required this.email,
    required this.curso,
    required this.turma,
    this.fotoPerfil,
  });

  final List<Map<String, String>> alunos = const [
    {
      "nome": "Aline Francisca",
      "email": "aline@gmail.com",
      "curso": "Ciência da Computação",
      "turma": "A",
    },

    {
      "nome": "Marcos Costa",
      "email": "marcos@gmail.com",
      "curso": "Ciência da Computação",
      "turma": "B",
    },

    {
      "nome": "Alisson",
      "email": "alisson@gmail.com",
      "curso": "Alcateia de Lobos",
      "turma": "Fundão",
    },

    {
      "nome": "Pedro",
      "email": "pedro@gmail.com",
      "curso": "Desenvolvimento de Sistemas",
      "turma": "31",
    },
  ];
}
