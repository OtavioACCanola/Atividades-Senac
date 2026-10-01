import 'package:flutter/material.dart';

void popUpResposta(BuildContext context, String resultado) {
  showDialog(
    context: context,
    builder: (BuildContext context) {
      return AlertDialog(
        title: Text("Resposta"),
        content: Text(resultado, style: TextStyle(fontSize: 18)),
        actions: [
          ElevatedButton(
            onPressed: () {
              Navigator.of(context).pop();
            },
            child: Text("Ok!"),
          ),
        ],
      );
    },
  );
}

void popUpCalculo(BuildContext context) {
  // 1. Crie o controlador no topo do seu widget (dentro do State, se for Stateful)
  final TextEditingController _controllerNumero1 = TextEditingController();
  final TextEditingController _controllerNumero2 = TextEditingController();

  // 3. Chama a função que abre o pop-up
  showDialog(
    context: context, //Diz ao Flutter onde esse pop-up deve aparecer na tela. Ele interliga o botão ao pop-up.
    builder: (BuildContext context) {
      // Desenha o design do pop-up
      return AlertDialog(
        // Desenha a caixinha branca clássica do pop-up
        title: Text(
          'Digite os números para o cálculo',
        ), // Label/Título do pop-up
        content: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            TextField(
              controller:
                  _controllerNumero1, // Vincula o texto digitado ao controlador
              decoration: InputDecoration(
                hintText:
                    "Digite o primeiro número: ", // Texto de exemplo dentro do campo
              ),
            ),

            SizedBox(height: 16), // Dá um espaço entre as duas caixas de texto

            TextField(
              controller:
                  _controllerNumero2, // Vincula o texto digitado ao controlador
              decoration: InputDecoration(
                hintText:
                    "Digite o segundo número: ", // Texto de exemplo dentro do campo
              ),
            ),
          ],
        ),

        actions: [
          // Botão para cancelar e fechar o pop-up
          TextButton(
            onPressed: () {
              Navigator.of(context).pop(); // Fecha o pop-up
            },
            child: Text('Cancelar'),
          ),
          // Botão para confirmar e pegar o texto
          ElevatedButton(
            onPressed: () {
              popUpResposta(context, "2");
            },
            child: Text('Enviar'),
          ),
        ],
      );
    },
  );
}
