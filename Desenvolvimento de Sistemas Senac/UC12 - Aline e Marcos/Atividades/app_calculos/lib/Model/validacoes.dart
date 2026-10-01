class ValidacaoTexto {
  bool isNull(String? valor) {
    if (valor == null || valor.isEmpty) {
      return true;
    } else {
      return false;
    }
  }
}

class ValidacaoNumero {
  bool isNull(double? num1, double? num2) {
    if (num1 == null || num2 == null) {
      return true;
    }
    return false;
  }
}
