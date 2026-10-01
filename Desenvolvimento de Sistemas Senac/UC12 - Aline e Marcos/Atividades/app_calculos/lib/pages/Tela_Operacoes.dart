// Tarefas:
// - Colocar um texto para mostrar o valor

// Importa o pacote principal do Flutter
import 'package:app_calculos/Controller/calculoController.dart';
import 'package:flutter/material.dart';

// Tela de Operacoes Matemáticas
class Tela_Operacoes extends StatefulWidget {
  const Tela_Operacoes({super.key});

  @override
  State<Tela_Operacoes> createState() => _Tela_Operacoes();
}

// Classe responsável por controlar o estado da tela
class _Tela_Operacoes extends State<Tela_Operacoes> {
  // Instâncias do Controller e da classe de Mensagens
  final CalculoController _controller = CalculoController();

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }

  void _executarCalculo(String operacao) {
    setState(() {
      // 1. Chama o Controller para processar os dados
      _controller.calcular(operacao);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text("Operações Matemáticas"),
        centerTitle: true,
      ),

      body: SingleChildScrollView(
        child: Padding(
          padding: const EdgeInsetsGeometry.all(24.0),

          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: [
              const Icon(Icons.functions, size: 90, color: Colors.indigo),

              const SizedBox(height: 30),

              // Primeiro campo de entrada
              TextField(
                controller: _controller.numero1,
                keyboardType: TextInputType.number,
                decoration: const InputDecoration(
                  labelText: "Primeiro número",
                  border: OutlineInputBorder(),
                  prefixIcon: Icon(Icons.looks_one),
                ),
              ),

              const SizedBox(height: 30),

              // Segundo campo de entrada
              TextField(
                controller: _controller.numero2,
                keyboardType: TextInputType.number,
                decoration: const InputDecoration(
                  labelText: "Segundo Número",
                  border: OutlineInputBorder(),
                  prefixIcon: Icon(Icons.looks_two),
                ),
              ),

              const SizedBox(height: 30),

              // Botão de Soma
              ElevatedButton(
                onPressed: () {
                  _executarCalculo("Adição");
                },
                child: const Text("Somar", style: TextStyle(fontSize: 18)),
              ),

              const SizedBox(height: 30),

              // Botão de Subtração
              ElevatedButton(
                onPressed: () {
                  _executarCalculo("Subtração");
                },
                child: const Text("Subtrair", style: TextStyle(fontSize: 18)),
              ),

              const SizedBox(height: 30),

              // Botão de multiplicação
              ElevatedButton(
                onPressed: () {
                  _executarCalculo("Multiplicação");
                },
                child: const Text(
                  "Multiplicação",
                  style: TextStyle(fontSize: 18),
                ),
              ),

              const SizedBox(height: 30),

              // Botão de divisão
              ElevatedButton(
                onPressed: () {
                  _executarCalculo("Divisão");
                },
                child: const Text("Divisão", style: TextStyle(fontSize: 18)),
              ),

              const SizedBox(height: 30),

              // Botão para limpar os campos
              OutlinedButton(
                onPressed: () {
                  _controller.limparDados(
                    _controller.numero1,
                    _controller.numero2,
                  );
                },
                child: const Text(
                  "Limpar Campos",
                  style: TextStyle(fontSize: 18),
                ),
              ),

              const SizedBox(height: 30),

              // Área onde o resultado será exibido
              Container(
                padding: const EdgeInsets.all(16),
                decoration: BoxDecoration(
                  color: Colors.indigo.shade50,
                  borderRadius: BorderRadius.circular(10),
                  border: Border.all(color: Colors.indigo),
                ),
                child: Text(
                  _controller.resultado,
                  style: const TextStyle(
                    fontSize: 20,
                    fontWeight: FontWeight.bold,
                  ),
                  textAlign: TextAlign.center,
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
