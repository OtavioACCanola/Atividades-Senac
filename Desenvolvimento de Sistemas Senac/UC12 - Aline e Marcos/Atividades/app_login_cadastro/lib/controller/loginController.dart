import 'package:app_login_cadastro/model/valiacao.dart';
import 'package:flutter/material.dart';

class ControllerLogin {
  final TextEditingController email = TextEditingController();
  final TextEditingController senha = TextEditingController();

  final Validacao modelValidar = Validacao();
  String mensagemEmail = "";
  String mensagemSenha = "";

  String logar() {
    String txtEmail = email.text;
    String txtSenha = senha.text;

    if (modelValidar.isNull(txtEmail)) {
      mensagemEmail = 'O campo email deve estar preenchido!';
      }
    
    else if(!modelValidar.isEmailValido(txtEmail)) { 
      mensagemEmail = 'Digite um email válido!';
    }

    else {
      mensagemEmail = "";
    }

    if(modelValidar.isNull(txtSenha)){
      mensagemSenha = 'O campo senha deve estar preenchido!';
    }

    else if(!modelValidar.isSenhaValida(txtSenha)){
      mensagemSenha = 'Digite uma senha válida!';
    }

    else{
      mensagemSenha = '';
    }

    // 3. Retorna o status geral do formulário
  if (mensagemEmail.isNotEmpty || mensagemSenha.isNotEmpty) {
    return 'Erro de validação';
  } else {
    return 'Sucesso';
  }
  }

  void dispose() {
    email.dispose();
    senha.dispose();
  }
}
