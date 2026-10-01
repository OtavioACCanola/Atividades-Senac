// ============= TAREFAS =============
// - Fazer o modo escuro com o botão flutuante: Pendente
// - Fazer a validação se o peso, altura, numero 1 e numero 2 foi passado, se não, colocar no card para digitar um valor válido: Pendente
// - Fazer tela Login: Pendente (importante)


// Importa o pacote cupertino do Flutter para icons
import 'package:flutter/cupertino.dart';

// Importa o pacote principal do Flutter
import 'package:flutter/material.dart';

// Importa as telas que serão chamadas na tela principal
import 'Tela_Operacoes.dart';
import 'Tela_Imc.dart';

// Tela principal do App
class Tela_Principal extends StatelessWidget {
  const Tela_Principal({super.key});
  
  final double paddingBotao = 8;

  final double espacamentoBotoes = 30;

  final double espacamentoIconTexto = 7;

  final double sizedBox = 30.0;

  final double fonteBotao = 20;

  final double fonteTitulo = 35;

  final Color corTitulo = Colors.teal;

  final Color corBotao = Colors.lightBlue;

  final Color corTexto = Colors.white;

  @override
  Widget build(BuildContext context) {
    return Scaffold(

      // Barra superior do app
      appBar: AppBar(
        title: const Text("Calculadora Digital"),
        centerTitle: true,
        backgroundColor: Colors.indigo,
        foregroundColor: Colors.white,
      ),

      // Corpo da tela
      body: Center(
        
        // Column organiza os elementos um abaixo do outro
        child: Column(
          // crossAxisAlignment: CrossAxisAlignment.center,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            // Ícone ilustrativo da Tela principal
            const Icon(
              Icons.calculate,
              size: 100,
              color: Colors.indigo,
            ),

            const SizedBox(height: 15),

            // Texto de apresentação
            Text(
              "Escolha uma opção abaixo:",
              style: TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: fonteTitulo,
                color: corTitulo,
              ),
              textAlign: TextAlign.center,
            ),

            SizedBox(height: espacamentoBotoes),

            // Botão que chama a tela de operações matemáticas
            SizedBox(
              width: double.infinity,
              height: 50,
              child: ElevatedButton.icon(
                icon: const Icon(Icons.functions),
                label: const Text(
                  'Operações Matemáticas',
                  style: TextStyle(
                    fontSize: 18),
                ),
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => const Tela_Operacoes(),
                    ),
                  );
                }
              ),
            ),

            const SizedBox(height: 20),

            // Botão que chama a tela de calculo de IMC  
            SizedBox(
              width: double.infinity,
              height: 50,
              child: ElevatedButton.icon(
                icon: const Icon(
                  Icons.monitor_weight
                  ), 
                label: const Text(
                  "Cálculo de IMC",
                  style: TextStyle(
                    fontSize: 18,
                  ),
                ),
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => const Tela_Imc(),
                    ),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
