import 'package:flutter/material.dart';
import 'package:app_calculos/View/LimpaCampos.dart';
import 'package:app_calculos/Model/validacoes.dart';
import 'package:app_calculos/Model/calculosMatematicos.dart';

class CalculoController {
  final TextEditingController numero1 = TextEditingController();
  final TextEditingController numero2 = TextEditingController();

  final _validacao = ValidacaoNumero();
  final _contas = Contas();
  final _limpar = LimparView();

  String resultado = "Resultado aparecerá aqui!";

  // Método para limpar
  void limparDados(
    TextEditingController numero1,
    TextEditingController numero2,
  ) {
    _limpar.limpaCampos(numero1, numero2);
    resultado = "Resultado aparecerá aqui!";
  }

  Map<String, dynamic> calcular(String operacao) {
    double? num1 = double.tryParse(numero1.text);
    double? num2 = double.tryParse(numero2.text);

    // Validação de campos vazios/nulos
    if (_validacao.isNull(num1, num2)) {
      return {
        'sucesso': false,
        'mensagem': 'Por favor, preencha os dois campos com números válidos!',
      };
    }

    if (operacao == 'Divisão' && num2 == 0) {
      return {
        "sucesso": false,
        "mensagem": "Não é possível realizar uma divisão com zero!",
      };
    }

    // Execução das operações da Model
    double resultadoCalculo = 0.0;
    switch (operacao) {
      case 'Adição':
        resultadoCalculo = _contas.Adicao(num1!, num2!);
        break;
      case 'Subtração':
        resultadoCalculo = _contas.Subtracao(num1!, num2!);
        break;
      case 'Multiplicação':
        resultadoCalculo = _contas.Multiplicacao(num1!, num2!);
        break;
      case 'Divisão':
        resultadoCalculo = _contas.Divisao(num1!, num2!);
        break;
    }

    resultado = "O resultado da $operacao é: $resultadoCalculo!";

    return {
      'sucesso': true,
      'mensagem': 'O resultado da $operacao é: $resultadoCalculo!',
    };
  }

  void dispose() {
    numero1.dispose();
    numero2.dispose();
  }
}
