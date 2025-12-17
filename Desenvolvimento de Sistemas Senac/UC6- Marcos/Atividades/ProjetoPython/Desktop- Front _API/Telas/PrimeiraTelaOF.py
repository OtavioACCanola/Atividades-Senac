# Importando a Biblioteca SYS

import sys
from PyQt5.QtWidgets import QApplication, QWidget, QLabel, QPushButton, QLineEdit, QMessageBox

# Função que Será Chamada ao Clicar no Botão
def botaoClicado():
    print('Você Clicou no Botão')
    QMessageBox.information(janelinha, "Texto Digitado", f"Você digitou: {caixaTexto.text()}")

# Criando a Aplicação
app = QApplication(sys.argv)

# Criando a Janela Principal
janelinha= QWidget()
janelinha.setWindowTitle('Primeira Aplicação Front-End')
janelinha.setGeometry(50,200,350,150)

# Criando um Rótulo(Label)
textoRotulo = QLabel('Clique no botão abaixo', janelinha)
textoRotulo.move(130,30)

# Criando um Botão
botao = QPushButton('Clique aqui', janelinha)
botao.move(150,70)

# Criando uma Caixa de Texto
caixaTexto = QLineEdit(janelinha)
caixaTexto.move(130,110)

# Conectando o Clique ao Botão à Função
botao.clicked.connect(botaoClicado)

# Exibindo a Janela
janelinha.show()

# Iniciando o loop de eventos
sys.exit(app.exec_())