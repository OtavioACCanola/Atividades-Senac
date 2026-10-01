import 'dart:typed_data';

import 'package:app_login_cadastro/pages/detalhesAluno.dart';
import 'package:flutter/material.dart';

class AlunoCard extends StatelessWidget {
  final String nome;
  final String email;
  final String curso;
  final String turma;
  final Uint8List? fotoPerfil;


  // Construtor que recebe os dados necessários
  const AlunoCard({
    super.key,
    required this.nome,
    required this.email,
    required this.curso,
    required this.turma,
    this.fotoPerfil,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 3,
      margin: const EdgeInsets.only(bottom: 14),
      child: ListTile(
        leading: CircleAvatar(
          backgroundColor: Colors.indigo,
          backgroundImage: fotoPerfil != null ? MemoryImage(fotoPerfil!) : null,

          child: fotoPerfil == null
              ? const Icon(Icons.person, color: Colors.white)
              : null,
        ),

        title: Text(
          nome, 
          style: const TextStyle(
            fontWeight: FontWeight.bold,
          )
        ),

        subtitle: Text(
          "$email\n$curso\n$turma"
        ),
        isThreeLine: true,
        trailing: const Icon(
          Icons.arrow_forward_ios,
        ),

        onTap: () {
          Navigator.push(
            context,
            MaterialPageRoute(
              builder: (context) => TelaDetalhesAluno(
                nome: nome, 
                email: email,
                curso: curso, 
                turma: turma,
                fotoPerfil: fotoPerfil,
              ),
            ),
          );
        },
      ),
    );
  }
}