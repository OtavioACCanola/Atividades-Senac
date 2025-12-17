# Colocar as funções da DAO na View para Funcionar

# Importações
import sys
from PyQt5.QtWidgets import QMessageBox, QLabel, QLineEdit, QApplication, QPushButton, QWidget, QRadioButton, QTextEdit
from PyQt5.QtGui import QFont

from DAO_Usuario import DAO_Usuario

# Criando a Aplicação
app = QApplication(sys.argv)

# =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= MÉTODOS =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

def Autenticar(self):
    email = TxtEmail.text()
    senha = TxtSenha.text()

    if TxtEmail.text() == "" or TxtSenha.text() == "":
        QMessageBox.critical(JanelaLogin, "Erro", "Os Campos Precisam Estar Preenchidos!")
    else:
        Autenticar = DAO_Usuario.Autenticar(self, email, senha)
        if Autenticar is True:
            QMessageBox.information(JanelaLogin, "Login", "Acesso Concedido!")
            JanelaLogin.close()
            JanelaPrincipal.show()
            RBtnCadastrar.setCheckable(True)
            esconderBotao()
        else:
            QMessageBox.critical(JanelaLogin, "Erro", "Email ou Senha Incorretos, Tente Novamente!")
            limpaCampo()

def Cadastrar(self):
    nome = TxtNomeTP.text()
    email = TxtEmailTP.text()
    senha = TxtSenhaTP.text()

    if nome == "" or email == "" or senha == "":
        QMessageBox.critical(JanelaLogin, "Erro", "Os Campos Precisam Estar Preenchidos!")
        limpaCampo()
    else:
        DAO_Usuario.Cadastrar(self, nome, email, senha)
        QMessageBox.information(JanelaPrincipal, "Cadastro", "Cadastro Realizado com Sucesso!")
        limpaCampo()

def Remover(self):
    email = TxtEmailTP.text()

    if email == "":
        QMessageBox.critical(JanelaLogin, "Erro", "Os Campos Precisam Estar Preenchidos!")
        limpaCampo()
    else:
        DAO_Usuario.Remover(self, email)
        QMessageBox.information(JanelaPrincipal, "Cadastro", "Cadastro Realizado com Sucesso!")
        limpaCampo()

def Editar(self):
    email = TxtEmailTP.text()

    if email == "":
        QMessageBox.critical(JanelaLogin, "Erro", "Os Campos Precisam Estar Preenchidos!")
        limpaCampo()
    else:
        DAO_Usuario.Remover(self, email)
        QMessageBox.information(JanelaPrincipal, "Remoção", "Usuário Removido com Sucesso!")
        limpaCampo()

def Listar(self):
    email = TxtEmailTP.text()

    listaUsuario = str(DAO_Usuario.concultarTodos)
    TxtListar.setText(listaUsuario)

def esconderBotao():
    BtnCadastrar.setVisible(False)
    BtnEditar.setVisible(False)
    BtnLogin.setVisible(False)
    BtnRemover.setVisible(False)

def limpaCampo():
    TxtEmail.clear()
    TxtSenha.clear()
    TxtEmailTP.clear()
    TxtNomeTP.clear()
    TxtSenhaTP.clear()

def informacoesFuncao():
    TxtListar.setVisible(False)

    if RBtnCadastrar.isChecked():
        esconderBotao()
        LblNomeTP.setVisible(True)
        LblSenhaTP.setVisible(True)
        LblEmailTP.setVisible(True)
        BtnLogin.setVisible(True)

        LblNomeTP.move(30, 160)
        LblEmailTP.move(30,200)
        LblSenhaTP.move(30, 240)
        
        TxtNomeTP.setVisible(True)
        TxtEmailTP.setVisible(True)
        TxtSenhaTP.setVisible(True)

        TxtNomeTP.move(80,160)
        TxtEmailTP.move(80, 200)
        TxtSenhaTP.move(80, 240)
        BtnCadastrar.setVisible(True)

    elif RBtnRemover.isChecked():
        esconderBotao()
        LblNomeTP.setVisible(False)
        LblEmailTP.setVisible(True)
        LblSenhaTP.setVisible(False)
        
        TxtNomeTP.setVisible(False)
        TxtEmailTP.move(80, 200)
        TxtSenhaTP.setVisible(False)
        BtnRemover.setVisible(True)

    elif RBtnEditar.isChecked():
        esconderBotao()
        LblNomeTP.setVisible(True)
        LblEmailTP.setVisible(True)
        LblSenhaTP.setVisible(True)
        
        TxtNomeTP.setVisible(True)
        TxtEmailTP.setVisible(True)
        TxtSenhaTP.setVisible(True)
        BtnEditar.setVisible(True)

    elif RBtnListar.isChecked():
        esconderBotao()
        TxtNomeTP.setVisible(False)
        TxtEmailTP.setVisible(False)
        TxtSenhaTP.setVisible(False)
        TxtListar.setVisible(True)
        TxtListar.move(30,140)
        # TxtListar.setText(DAO_Usuario.concultarTodos)


