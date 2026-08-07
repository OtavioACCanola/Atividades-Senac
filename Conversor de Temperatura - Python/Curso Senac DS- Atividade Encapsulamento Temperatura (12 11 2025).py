# Fazer Tela: OK
# Conectar atributos tela variáveis
# Colocar o texto da tela como texto do método
# Fazer o método de Conversão para Fahrenheit

from PyQt5 import QtWidgets, uic 
from PyQt5.QtWidgets import QMessageBox
app = QtWidgets.QApplication([])
janelinha = uic.loadUi("Tela Conversao Celsius.ui")


class controleTemperatura:
    def __init__(self, temperaturaCelsius): # Método Construtor
        self.__temperaturaCelsius = temperaturaCelsius

    @property # Getter, getter tem que ter o mesmo nome da variável
    def temperatura(self):
        QMessageBox.information(janelinha, "Temperatura", f"Temperatura Celsius: {self.__temperaturaCelsius}")
        return self.__temperaturaCelsius
    
    @temperatura.setter #Setter, setter tem que ter o mesmo nome do getter
    def temperatura(self, temperatura):
       try:
        float_temperatura = float(temperatura)
        if float_temperatura < -50 or float_temperatura > 100:
            QMessageBox.information(janelinha, "Erro", f"Temperatura Inválida! Deve estar entre -50° e 100° celsius")
        else:
            self.__temperaturaCelsius = float_temperatura
            QMessageBox.information(janelinha, "Definição", f"Seu valor foi definido para: {self.__temperaturaCelsius:.2f}")

       except ValueError:
         QMessageBox.critical(janelinha, "Erro", "O valor precisa ser um número!")

       
    def converter_para_Fahrenheit(self): # Método para Alterar o Celsius para Fahrenheit

        fahrenheit = self.__temperaturaCelsius * 1.8 + 32
        mensagem = "==== Conversão ====\n\n"f"Celsius: {self.__temperaturaCelsius}\n"f"Conversão: {fahrenheit:.2f}"
        janelinha.TxtResultado.setText(mensagem)

Objeto = controleTemperatura(0)

def definir_Temperatura():
   texto = janelinha.TxtTemperatura.text()
   Objeto.temperatura = texto

def converter():
   Objeto.converter_para_Fahrenheit()
   


# ================================ TELA ===========================================

janelinha.BtnConversao.clicked.connect(converter)
janelinha.BtnDefinir.clicked.connect(definir_Temperatura)

janelinha.show()
app.exec_()


