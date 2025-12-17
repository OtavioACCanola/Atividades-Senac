# Importações
import math, os, csv, sys
from PyQt5.QtWidgets import QMessageBox, QApplication
from PyQt5 import uic, QtWidgets

# Janela
app = QtWidgets.QApplication([])
janela = uic.loadUi("Atividades Python POO/Tela Area Formas Geometricas.ui")

# Variáveis Globais
pi = 3,14
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
        lado1 * lado2
        return
        

class Triamgulo(Formula):
    def __init__(self, base, altura):
        super().__init__()
        self.base = base
        self.altura = altura

    def calcularArea(self, base, altura):
        area = base * altura / 2
        global areaTriangulo
        areaTriangulo == area
        QMessageBox.information(janela, "Validação", "Valores adicionados")

class Circulo(Formula):
    
    def __init__(self, raio):
        super().__init__()
        self.raio = raio

    def calcularArea(self, raio):
        area = pi * (raio * raio)
        global areaCirculo
        areaCirculo == area
        QMessageBox.information(janela, "Validação", "Valores adicionados")
        
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
                int1 = int(janela.TxtValor1.text())
                int2 = int(janela.TxtValor2.text())
                soma = int(obj_Quadrado.calcularArea(int1, int2))
                areaQuadrado = soma    
                resultado = [
                    ["Quadrado"],
                    [f"Área: {areaQuadrado}"]
                ]
                with open("Atividades Python POO/Areas.csv", "a", newline= "") as arquivo:
                    escritor = csv.writer(arquivo)
                    escritor.writerows(resultado) 
                QMessageBox.information(janela, "Calculo", "Calculo Realizado com Sucesso")
                mostrarResultados()
        except ValueError:
            QMessageBox.critical(janela, "Erro", "Adicione apenas Números Inteiros nos campos")
            janela.TxtValor1.clear()
            janela.TxtValor2.clear()
    
    elif janela.BtnTriangulo.isChecked():
         if janela.TxtValor1.text() == "" or janela.TxtValor2.text() == "":
            QMessageBox.critical(janela, "Erro", "Os campos precisam estar preenchidos!")
         else:
            obj_Triangulo = Triamgulo(janela.TxtValor1.text(), janela.TxtValor2.text())
            resultado = [
                ["Quadrado"],
                [f"Área: {areaTriangulo}"]
            ]
            with open("Areas.csv", "a", newline= "") as arquivo:
                escritor = csv.writer(arquivo)
                escritor.writerows(resultado) 
    
    elif janela.BtnCirculo.isChecked():
         if janela.TxtValor1.text() == "":
            QMessageBox.critical(janela, "Erro", "O campo precisa estar preenchido!")
         else:
            obj_Ciruclo = Circulo(janela.TxtValor1.text())
            resultado = [
            ["Quadrado"],
            [f"Área: {areaCirculo}"]
        ]
            with open("Areas.csv", "a", newline= "") as arquivo:
                escritor = csv.writer(arquivo)
                escritor.writerows(resultado) 
    else:
        QMessageBox.information(janela, "Atenção", "Selecione uma das Opções para Calcular")

def mostrarInformacoesCampos():
    if janela.BtnQuadrado.isChecked():
        janela.TxtValor1.move(20, 160)
        janela.TxtValor2.move(20, 210)
        janela.TxtValor2.setVisible(True) # Aparecer outra lineEdit
        janela.TxtValor1.setPlaceholderText("1º Lado do Quadrado")
        janela.TxtValor2.setPlaceholderText("2º Lado do Quadrado")
    
    elif janela.BtnTriangulo.isChecked():
        janela.TxtValor1.move(20, 160)
        janela.TxtValor2.move(20, 210)
        janela.TxtValor2.setVisible(True) # Aparecer outra lineEdit
        janela.TxtValor1.setPlaceholderText("Base do Triângulo")
        janela.TxtValor2.setPlaceholderText("Altura do Triângulo")

    elif janela.BtnCirculo.isChecked():
        janela.TxtValor1.move(20, 190)
        janela.TxtValor2.setVisible(False) # Desaparecer outra lineEdit
        janela.TxtValor1.setPlaceholderText("Raio do Círulo")
        
def mostrarResultados():
    if os.path.getsize("Areas.csv") == 0:
        QMessageBox.critical(janela, "Atenção", "Não foi feito nenhum calculo ainda")
    else:
        with open("Areas.csv", "r") as arquivo:
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
janela.BtnListar.clicked.connect(mostrarResultados)
janela.TxtResultado.setReadOnly(True)

janela.show()
app.exec_()
