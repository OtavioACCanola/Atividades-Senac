# Fazer o Editar
# Editat a Tela Editar para mostrar os nomes dos usuários para editar

# Importações
import sys
from PyQt5.QtWidgets import QMessageBox, QLabel, QLineEdit, QApplication, QPushButton, QWidget, QRadioButton, QTextEdit, QComboBox
from PyQt5.QtGui import QFont
from DAO_Usuario import DAO_Usuario

# Criando a Aplicação
app = QApplication(sys.argv)

# =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= MÉTODOS =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

# def conectNomeComboBox():
#     Opcoes.setVisible(True)
#     Opcoes.move(10,160)

#     lista = [DAO_Usuario.consultarNomes]
#     for nomes in lista:
#         Opcoes.addItem(nomes[0])

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
            RBtnCadastrar.setChecked(True)
            informacoesFuncao()
            esconderBotao()
            BtnCadastrar.setVisible(True)
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
    Id = TxtIDTP.text()
    email = TxtEmailTP.text()
    senha = TxtSenhaTP.text()
    nome = TxtNomeTP.text()

    if email == "" or senha == "" or nome == "":
        QMessageBox.critical(JanelaLogin, "Erro", "Os Campos Precisam Estar Preenchidos!")
        limpaCampo()
    else:
        edicao = DAO_Usuario.Editar(self, Id, email, senha, nome)
        if edicao == True:
            QMessageBox.information(JanelaPrincipal, "Edição", "Usuário Editado com Sucesso!")
            limpaCampo()
        else:
            QMessageBox.critical(JanelaPrincipal, "Erro", "Usuário não Encontrado no Banco")
        

def Listar(self):
    # Separar usuários por Parágrafos
    TxtListar.setVisible(True)
    lista = str(DAO_Usuario.concultarTodos(self))
    TxtListar.setText(lista)

# Fazer um def Editar

def esconderBotao():
    BtnCadastrar.setVisible(False)
    BtnEditar.setVisible(False)
    BtnLogin.setVisible(False)
    BtnRemover.setVisible(False)
    Opcoes.setVisible(False)

def limpaCampo():
    TxtEmail.clear()
    TxtSenha.clear()
    TxtEmailTP.clear()
    TxtNomeTP.clear()
    TxtSenhaTP.clear()
    TxtIDTP.clear()

def informacoesFuncao():
    TxtListar.setVisible(False)

    if RBtnCadastrar.isChecked():
        esconderBotao()
        LblNomeTP.setVisible(True)
        LblSenhaTP.setVisible(True)
        LblEmailTP.setVisible(True)
        LblIDTP.setVisible(False)
        BtnLogin.setVisible(True)

        LblNomeTP.move(30, 160)
        LblEmailTP.move(30,200)
        LblSenhaTP.move(30, 240)
        
        TxtNomeTP.setVisible(True)
        TxtEmailTP.setVisible(True)
        TxtSenhaTP.setVisible(True)
        TxtIDTP.setVisible(False)

        TxtNomeTP.move(80,160)
        TxtEmailTP.move(80, 200)
        TxtSenhaTP.move(80, 240)
        BtnCadastrar.setVisible(True)

    elif RBtnRemover.isChecked():
        esconderBotao()
        LblNomeTP.setVisible(False)
        LblEmailTP.setVisible(True)
        LblSenhaTP.setVisible(False)
        LblIDTP.setVisible(False)

        LblNomeTP.move(30, 160)
        LblEmailTP.move(30,200)
        LblSenhaTP.move(30, 240)

        TxtNomeTP.setVisible(False)
        TxtSenhaTP.setVisible(False)
        TxtIDTP.setVisible(False)
        TxtEmailTP.move(80, 200)
        
        BtnRemover.setVisible(True)

# Tela Editar
    elif RBtnEditar.isChecked():
        
        esconderBotao()
        LblNomeTP.setVisible(True)
        LblEmailTP.setVisible(True)
        LblSenhaTP.setVisible(True)
        LblIDTP.setVisible(True)

        LblIDTP.move(40,160)
        LblNomeTP.move(20, 190)
        LblEmailTP.move(20,220)
        LblSenhaTP.move(20, 250)

        TxtIDTP.setVisible(True)
        TxtNomeTP.setVisible(True)
        TxtEmailTP.setVisible(True)
        TxtSenhaTP.setVisible(True)

        TxtIDTP.move(70,160)
        TxtNomeTP.move(70,190)
        TxtEmailTP.move(70, 220)
        TxtSenhaTP.move(70, 250)

        BtnEditar.setVisible(True)

    elif RBtnListar.isChecked():
        esconderBotao()
        LblNomeTP.setVisible(False)
        LblEmailTP.setVisible(False)
        LblSenhaTP.setVisible(False)
        LblIDTP.setVisible(False)

        TxtNomeTP.setVisible(False)
        TxtEmailTP.setVisible(False)
        TxtSenhaTP.setVisible(False)
        TxtIDTP.setVisible(False)
        TxtListar.setVisible(True)
        TxtListar.move(30,140)

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

# ID
LblIDTP = QLabel("ID: ", JanelaPrincipal)
LblIDTP.setVisible(False)

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

# ID
TxtIDTP = QLineEdit(JanelaPrincipal)
TxtIDTP.setVisible(False)
TxtIDTP.setFixedWidth(181)

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

# ------------------- COMBO BOX -------------------

Opcoes = QComboBox(JanelaPrincipal)

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
BtnEditar.clicked.connect(Editar)

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

JanelaLogin.show()

# ------------------- Loop de Exibição -------------------
sys.exit(app.exec_())

