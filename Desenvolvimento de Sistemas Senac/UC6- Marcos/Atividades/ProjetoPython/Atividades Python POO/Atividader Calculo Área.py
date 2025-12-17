# Importações
import math, os, csv, sys
from PyQt5.QtWidgets import QMessageBox, QApplication
from PyQt5 import uic, QtWidgets

# Janela
app = QtWidgets.QApplication([])
janela = uic.loadUi("Atividades Python POO/Tela Area Formas Geometricas.ui")

# Variáveis Globais
pi = 3.14
areaQuadrado = 0
areaTriangulo = 0
areaCirculo = 0

# Classe Abstrata
class Formula():
    def calcularArea():
        raise NotImplementedError("Subclasses devem importar esse método")

# Classes
class Quadrado(Formula):
    def __init__(self):
        super().__init__() # Super da Classe Abstrata

    def calcularArea(self, lado1, lado2):
        return lado1 * lado2
        

class Triamgulo(Formula):
    def __init__(self):
        super().__init__()

    def calcularArea(self, base, altura):
        return base * altura / 2

class Circulo(Formula):
    
    def __init__(self):
        super().__init__()

    def calcularArea(self, raio):
        return pi * (raio*raio)
                
# Colocar o resultado no Areas
# Dando erro no calculo, pois o valor não está fazendo a conta
def calcular():
    if janela.BtnQuadrado.isChecked():
        try:
            print("oi")
            if janela.TxtValor1.text() == "" or janela.TxtValor2.text() == "":
                QMessageBox.critical(janela, "Erro", "Os campos precisam estar preenchidos!")
            else:
                global areaQuadrado
                obj_Quadrado = Quadrado()
                int1Q = int(janela.TxtValor1.text())
                int2Q = int(janela.TxtValor2.text())
                somaQ = obj_Quadrado.calcularArea(int1Q, int2Q)
                areaQuadrado = somaQ    
                resultado = [
                    ["Quadrado"],
                    [f"Lado 1: {int1Q}"],
                    [f"Lado 2: {int2Q}"],
                    [f"Área: {areaQuadrado}\n"]
                ]
                with open("Areas.csv", "a", newline= "") as arquivo:
                    escritor = csv.writer(arquivo)
                    escritor.writerows(resultado) 
                QMessageBox.information(janela, "Calculo", "Calculo Realizado com Sucesso")
                mostrarResultados()
        except ValueError:
            QMessageBox.critical(janela, "Erro", "Adicione apenas Números Inteiros nos campos")
            janela.TxtValor1.clear()
            janela.TxtValor2.clear()
    
    elif janela.BtnTriangulo.isChecked():
        try:
            if janela.TxtValor1.text() == "" or janela.TxtValor2.text() == "":
                 QMessageBox.critical(janela, "Erro", "Os campos precisam estar preenchidos!")
            else:
                global areaTriangulo
                obj_Triangulo = Triamgulo()
                int1T = int(janela.TxtValor1.text())
                int2T = int(janela.TxtValor2.text())
                somaT = obj_Triangulo.calcularArea(int1T, int2T)
                areaTriangulo = somaT
                resultado = [
                    ["Triângulo"],
                    [f"Base: {int1T}"],
                    [f"Altura: {int2T}"],
                    [f"Área: {areaTriangulo}\n"]
                ]
                with open("Areas.csv", "a", newline= "") as arquivo:
                    escritor = csv.writer(arquivo)
                    escritor.writerows(resultado)
                QMessageBox.information(janela, "Calculo", "Calculo Realizado com Sucesso")
                mostrarResultados()
        except ValueError:
            QMessageBox.critical(janela, "Erro", "Adicione apenas Números Inteiros nos campos")
            janela.TxtValor1.clear()
            janela.TxtValor2.clear()
    
    
    elif janela.BtnCirculo.isChecked():
        try: 
            if janela.TxtValor1.text() == "":
                QMessageBox.critical(janela, "Erro", "O campo precisa estar preenchido!")
            else:
                obj_Ciruclo = Circulo()
                int1C = int(janela.TxtValor1.text())
                somaC = obj_Ciruclo.calcularArea(int1C)
                areaCirculo = somaC
                resultado = [
                    ["Circulo"],
                    [f"Raio: {int1C}"],
                    [f"Area: {areaCirculo}\n"]
                ]
                with open("Areas.csv", "a", newline= "") as arquivo:
                    escritor = csv.writer(arquivo)
                    escritor.writerows(resultado) 
                QMessageBox.information(janela, "Calculo", "Calculo Realizado com Sucesso")
                mostrarResultados()
        except ValueError:
            QMessageBox.critical(janela, "Erro", "Adicione apenas Números Inteiros nos campos")
            janela.TxtValor1.clear()
            janela.TxtValor2.clear()

    else:
        QMessageBox.information(janela, "Atenção", "Selecione uma das Opções para Calcular")

def mostrarInformacoesCampos():
    if janela.BtnQuadrado.isChecked():
        janela.TxtValor1.move(20, 160)
        janela.TxtValor2.move(20, 210)
        janela.TxtValor2.setVisible(True) # Aparecer outra lineEdit
        janela.TxtValor1.setPlaceholderText("1º Lado do Quadrado")
        janela.TxtValor2.setPlaceholderText("2º Lado do Quadrado")
        janela.TxtValor1.clear()
        janela.TxtValor2.clear()
    
    elif janela.BtnTriangulo.isChecked():
        janela.TxtValor1.move(20, 160)
        janela.TxtValor2.move(20, 210)
        janela.TxtValor2.setVisible(True) # Aparecer outra lineEdit
        janela.TxtValor1.setPlaceholderText("Base do Triângulo")
        janela.TxtValor2.setPlaceholderText("Altura do Triângulo")
        janela.TxtValor1.clear()
        janela.TxtValor2.clear()

    elif janela.BtnCirculo.isChecked():
        janela.TxtValor1.move(20, 190)
        janela.TxtValor2.setVisible(False) # Desaparecer outra lineEdit
        janela.TxtValor1.setPlaceholderText("Raio do Círulo")
        janela.TxtValor1.clear()

def mostrarResultados():
    if os.path.getsize("Areas.csv") == 0:
        QMessageBox.critical(janela, "Atenção", "Não foi feito nenhum calculo ainda")
    else:
        with open("Areas.csv", "r") as arquivo:
            janela.TxtResultado.clear()
            leitor = csv.reader(arquivo)
            vetorFormatado = []
            for linha in leitor:
                linha_String = ", ".join(linha)
                vetorFormatado.append(linha_String)
            stringFinal = "\n".join(vetorFormatado)
            janela.TxtResultado.setText(stringFinal)

# Definindo Botões e TextFields
janela.BtnQuadrado.toggled.connect(mostrarInformacoesCampos)
janela.BtnTriangulo.toggled.connect(mostrarInformacoesCampos)
janela.BtnCirculo.toggled.connect(mostrarInformacoesCampos)
janela.BtnCalcular.clicked.connect(calcular)
janela.TxtResultado.setReadOnly(True)

janela.show()
app.exec_()
