import 'package:flutter/material.dart';
import 'package:quickalert/quickalert.dart';

class Mensagens{
  
  void mensagemErro(BuildContext context, String texto) {
  QuickAlert.show(
    context: context, 
    type: QuickAlertType.error,
    text: texto
    );
  }

  void mensagemSucesso(BuildContext context, String texto) {
  QuickAlert.show(
    context: context, 
    type: QuickAlertType.success,
    text: texto
    );
  }
}