import 'dart:typed_data';

import 'package:app_login_cadastro/model/valiacao.dart';
import 'package:app_login_cadastro/model/alunos.dart';
import 'package:flutter/material.dart';

class ControllerCadastro {
  final TextEditingController nome = TextEditingController();
  final TextEditingController email = TextEditingController();
  final TextEditingController curso = TextEditingController();
  final TextEditingController turma = TextEditingController();
  final TextEditingController senha = TextEditingController();

  String mensagemNome = "";
  String mensagemEmail = "";
  String mensagemCurso = "";
  String mensagemTurma = "";
  String mensagemSenha = "";

  final Validacao modelValidar = Validacao();

  Map<String, dynamic> cadastro(Uint8List? imagem) {

    String? txtNome = nome.text;
    String? txtEmail = email.text;
    String? txtCurso = curso.text;
    String? txtTurma = turma.text;
    String? txtSenha = senha.text;

    // Nome
    if (modelValidar.isNull(txtNome)) {
        mensagemNome = 'Nome deve estar preenchido, verifique!';
      }

    else {
      mensagemNome = '';
    }

    // Email
    if(modelValidar.isNull(txtEmail)) {
      mensagemEmail = 'Email deve estar preenchido, verifique!';
      print(mensagemEmail);
    }

    else if(!modelValidar.isEmailValido(txtEmail)){
      mensagemEmail = 'Digite um email válido!';
    }

    else {
      mensagemEmail = '';
    }

    // Curso
    if (modelValidar.isNull(txtCurso)) {
        mensagemCurso = 'Curso deve estar preenchido, verifique!';
      }

    else {
      mensagemCurso = '';
    }

    // Turma
    if (modelValidar.isNull(txtTurma)) {
        mensagemTurma = 'Turma deve estar preenchido, verifique!';
      }

    else {
      mensagemTurma = '';
    }

    // Senha
    if(modelValidar.isNull(txtSenha)) {
      mensagemSenha = 'Senha deve estar preenchido, verifique!';
    }

    else if(!modelValidar.isSenhaValida(txtSenha)){
      mensagemSenha = 'Digite uma senha válido!';
    }

    else {
      mensagemSenha = '';
    }

 // Verifica se ALGUM dos campos está com mensagem de erro
    bool temErro = mensagemNome.isNotEmpty ||
        mensagemEmail.isNotEmpty ||
        mensagemCurso.isNotEmpty ||
        mensagemTurma.isNotEmpty ||
        mensagemSenha.isNotEmpty;

    if (temErro) {
      return {
        'sucesso': false,
        'mensagem': 'Erro de validação nos campos',
      };
    }
    
    Alunos novoAluno = Alunos(
      nome: txtNome,
      email: txtEmail,
      curso: txtCurso,
      turma: txtTurma,
      fotoPerfil: imagem,
    );

    return {
      'sucesso': true,
      'mensagem': 'Sucesso, cadastro realizado!',
      'aluno': novoAluno,
    };
  }

  void dispose() {
    nome.dispose();
    email.dispose();
    curso.dispose();
    turma.dispose();
    senha.dispose();
  }
}
