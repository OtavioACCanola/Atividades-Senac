import '../Model/calculoImc.dart';
import '../Model/validacoes.dart';

import 'package:flutter/material.dart';

// A controller vai pegar o texto digitado na View, validar com a Model, mandar novamente para calcular e trazer novamente para a View para mostrar na tela

class ImcController {
  final TextEditingController peso = TextEditingController();
  final TextEditingController altura = TextEditingController();

  final Imc _formulaImcModel = Imc();
  final ValidacaoNumero _validacaoModel = ValidacaoNumero();

  String resultado = "";
  String classificacao = "";

  Map<String, dynamic> calcularImc() {
    double? numPeso = double.tryParse(peso.text);
    double? numAltura = double.tryParse(altura.text);

    if (_validacaoModel.isNull(numPeso, numAltura)) {
      return {
        'sucesso': false,
        'mensagem': "Digite um valor válido para o cálculo!",
      };
    }

    double resultadoCalculo = _formulaImcModel.calcularImc(
      numPeso!,
      numAltura!,
    );
    String resultadoFormatado = resultadoCalculo.toStringAsFixed(2);

    classificacao = classificacaoImc(resultadoCalculo);
    resultado = "$resultadoFormatado";

    return {
      'sucesso': true,
      'mensagem': "Imc: $resultadoFormatado\nClassificação: $classificacao",
    };
  }

  String classificacaoImc(double resultado) {
    if (resultado < 18.5) {
      return classificacao = "Magreza";
    } else if (resultado < 25) {
      return classificacao = "Peso Adequado";
    } else if (resultado < 30) {
      return classificacao = "Sobrepeso";
    } else if (resultado < 35) {
      return classificacao = "Obesidade grau 1";
    } else if (resultado < 40) {
      return classificacao = "Obesidade grau 2";
    } else {
      return classificacao = "Obesidade grau 3";
    }
  }

  void dispose() {
    peso.dispose();
    altura.dispose();
  }
}
