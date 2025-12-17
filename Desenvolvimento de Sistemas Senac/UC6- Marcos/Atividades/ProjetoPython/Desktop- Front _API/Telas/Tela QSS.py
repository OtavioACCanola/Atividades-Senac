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

# ===================== MANEIRA CORRETA ========================

# Carregamdo o QSS Externo
with open("Curso Senac DS- Estilos.qss", "r") as arquivo_qss:
    estilo = arquivo_qss.read()
    app.setStyleSheet(estilo)

# QWidget {
#     background-color: pink; #Cor de Fundo da Janela
#     border: 1px solid #3498db; # Borda Azul da Janela
#     border-radius: 10 px; # Bordas Arredondadas

# QLabel{
#     color: #2c3e50; # Cor do Texto da Label
#     font-size: 14px; # Tamanho da Fonte
#     font-weight: bold; # Negrito

# QPushButton{
#     background-color: #3498db; # Cor de Fundo do Botão
#     color: white; # Cor do Texto do Botão
#     border: 1px solid #2980b9; # Borda Azul-Escuro
#     border-radius: 5px; # Bordas Arredondadas   
#     padding: 5px; # Espaçamento Interno
#     font-size: 12px; # Tamanho da Fonte                     
# }                  

#     QPushButton: hover {
#     background-color: #2980b9; # Cor ao Passar o Mouse                     
# }                        
#     QPushButton: pressed{
#     background-color: #1f639e; # Cor ao Pressionar
# }
# botaoCustomizado{
#     background-color: #fbff67
#     color: black;
#     border: 2px solid #ffcf2a;
#     border-radius: 5px;
# }

# # botaoCustomizado: hover{
#     background-color: #ffcf2a;
# }

# # ClasseBotao{
#     background-color: #fb29f5;
#     color: white;
#     border: 2px solid #980398;
#     border-radius: 5px;
# }

# # ClasseBotao: hover{
#     background-color: #980398;
# }

# Criando um Rótulo(Label)
textoRotulo = QLabel('Clique no botão abaixo', janelinha)
textoRotulo.move(130,30)

# Criando um Botão
botao = QPushButton('Clique aqui', janelinha)
botao.setObjectName("botaoCustomizado") # Definindo o ID do Botão 
botao.move(150,70)

# Criando Dois Botões e Atribuindo Nomes (Como Classes)
botao2 = QPushButton("Botão 1", janelinha)
botao2.setObjectName('classeBotao')
botao2.move(80,70)

botao3 = QPushButton("Botão 2", janelinha)
botao3.setObjectName('classeBotao')
botao3.move(230,70)

# Criando uma Caixa de Texto
caixaTexto = QLineEdit(janelinha)
caixaTexto.move(130,110)

# Conectando o Clique ao Botão à Função
botao.clicked.connect(botaoClicado)

# Exibindo a Janela
janelinha.show()

# Iniciando o loop de eventos
sys.exit(app.exec_())