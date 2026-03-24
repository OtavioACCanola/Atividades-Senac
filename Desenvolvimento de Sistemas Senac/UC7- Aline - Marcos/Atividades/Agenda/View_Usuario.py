# =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= IMPORTAÇÕES =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 

from PyQt5.QtWidgets import QWidget, QLabel, QTextEdit, QLineEdit, QPushButton, QComboBox, QRadioButton, QMessageBox, QCheckBox
from PyQt5.QtGui import QIcon, QFont

# =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= TELA LOGIN =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= 

class JanelaLogin():
    
    # ------------------- TELA -------------------
    def __init__(self):
        super().__init__()
        self.JanelaLogin = QWidget()
        self.JanelaLogin.setGeometry(800, 300, 258, 250)
        self.JanelaLogin.setWindowTitle("Login")
        

        # ------------------- LABELS -------------------
        self.LblTituloTL = QLabel("Login", self.JanelaLogin)
        self.LblTituloTL.move(80,20)
        self.Fonte = QFont("MS Shell Dlg 2", 16)
        self.Fonte.setBold(True)
        self.LblTituloTL.setFont(self.Fonte)

        self.LblEmail = QLabel("Email: ", self.JanelaLogin)
        self.LblEmail.move(20, 80)

        self.LblSenha = QLabel("Senha: ", self.JanelaLogin)
        self.LblSenha.move(20, 130)

        # ------------------- TEXTFIELDS -------------------

        self.TxtEmail = QLineEdit(self.JanelaLogin)
        self.TxtEmail.move(60, 80)

        self.TxtSenha = QLineEdit(self.JanelaLogin)
        self.TxtSenha.setEchoMode(QLineEdit.Password) # Adicione isso aqui!
        self.TxtSenha.move(60, 130)

        # ------------------- BOTÕES -------------------

        self.BtnLogin = QPushButton("Logar", self.JanelaLogin)
        self.BtnLogin.move(80,180)
        # self.BtnLogin.clicked.connect(Model_Usuario.Autenticar)

        self.CBtnMostrarSenha = QCheckBox("", self.JanelaLogin)
        self.CBtnMostrarSenha.move(200,133)


    # =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= ICONE TELA =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        
        self.JanelaLogin.setWindowIcon(QIcon('Logo Login Banco de Dados.png'))

    # =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= MÉTODOS =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
    
    def mostrarSenha(self):
        
        if self.CBtnMostrarSenha.isChecked():
            self.TxtSenha.setEchoMode(QLineEdit.Normal)
        else:
            self.TxtSenha.setEchoMode(QLineEdit.Password)

# =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= TELA PRINCIPAL =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

