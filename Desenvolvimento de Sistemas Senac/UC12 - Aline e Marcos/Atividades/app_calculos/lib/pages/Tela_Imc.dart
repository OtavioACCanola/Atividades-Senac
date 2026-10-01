import 'package:app_calculos/Controller/imcController.dart';
import 'package:flutter/material.dart';

class Tela_Imc extends StatefulWidget {
  // Cria a app da tela
  const Tela_Imc({super.key});

  @override
  State<Tela_Imc> createState() => _Tela_Imc();
}

class _Tela_Imc extends State<Tela_Imc> {
  // Classe que vamos colocar as variáveis e criar a tela em si
  final _Controler =
      ImcController(); // Usamos sempre final para criar variáveis aqui

  void _calcular() {
    setState(() {
      _Controler.calcularImc();
    });
  }

  @override
  void dispose() {
    _Controler.dispose(); // Desativa a variável quando não está em uso
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    // Só leitura na hora de desenhar — ele lê o estado atual (_Controler.resultadoImc, por exemplo) e desenha em cima disso.
    return Scaffold(
      // Classe para montarmos a tela, é o esqueleto da tela inteira
      appBar: AppBar(
        // A barra do topo
        title: const Text("Calculadora IMC"),
        centerTitle: true,
      ),

      body: SafeArea(
        // Evita ficar embaixo da área de relógio e bateria do celular
        child: SingleChildScrollView(
          // Permite rolar se não couber
          padding: const EdgeInsets.all(20),
          child: Column(
            // Empilha tudo verticalmente
            crossAxisAlignment: CrossAxisAlignment
                .stretch, // faz os filhos ocuparem toda a largura
            children: [
              Card(
                // Entrada de dados, dá uma sombra e fundo pra agrupar campos relacionados.
                elevation: 2,
                shape: RoundedRectangleBorder(
                  borderRadius: BorderRadiusGeometry.circular(16),
                ),
                child: Padding(
                  padding: const EdgeInsetsGeometry.all(16),
                  child: Column(
                    children: [
                      TextField(
                        controller: _Controler.peso, // É o que liga o campo visual ao texto que você lê depois
                        keyboardType: const TextInputType.numberWithOptions(
                          decimal: true,
                        ),
                        decoration: InputDecoration(
                          labelText: "Peso (kg):",
                          prefixIcon: const Icon(Icons.monitor_weight_outlined),
                          border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(12),
                          ),
                        ),
                      ),
                      const SizedBox(height: 12),
                      TextField(
                        controller: _Controler.altura,
                        keyboardType: const TextInputType.numberWithOptions(
                          decimal: true,
                        ),
                        decoration: InputDecoration(
                          labelText: "Altura(m):",
                          prefixIcon: const Icon(Icons.height_outlined),
                          border: OutlineInputBorder(
                            borderRadius: BorderRadius.circular(12),
                          ),
                        ),
                      ),
                    ],
                  ),
                ),
              ),
              const SizedBox(height: 20),
              FilledButton.icon(
                // O botão
                onPressed:
                    _calcular, // A função só roda quando clicado, nunca antes.
                icon: const Icon(Icons.play_arrow_rounded),
                label: const Text("Calcular"),
                style: FilledButton.styleFrom(
                  padding: const EdgeInsets.symmetric(vertical: 16),
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadiusGeometry.circular(12),
                  ),
                ),
              ),
              const SizedBox(height: 20),
              if (_Controler.resultado.isNotEmpty)
                Card(
                  color: Theme.of(context).colorScheme.primaryContainer,
                  shape: RoundedRectangleBorder(
                    borderRadius: BorderRadiusGeometry.circular(16),
                  ),
                  child: Padding(
                    padding: const EdgeInsets.all(20),
                    child: Column(
                      children: [
                        const Text(
                          "IMC",
                          style: const TextStyle(
                            fontSize: 23,
                            fontWeight: FontWeight.bold,
                            color: Color(0xFFFFD700),
                          ),
                        ),
                        const SizedBox(height: 8),
                        RichText(
                          text: TextSpan(
                            style: const TextStyle(
                              fontSize: 16,
                              fontWeight: FontWeight.normal,
                              color: Colors.white,
                            ),
                            children: <TextSpan>[
                              TextSpan(
                                text: _Controler.resultado,
                                style: TextStyle(
                                  fontSize: 20,
                                  fontWeight: FontWeight.bold,
                                  color: Colors.white,
                                ),
                              ),
                            ],
                          ),
                        ),

                        const SizedBox(height: 15),

                        const Text(
                          "Classificação",
                          style: const TextStyle(
                            fontSize: 23,
                            fontWeight: FontWeight.bold,
                            color: Color(0xFFFFD700),
                          ),
                        ),
                        const SizedBox(height: 15),
                        RichText(
                          text: TextSpan(
                            style: const TextStyle(
                              fontSize: 16,
                              fontWeight: FontWeight.normal,
                              color: Colors.white,
                            ),
                            children: <TextSpan>[
                              TextSpan(
                                text: _Controler.classificacao,
                                style: TextStyle(
                                  fontSize: 20,
                                  fontWeight: FontWeight.bold,
                                ),
                              ),
                            ],
                          ),
                        ),
                      ],
                    ),
                  ),
                )
              else if (_Controler.classificacao.isNotEmpty)
                Text(
                  _Controler.classificacao,
                  style: TextStyle(color: Theme.of(context).colorScheme.error),
                ),
            ],
          ),
        ),
      ),
    );
  }
}
