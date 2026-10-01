import 'package:flutter/material.dart';
import './segunda_tela.dart'; // Ou o caminho correto da sua pasta

// Criação da tela PerfilAlunoPage.
/* Ela herda da StatelessWidget porque, neste primeiro exemplo a tela é estática, ou seja,
não muda durante o uso. */

class PerfilAlunoPage extends StatelessWidget {

    // Construtor da Tela
    const PerfilAlunoPage({super.key});

    @override

    Widget build(BuildContext context) {
      // O método build monta a interface da tela.

      return Scaffold(

        // AppBar cria a barra superior da tela.
        appBar: AppBar(

          // Texto exibido no topo da tela.
          title: const Text('Perfil do Aluno'),

          // Cor de fundo da barra superior.
          backgroundColor: Colors.indigo,

          // Cor do texto e dos ícones de AppBar.
          foregroundColor: Colors.white,
        ),

        // body representa a área principal da tela.
        body: Padding(
            // Cria espaçamento interno de 24 pixels em todos os lados.
            padding: const EdgeInsets.all(24),

          // Column organiza os elementos verticalmente, ou seja, um abaixo do outro.
          child: Column(

            // Centraliza os elementos no eixo horizontal.
            crossAxisAlignment: CrossAxisAlignment.center,

            // Lista de widgets que serão exibidos na tela.
            children: [

              // Ícone grande representando o perfil do aluno.
              const Icon(
                  Icons.account_circle,
                  size: 100,
                  color: Colors.indigo,
              ),

              // Espaçamento entre o ícone e o nome.
              const SizedBox(
                  height: 16
              ),

              // Nome do aluno.
              const Text(
                'Ana Souza',
                style: TextStyle(
                  fontSize: 28,
                  fontWeight: FontWeight.bold,
                ),
              ),

              const SizedBox(
                height: 8
              ),

              const Text(
                  'Técnico em Desenvolvimento de Sistemas',
                  textAlign: TextAlign.center,
                  style: TextStyle(
                    fontSize: 18,
                  ),
              ),

              const SizedBox(
                  height: 24
              ),
              Container(
                padding: const EdgeInsets.all(16),
                decoration: BoxDecoration(
                  color: Colors.indigo.shade50,
                  borderRadius: BorderRadius.circular(12),
                ),
                child: const Row(
                  children: [
                    Icon(
                      Icons.school,
                      color: Colors.indigo,
                    ),
                    SizedBox(width: 12),
                    Expanded(child: Text('UC12 - Interface, usabilidade e aplicação mobile',
                    style: TextStyle(fontSize: 16),
                    ),
                    ),
                  ],
                ),

              ),
              const SizedBox(height: 24),
              SizedBox(
                width: double.infinity,
                height: 50,
                child: ElevatedButton(
                    onPressed: () {
                      Navigator.push(
                          context,
                          MaterialPageRoute(
                              builder: (context) => const SegundaTela(),
                          ),
                      );
                    },
                    child: const Text('Ver informações!'),
                ),
              ),
            ],
          ),
        ),
      );
    }
}