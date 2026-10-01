import 'package:app_login_cadastro/pages/telaLogin.dart';
import 'package:flutter/material.dart';

void main() {
  runApp(const AppEscola());
}

class AppEscola extends StatelessWidget {
  const AppEscola({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      // Remove a faixa vermelha de debug
      debugShowCheckedModeBanner: false,
      title: 'Escola Mundial - Um carrossel para seu filho',
      theme: ThemeData(primarySwatch: Colors.lightBlue, useMaterial3: false),
      home: const TelaLogin(),
    );
  }
}