class JanelaPrincipal():

    def __init__(self):
        self.JanelaLogin = JanelaLogin()
        
    # ------------------- TELA -------------------

        self.JanelaPrincipal = QWidget()
        self.JanelaPrincipal.setGeometry(800, 300, 477, 369)
        self.JanelaPrincipal.setWindowTitle("Funções")

    # ------------------- LABELS -------------------

    # Título
        self.LblTituloTP = QLabel("Banco de Dados", self.JanelaPrincipal)
        self.LblTituloTP.move(120,10)
        self.FonteTitulo = QFont("MS Shell Dlg 2", 20)
        self.FonteTitulo.setBold(True)
        self.LblTituloTP.setFont(self.FonteTitulo)

    # Nome
        self.LblNomeTP = QLabel("Nome: ", self.JanelaPrincipal)
        self.LblNomeTP.setVisible(False)

    # Email
        self.LblEmailTP = QLabel("Email: ", self.JanelaPrincipal)
        self.LblEmailTP.setVisible(False)

    # Senha
        self.LblSenhaTP = QLabel("Senha: ", self.JanelaPrincipal)
        self.LblSenhaTP.setVisible(False)

        self.LblSenha2TP = QLabel("Confirme sua Senha: ", self.JanelaPrincipal)
        self.LblSenha2TP.setVisible(False)

    # ------------------- TEXTFIELDS ------------------- 

    # Nome
        self.TxtNomeTP = QLineEdit(self.JanelaPrincipal)
        self.TxtNomeTP.setVisible(False)
        self.TxtNomeTP.setFixedWidth(241)

    # Email
        self.TxtEmailTP = QLineEdit(self.JanelaPrincipal)
        self.TxtEmailTP.setVisible(False)
        self.TxtEmailTP.setFixedWidth(241)

    # Senha
        self.TxtSenhaTP= QLineEdit(self.JanelaPrincipal)
        self.TxtSenhaTP.setEchoMode(QLineEdit.Password) # Adicione isso aqui!
        self.TxtSenhaTP.setVisible(False)
        self.TxtSenhaTP.setFixedWidth(151)

        self.Txt2SenhaTP = QLineEdit(self.JanelaPrincipal)
        self.Txt2SenhaTP.setEchoMode(QLineEdit.Password)
        self.Txt2SenhaTP.setVisible(False)
        self.Txt2SenhaTP.setFixedWidth(151)

    # Caixa de Texto
        self.TxtListar = QTextEdit(self.JanelaPrincipal)
        self.TxtListar.setVisible(False)

    # ------------------- COMBO BOX -------------------

        self.Opcoes = QComboBox(self.JanelaPrincipal)
        self.Opcoes.setVisible(False)
        self.Opcoes.move(80,80)
        self.Opcoes.setFixedWidth(121)

    # ------------------- BOTÕES -------------------

    # Cadastrar
        self.BtnCadastrar = QPushButton("Cadastrar", self.JanelaPrincipal)
        self.BtnCadastrar.move(180,310)
        # self.BtnCadastrar.clicked.connect(Model_Usuario.Cadastrar)

        self.RBtnCadastrar = QRadioButton("Cadastrar", self.JanelaPrincipal)
        self.RBtnCadastrar.move(30,80)
        # self.RBtnCadastrar.clicked.connect(Model.informacoesFuncao)

    # Remover
        self.BtnRemover = QPushButton("Remover", self.JanelaPrincipal)
        self.BtnRemover.move(180,290)

        self.RBtnRemover = QRadioButton("Remover", self.JanelaPrincipal)
        self.RBtnRemover.move(160,80)
        # self.RBtnRemover.clicked.connect(Model.informacoesFuncao)

    # Editar
        self.BtnEditar = QPushButton("Editar", self.JanelaPrincipal)
        self.BtnEditar.move(180,290)
        # self.BtnEditar.clicked.connect(Model.Editar)

        self.RBtnEditar = QRadioButton("Editar", self.JanelaPrincipal)
        self.RBtnEditar.move(290,80)
        # self.RBtnEditar.clicked.connect(Model.informacoesFuncao)
        # self.RBtnEditar.clicked.connect(Model.consultarNomesId)

        # self.Opcoes.currentIndexChanged.connect(Model.buscarInformacaoUsuario)

    # Listar
        self.RBtnListar = QRadioButton("Listar", self.JanelaPrincipal)
        self.RBtnListar.move(390,80)
        # self.RBtnListar.clicked.connect(Model.informacoesFuncao)
        # self.RBtnListar.clicked.connect(Model.Listar)

    # Aparecer Senha
        self.CBtnMostrar = QCheckBox("", self.JanelaPrincipal)
        self.CBtnMostrar.setVisible(False)

    # =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= ICONE TELA =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
        
        self.JanelaPrincipal.setWindowIcon(QIcon('LogoSQLServer.png'))

    # =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= MÉTODOS =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=
        
    def esconderBotao(self):
        self.JanelaLogin.BtnLogin.setVisible(False)
        self.BtnEditar.setVisible(False)
        self.BtnRemover.setVisible(False)
        self.BtnCadastrar.setVisible(False)
        self.Opcoes.setVisible(False)
        self.CBtnMostrar.setVisible(False)

    def limpaCampo(self):
        self.JanelaLogin.TxtEmail.clear()
        self.JanelaLogin.TxtSenha.clear()
        self.TxtEmailTP.clear()
        self.TxtNomeTP.clear()
        self.TxtSenhaTP.clear()
        self.Txt2SenhaTP.clear()
        self.TxtEmailTP.setPlaceholderText(None)
        self.TxtNomeTP.setPlaceholderText(None)
        self.TxtSenhaTP.setPlaceholderText(None)
        self.Txt2SenhaTP.setPlaceholderText(None)

    def mostrarSenhaTP(self):
        if self.CBtnMostrar.isChecked():
            self.TxtSenhaTP.setEchoMode(QLineEdit.Normal)
            self.Txt2SenhaTP.setEchoMode(QLineEdit.Normal)
        else:
            self.TxtSenhaTP.setEchoMode(QLineEdit.Password)
            self.Txt2SenhaTP.setEchoMode(QLineEdit.Password)

    def limpaCampoSPlaceHolder(self):
        self.TxtNomeTP.clear()
        self.TxtEmailTP.clear()
        self.TxtSenhaTP.clear()

    def informacoesCadastrar(self):
        self.TxtListar.setVisible(False)

        # Colocar Confirmar Senha e suas funções (se senha não for igual a senha 1 dar erro)
        if self.RBtnCadastrar.isChecked():
            self.esconderBotao()
            self.limpaCampo()
            self.LblNomeTP.setVisible(True)
            self.LblSenhaTP.setVisible(True)
            self.LblSenha2TP.setVisible(True)
            self.LblEmailTP.setVisible(True)

            self.LblNomeTP.move(30, 140)
            self.LblEmailTP.move(30,180)
            self.LblSenhaTP.move(30, 220)
            self.LblSenha2TP.move(30, 260)
        
            self.TxtNomeTP.setVisible(True)
            self.TxtEmailTP.setVisible(True)
            self.TxtSenhaTP.setVisible(True)
            self.Txt2SenhaTP.setVisible(True)

            self.TxtNomeTP.move(80,140)
            self.TxtEmailTP.move(80, 180)
            self.TxtSenhaTP.move(80, 220)
            self.Txt2SenhaTP.move(140, 260)
            self.TxtListar.setVisible(False)


            self.BtnCadastrar.setVisible(True)

            self.CBtnMostrar.setVisible(True)
            self.CBtnMostrar.move(240,223)


    def informacoesRemover(self):
    
        if self.RBtnRemover.isChecked():
            self.esconderBotao()
            self.limpaCampo()
            self.LblNomeTP.setVisible(False)
            self.LblEmailTP.setVisible(True)
            self.LblSenhaTP.setVisible(False)
            self.LblSenha2TP.setVisible(False)

            self.LblNomeTP.move(30, 160)
            self.LblEmailTP.move(30,180)
            self.LblSenhaTP.move(30, 240)

            self.TxtNomeTP.setVisible(False)
            self.TxtSenhaTP.setVisible(False)
            self.Txt2SenhaTP.setVisible(False)
            self.TxtEmailTP.setVisible(True)
            self.TxtListar.setVisible(False)

            self.TxtEmailTP.move(80, 180)

            self.TxtEmailTP.setPlaceholderText("Digite um Email para ser removido")
        
            self.BtnRemover.setVisible(True)

    def informacoesEditar(self):

        if self.RBtnEditar.isChecked():
        
            self.esconderBotao()
            self.limpaCampo()
            self.LblNomeTP.setVisible(True)
            self.LblEmailTP.setVisible(True)
            self.LblSenhaTP.setVisible(True)
            self.Opcoes.setVisible(True)
            self.LblSenha2TP.setVisible(False)
            self.TxtListar.setVisible(False)


            self.Opcoes.move(20, 160)

            self.LblNomeTP.move(160, 160)
            self.LblEmailTP.move(160,190)
            self.LblSenhaTP.move(160, 220)

            self.TxtNomeTP.setVisible(True)
            self.TxtEmailTP.setVisible(True)
            self.TxtSenhaTP.setVisible(True)
            self.Txt2SenhaTP.setVisible(False)
            self.TxtListar.setVisible(False)

            self.TxtNomeTP.move(210,160)
            self.TxtEmailTP.move(210, 190)
            self.TxtSenhaTP.move(210, 220)

            self.BtnEditar.move(160,290)
            self.BtnEditar.setVisible(True)

    def informacoesListar(self):

        if self.RBtnListar.isChecked():
            self.esconderBotao()
            self.limpaCampo()
            self.LblNomeTP.setVisible(False)
            self.LblEmailTP.setVisible(False)
            self.LblSenhaTP.setVisible(False)
            self.LblSenha2TP.setVisible(False)

            self.TxtNomeTP.setVisible(False)
            self.TxtEmailTP.setVisible(False)
            self.TxtSenhaTP.setVisible(False)
            self.Txt2SenhaTP.setVisible(False)
            self.TxtListar.setVisible(True)
            self.TxtListar.move(30,140)

    def MensagemErroJanelaLogin(self, mensagem):
        QMessageBox.critical(self.JanelaLogin.JanelaLogin, "Erro", f"{mensagem}")

    def MensagemSucessoJanelaLogin(self, mensagem):
        QMessageBox.information(self.JanelaLogin.JanelaLogin, "Sucesso", f"{mensagem}")

    def MensagemErroJanelaPrincipal(self, mensagem):
        QMessageBox.critical(self.JanelaPrincipal, "Erro", f"{mensagem}")

    def MensagemSucessoJanelaPrincipal(self, mensagem):
        QMessageBox.information(self.JanelaPrincipal, "Sucesso", f"{mensagem}")
