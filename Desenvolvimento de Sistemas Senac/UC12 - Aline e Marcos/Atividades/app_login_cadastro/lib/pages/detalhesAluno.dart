import 'dart:typed_data';

import 'package:flutter/material.dart';

class TelaDetalhesAluno extends StatelessWidget {

  final String nome;
  final String email;
  final String curso;
  final String turma;
  final Uint8List? fotoPerfil;

  const TelaDetalhesAluno({
    super.key,
    required this.nome,
    required this.email,
    required this.curso,
    required this.turma,
    this.fotoPerfil,
  });

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

             CircleAvatar(
                radius: 50,
                backgroundColor: Colors.indigo,
                backgroundImage: fotoPerfil != null ? MemoryImage(fotoPerfil!) : null,
                child: fotoPerfil == null
                    ? const Icon(
                        Icons.person,
                        size: 60,
                        color: Colors.white,
                      )
                    : null,
              ),

              SizedBox(height: 20),

              Text(
                nome,
                style: const TextStyle(
                  fontSize: 26,
                  fontWeight: FontWeight.bold,
                ),
                textAlign: TextAlign.center,
              ),

              SizedBox(height: 30),

              Card(
                elevation: 3,
                child: Padding(
                  padding: const EdgeInsetsGeometry.all(16),
                
                  child: Column(
                    children: [

                      ListTile(
                        leading: const Icon(
                          Icons.email,
                        ),
                        title: const Text(
                          "Email"
                        ),
                        subtitle: Text(email),
                      ),

                      const Divider(),

                      ListTile(
                        leading: const Icon(
                          Icons.school,
                        ),
                        title: const Text(
                          "Curso"
                        ),
                        subtitle: Text(
                          curso
                        ),
                      ),

                      const Divider(),

                      ListTile(
                        leading: const Icon(
                          Icons.groups,
                        ),
                        title: const Text(
                          "Turma"
                        ),
                        subtitle: Text(turma),
                      ),
                    ],
                  ),
                ),
              ),

              const SizedBox(height: 30),

              SizedBox(
                width: double.infinity,
                height: 50,
                child: ElevatedButton.icon(
                  onPressed: () {
                    Navigator.pop(context);
                  },

                  icon: const Icon(
                    Icons.arrow_back
                  ),

                  label: const Text(
                    "Voltar",
                  ), 
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
