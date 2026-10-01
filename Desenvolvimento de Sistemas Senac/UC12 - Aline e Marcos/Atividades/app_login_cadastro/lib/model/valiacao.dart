// Dar o comando: 'flutter pub add email_validator' no terminal primeiro 
import 'package:email_validator/email_validator.dart';

class Validacao {

  bool isNull(String? valor) {
    if (valor == "") {
      return true;
    } else {
      return false;
    }
  }

  bool isEmailValido(String email) {
    if(!EmailValidator.validate(email)){
      return false;
    }
    else{
      return true;
    }
  }

   bool isSenhaValida(String senha) {
    RegExp regexSenha = RegExp(r'^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[@._-]).{8,}$'); 
    // ^ : Início do texto.
    // (?=.*[A-Z]) : Olhe todo o texto e garanta que exista pelo menos 1 letra maiúscula.
    // (?=.*[a-z]) : Olhe todo o texto e garanta que exista pelo menos 1 letra minúscula.
    // (?=.*[1-9]) : Olhe todo o texto e garanta que exista pelo menos 1 número.
    // (?=.*[._-]) : Olhe todo o texto e garanta que exista pelo menos 1 caractere especial, ".", "_" ou "-".
    // .{8,} : Exige que a senha tenha no total pelo menos 8 caracteres
    // $ : Fim do texto.

    if(!regexSenha.hasMatch(senha)){
      return false;
    }
    else{
      return true;
    }
  }
}
