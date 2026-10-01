import 'package:app_login_cadastro/controller/alunosController.dart';

import 'package:app_login_cadastro/pages/telaPrincipal.dart';
import 'package:app_login_cadastro/view/cards.dart';
import 'package:flutter/material.dart';

class TelaAlunos extends StatelessWidget {
  TelaAlunos({super.key});

  final ControllerAlunos _controllerAlunos = ControllerAlunos();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsetsGeometry.all(24),

          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              SizedBox(height: 20),

              Row(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.center,

                children: [
                  Column(
                    children: [
                      Image.asset(
                        'assets/Imagens/Img_Escola_Mundial.png',
                        height: 120,
                      ),

                      SizedBox(height: 5),

                      Text(
                        "Alunos Cadastrados",
                        style: TextStyle(
                          color: Colors.black,
                          fontSize: 30,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ],
                  ),
                ],
              ),

              SizedBox(height: 5),

              Divider(
                color: Colors.blue,
                thickness: 2, // Espessura da linha
                indent: 0, // Espaçamento no início (esquerda)
                endIndent: 0, // Espaçamento no fim (direita)
              ),

              SizedBox(height: 25),

              const Text(
                "Toque em um aluno para ver os detalhes dele",

                style: TextStyle(
                  fontSize: 16
                ),
              ),

              const SizedBox(height: 20),

              for (var aluno in _controllerAlunos.getAlunos())
                AlunoCard(
                  nome: aluno.nome,
                  email: aluno.email,
                  curso: aluno.curso,
                  turma: aluno.turma,
                  fotoPerfil: aluno.fotoPerfil,
                ),

              // Botão Voltar
              ElevatedButton(
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => TelaPrincipal()),
                  );
                },
                style: ElevatedButton.styleFrom(
                  backgroundColor: Colors.indigo,
                  foregroundColor: Colors.white,
                  shadowColor: Colors.black,
                  padding: const EdgeInsets.all(20),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadiusGeometry.circular(15),
                  ),
                ),
                child: Text(
                  "Voltar",
                  style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
                ),
              ),

              SizedBox(height: 35),
            ],
          ),
        ),
      ),
    );
  }
}
