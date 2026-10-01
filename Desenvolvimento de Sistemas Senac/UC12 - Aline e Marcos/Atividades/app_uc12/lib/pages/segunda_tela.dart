import 'package:flutter/material.dart';

class SegundaTela extends StatefulWidget {
  const SegundaTela({super.key});

  @override
  State<SegundaTela> createState() => _Segunda_tela();
}

class _Segunda_tela extends State<SegundaTela> {
  final TextEditingController _editar = TextEditingController();
  String mensagem = "";

  @override
  Widget build(BuildContext context){
    return Scaffold(
      appBar: AppBar(
        title: const Text("Perfil do Aluno"),
        backgroundColor: Colors.indigo,
        foregroundColor: Colors.white,
      ),
      body: Padding(
          padding: const EdgeInsetsGeometry.all(24),
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              const Icon(
                Icons.account_box,
                size: 200,
                color: Colors.pink,
              ),

              const SizedBox(height: 30),

              TextField(
                controller: _editar,
                decoration: const InputDecoration(
                  labelText: 'Digite seu nome',
                  border: OutlineInputBorder(),
                ),
              ),

              const SizedBox(height: 15),

              ElevatedButton(
                  onPressed: () {
                    setState(() {
                      mensagem = "Olá ${_editar.text}, seja bem-vindo!";
                    });
                  },
                  child: const Text("Mostrar mensagem"),
              ),

              const SizedBox(height: 15),
              
              Text(
                mensagem,
                style: const TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                ),
              ),
            ],
          ),
      ),
    );
  }
}