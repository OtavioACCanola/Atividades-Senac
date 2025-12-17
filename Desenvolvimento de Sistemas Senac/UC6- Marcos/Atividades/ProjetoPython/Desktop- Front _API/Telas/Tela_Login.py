import sys
from PyQt5.QtWidgets import QApplication, QWidget, QLabel, QLineEdit, QPushButton, QMessageBox

#***
# # Vamos definir 3 funções que nos auxiliarão neste exemplo:
# 1º- validaCampos -> Responsável por validar se os campos Usuário e Senha foram informados; 
# 2º- Login -> Responsável pela validação se ambos os campos estão corretos;
# 3º- limpaCampos -> Responsável por limpar as caixas de textos quando solicitado
#***

#Função para validar se os campos foram preenchidos
def validaCampos(): # def seria o termo para determinar um método no Python
    usuario = caixaTextoUsuario.text()
    senha = caixaTextoSenha.text()

    # Verificação do Usuário e Senha
    if usuario == "" or senha == "":
        QMessageBox.critical(telaLogin, "Atenção", "Para validação os dois campos precisam ser informados!") # Cria um popUp com algo escrito na tela
        limpaCampos() # Método
    else:
        Login(usuario, senha)

#Função para Validar o Usuário e Senha
def Login(usuario, senha):
    # Verificação do Usuário e Senha
    if usuario == "admin" and senha == "pass123$":
        QMessageBox.information(telaLogin, "Sucesso", f"Bem-Vindo, {usuario}!") # Cria um popUp com algo escrito na tela
    else:
        limpaCampos()
        QMessageBox.warning(telaLogin, "Falha no Login", "Usuario ou senha inválidos!") # Cria um popUp com algo escrito na tela

#Função para Limpar os Campos e Posicionar o Cursor
def limpaCampos():
    # Verificarção do Usuário e Senha
    caixaTextoUsuario.clear() # .clear() apaga o que for escrito na variável
    caixaTextoSenha.clear() # .clear() apaga o que for escrito na variável
    caixaTextoUsuario.setFocus() # .clear() apaga o que for escrito na variável

"***"
"Desenhando a tela de Login"
"***"

# *Criando a aplicação   
app = QApplication(sys.argv) # Cria uma aplicação

# Criando a Janela 
telaLogin = QWidget() # Comando para criar a tela
telaLogin.setWindowTitle("Login") # Define o título da janela
telaLogin.setGeometry(100, 100, 300, 200) # Indica os valores x, y, largura e altura da tela, nessa ordem

# *Criando um Rótulo (Label) # Mensagem que indicam o que vai ser escrito, como nome:, altura:, etc
# -Usuário
textoRotuloUsuario = QLabel("Usuario", telaLogin) # Colocamos esses parenteses para apresentar em que tela a linha estará
textoRotuloUsuario.move(80,30) # Indica qual posição x e y estará essa caixa de textp na tela
# -Senha
textoRotuloSenha = QLabel("Senha", telaLogin) # Colocamos esses parenteses para apresentar em que tela a linha estará
textoRotuloSenha.move(80,80) # Indica qual posição x e y estará essa caixa de textp na tela

# *Criando uma Caixa de Texto
# -Usuario
caixaTextoUsuario = QLineEdit(telaLogin) # Colocamos esses parenteses para apresentar em que tela a linha estará
caixaTextoUsuario.move(80,50) # Indica qual posição x e y estará essa caixa de textp na tela
# -Senha
caixaTextoSenha = QLineEdit(telaLogin) # Colocamos esses parenteses para apresentar em que tela a linha estará
caixaTextoSenha.setEchoMode(QLineEdit.Password) # Faz com que invez de aparecer os caracteres, deixe os '*' para ocultar a senha
caixaTextoSenha.move(80,100) # Indica qual posição x e y estará essa caixa de textp na tela

# Criando um Botão
botao = QPushButton("Entrar", telaLogin) # Primeiro colocamos o nome do botão e depois em qual tela ele vai ficar)
botao.move(102,140) # Indica qual posição x e y estará essa caixa de textp na tela

# Conectando o clique do botão à função
botao.clicked.connect(validaCampos) # Colocamos que ação o botão executará, colocando um método que criamos

# Exibindo a Janela
telaLogin.show() # Mostra a tela que queremos 

# Iniciando o loop de Eventos
sys.exit(app.exec_()) # Faz com que a tela não seja fechada enquanto não clicarmos para fechar