# =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= TELA LOGIN =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 

# ------------------- TELA -------------------

JanelaLogin = QWidget()
JanelaLogin.setGeometry(800, 300, 258, 250)
JanelaLogin.setWindowTitle("Login")

# ------------------- LABELS -------------------

LblTituloTL = QLabel("Login", JanelaLogin)
LblTituloTL.move(80,20)
Fonte = QFont("MS Shell Dlg 2", 16)
Fonte.setBold(True)
LblTituloTL.setFont(Fonte)

LblEmail = QLabel("Email: ", JanelaLogin)
LblEmail.move(20, 80)

LblSenha = QLabel("Senha: ", JanelaLogin)
LblSenha.move(20, 130)

# ------------------- TEXTFIELDS -------------------

TxtEmail = QLineEdit(JanelaLogin)
TxtEmail.move(60, 80)

TxtSenha = QLineEdit(JanelaLogin)
TxtSenha.move(60, 130)

# ------------------- BOTÕES -------------------

BtnLogin = QPushButton("Logar", JanelaLogin)
BtnLogin.move(80,180)
BtnLogin.clicked.connect(Autenticar)

# =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= TELA PRINCIPAL =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

# ------------------- TELA -------------------

JanelaPrincipal = QWidget()
JanelaPrincipal.setGeometry(800, 300, 477, 369)
JanelaPrincipal.setWindowTitle("Funções")

# ------------------- LABELS -------------------

# Título
LblTituloTP = QLabel("Banco de Dados", JanelaPrincipal)
LblTituloTP.move(120,10)
FonteTitulo = QFont("MS Shell Dlg 2", 20)
FonteTitulo.setBold(True)
LblTituloTP.setFont(FonteTitulo)

# Nome
LblNomeTP = QLabel("Nome: ", JanelaPrincipal)
LblNomeTP.setVisible(False)

# Email
LblEmailTP = QLabel("Email: ", JanelaPrincipal)
LblEmailTP.setVisible(False)

# Senha
LblSenhaTP = QLabel("Senha: ", JanelaPrincipal)
LblSenhaTP.setVisible(False)

# ------------------- TEXTFIELDS ------------------- 

# Nome
TxtNomeTP = QLineEdit(JanelaPrincipal)
TxtNomeTP.setVisible(False)
TxtNomeTP.setFixedWidth(241)

# Email
TxtEmailTP = QLineEdit(JanelaPrincipal)
TxtEmailTP.setVisible(False)
TxtEmailTP.setFixedWidth(241)

# Senha
TxtSenhaTP= QLineEdit(JanelaPrincipal)
TxtSenhaTP.setVisible(False)
TxtSenhaTP.setFixedWidth(151)

TxtListar = QTextEdit(JanelaPrincipal)
TxtListar.setVisible(False)
# ------------------- BOTÕES -------------------

# Cadastrar
BtnCadastrar = QPushButton("Cadastrar", JanelaPrincipal)
BtnCadastrar.move(180,290)
BtnCadastrar.clicked.connect(Cadastrar)

RBtnCadastrar = QRadioButton("Cadastrar", JanelaPrincipal)
RBtnCadastrar.move(30,80)
RBtnCadastrar.clicked.connect(informacoesFuncao)

# Remover
BtnRemover = QPushButton("Remover", JanelaPrincipal)
BtnRemover.move(180,290)

RBtnRemover = QRadioButton("Remover", JanelaPrincipal)
RBtnRemover.move(160,80)
RBtnRemover.clicked.connect(informacoesFuncao)

# Editar
BtnEditar = QPushButton("Editar", JanelaPrincipal)
BtnEditar.move(180,290)

RBtnEditar = QRadioButton("Editar", JanelaPrincipal)
RBtnEditar.move(290,80)
RBtnEditar.clicked.connect(informacoesFuncao)

# Listar
RBtnListar = QRadioButton("Listar", JanelaPrincipal)
RBtnListar.move(390,80)
RBtnListar.clicked.connect(informacoesFuncao)
RBtnListar.clicked.connect(Listar)

# =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= RODAR TELA =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

# ------------------- Exibindo Janela ------------------- 
JanelaPrincipal.show()

# ------------------- Loop de Exibição -------------------
sys.exit(app.exec_())

