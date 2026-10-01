// Importa o pacote principal do Flutter.
/* Esse pacote contém os widgets visuais do 'Material Design', como: MaterialApp, Scaffold,
AppBar, Text, Icon, entre outros. */
import 'package:flutter/material.dart';

// Importa a tela PerfilAlunoPage.
// Essa tela foi criada dentro da pasta /pages.
import 'pages/perfil_aluno_page.dart';

// Função principal do aplicativo. TODO APLICATIVO FLUTTER COMEÇA SUA APLICAÇÃO POR AQUI.
void main() {
  // 'runApp' Inicia o aplicativo Flutter. Estamos dizendo que o widgt principal será MeuApp.
  runApp(const MyApp());
}

// Classe principal do aplicativo.
// Ela representa a configuração geral do app.
class MyApp extends StatelessWidget {
  // Construtor da classe MeuApp.
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {

    /* MaterialApp configura a base do aplicativo Flutter, definindo o título, o tema visual,
    e a tela inicial. */
    return MaterialApp(
      // Título interno do aplicativo.
      title: 'Projeto perfil aluno UC12',

      // Remove a faixa vermelha de DEBUG que aparece no canta superior.
      debugShowCheckedModeBanner: false,

      // Define o tema visual do aplicativo.
      theme: ThemeData(

        // Define a cor principal do aplicativo como índigo.
        primarySwatch: Colors.indigo,

        // Ativa o padrão visual mais atual do Material Design.
        useMaterial3: true,
      ),

      // Define qual será a primeira tela exibida ao abrir o aplicativo.
      home: const PerfilAlunoPage(),
    );
  }
}