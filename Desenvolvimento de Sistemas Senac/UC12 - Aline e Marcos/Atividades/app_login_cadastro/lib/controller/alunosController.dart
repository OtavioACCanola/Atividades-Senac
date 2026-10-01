import 'package:app_login_cadastro/model/alunos.dart';

class ControllerAlunos {
  static final List<Alunos> _listaAlunos = [
    Alunos(
      nome: "Aline Francisca",
      email: 'aline@gmail.com',
      curso: "Ciência da Computação",
      turma: "A",
      fotoPerfil: null,
    ),

    Alunos(
      nome: "Marcos Costa",
      email: 'marcos@gmail.com',
      curso: "Ciência da Computação",
      turma: "B",
      fotoPerfil: null,
    ),

    Alunos(
      nome: "Alisson",
      email: 'alisson@gmail.com',
      curso: "Alcateia de Lobos",
      turma: "Fundão",
      fotoPerfil: null,
    ),

    Alunos(
      nome: "Pedro",
      email: 'pedro@gmail.com',
      curso: "Desenvolvimento de Sistemas",
      turma: "31",
      fotoPerfil: null,
    ),
  ];

  List<Alunos> getAlunos() {
    return _listaAlunos;
  }

  void addAlunos(Alunos aluno) {
    _listaAlunos.add(aluno);
  }
}
