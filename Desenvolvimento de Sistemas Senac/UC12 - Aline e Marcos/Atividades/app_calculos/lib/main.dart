// 1º Passo: Importar o material.dart
import 'package:app_calculos/pages/Tela_Principal.dart';
import 'package:flutter/material.dart';

// Tarefas:
// - Fazer um regex para aceitar apenas números, porém em String, não em campo numérico
// - Fazer um limitador de peso e altura para ser colocado

// 1º Passo: Criar o método main, com um runApp nele
void main(){
  runApp(const MyApp());
}

// 2º Passo: Criar a classe principal do app
class MyApp extends StatelessWidget /* Stateless: Tela imutável */ {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      // Remove a faixa vermelha de debug
      debugShowCheckedModeBanner: false,

      // Titulo do App
      title: "Calculadora Digital",

      // Define o tema visual do App
      theme: ThemeData(
        primarySwatch: Colors.indigo,
        useMaterial3: false,
        ),

        // Define qual será a primeira tela aberta
        home: const Tela_Principal(),
    );
  }
}