# Passos:
# Validação de Informações da Conta antes de Editar

# Importações
from Model_Usuario import Model_Usuario
import View_Usuario

# =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-= CLASSES =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

class Controller():

    def __init__(self):
        self.model = Model_Usuario()
        self.JanelaLogin = View_Usuario.JanelaLogin()
        self.JanelaPrincipal = View_Usuario.JanelaPrincipal()
        
        self.JanelaLogin.BtnLogin.clicked.connect(self.Autenticar)
        self.JanelaLogin.CBtnMostrarSenha.stateChanged.connect(self.JanelaLogin.mostrarSenha)

        self.JanelaPrincipal.BtnCadastrar.clicked.connect(self.Cadastrar)
        self.JanelaPrincipal.BtnRemover.clicked.connect(self.Remover)
        self.JanelaPrincipal.RBtnListar.clicked.connect(self.Listar)
        self.JanelaPrincipal.BtnEditar.clicked.connect(self.Editar)

        self.JanelaPrincipal.RBtnCadastrar.toggled.connect(self.JanelaPrincipal.informacoesCadastrar)
        self.JanelaPrincipal.RBtnRemover.toggled.connect(self.JanelaPrincipal.informacoesRemover)
        self.JanelaPrincipal.RBtnEditar.toggled.connect(self.JanelaPrincipal.informacoesEditar)
        self.JanelaPrincipal.RBtnEditar.toggled.connect(self.consultarNomesId)
        self.JanelaPrincipal.Opcoes.currentIndexChanged.connect(self.buscarInformacaoUsuario)
        self.JanelaPrincipal.RBtnListar.toggled.connect(self.JanelaPrincipal.informacoesListar)
        self.JanelaPrincipal.CBtnMostrar.stateChanged.connect(self.JanelaPrincipal.mostrarSenhaTP)

    def Iniciar(self):
        janelaLogin = self.JanelaLogin.JanelaLogin
        janelaLogin.show()

    def consultarNomesId(self):

        try:

            if self.model.ListarNomeId() is not None:
                self.JanelaPrincipal.Opcoes.clear()
                for nomes, id in self.model.ListarNomeId(): # O primeiro elemento aqui é o que vai aparecer na ComboBox   
                    self.JanelaPrincipal.Opcoes.addItem(str(nomes), id)
                    self.buscarInformacaoUsuario()        
            else:
                self.JanelaPrincipal.MensagemErroJanelaPrincipal("Busca de Usuários não Concluída!")
        except Exception as e:
            self.JanelaPrincipal.MensagemErroJanelaPrincipal(f"{e}")
            
    def buscarInformacaoUsuario(self):

        # Se o ID for válido (maior que 0) ele busca no Banco
        if self.JanelaPrincipal.Opcoes.currentData():
            # Busca a Lista da DAO
            informacoes = self.model.ListarInfId(self.JanelaPrincipal.Opcoes.currentData())

            # Verifica se o Banco Retornou os Dados Corretamente
            if informacoes:
                self.JanelaPrincipal.TxtNomeTP.setPlaceholderText(str(informacoes[0][0])) # Pegamos a lista no 1º 0 e depois o valor do primeiro elemento da lista no 2º 0, ou seja, uma matriz, um vetor dentro de outro vetor
                self.JanelaPrincipal.TxtEmailTP.setPlaceholderText(str(informacoes[0][1]))

                return informacoes
    
    def Autenticar(self):

        if self.JanelaLogin.TxtEmail.text() == "" or self.JanelaLogin.TxtSenha.text() == "":
            self.JanelaPrincipal.MensagemErroJanelaLogin("Os campos precisam estar preenchidos")
        else:
            Autenticar = self.model.Autenticar(self.JanelaLogin.TxtEmail.text(), self.JanelaLogin.TxtSenha.text())
            if Autenticar is True:
                self.JanelaPrincipal.MensagemSucessoJanelaLogin("Acesso Concedido!")
                self.JanelaLogin.JanelaLogin.close()
                self.JanelaPrincipal.JanelaPrincipal.show()
                self.JanelaPrincipal.RBtnCadastrar.setChecked(True)
                self.JanelaPrincipal.informacoesCadastrar()
                self.JanelaPrincipal.BtnCadastrar.setVisible(True)
            else:
                self.JanelaPrincipal.MensagemErroJanelaLogin("Email ou Senha Incorretos, Tente Novamente!")
                self.JanelaPrincipal.limpaCampo()

    def Cadastrar(self):

        inf = self.model.consultarEmail(self.JanelaPrincipal.TxtEmailTP.text())
        print(inf)

        if self.JanelaPrincipal.TxtNomeTP.text() == "" or self.JanelaPrincipal.TxtEmailTP.text() == "" or self.JanelaPrincipal.TxtSenhaTP.text() == "" or self.JanelaPrincipal.Txt2SenhaTP.text() == "":
            self.JanelaPrincipal.MensagemErroJanelaPrincipal("Todos os Campos Precisam estar Preenchidos")
            self.JanelaPrincipal.limpaCampo()

        elif len(inf) == 1:
            if inf[0][0] == self.JanelaPrincipal.TxtEmailTP.text():
                self.JanelaPrincipal.MensagemErroJanelaPrincipal("Email já Cadastrado no Banco!")

        else:
            if self.JanelaPrincipal.TxtSenhaTP.text() == self.JanelaPrincipal.Txt2SenhaTP.text(): 
                self.model.Cadastrar(self.JanelaPrincipal.TxtNomeTP.text(), self.JanelaPrincipal.TxtEmailTP.text(), self.JanelaPrincipal.TxtSenhaTP.text())
                self.JanelaPrincipal.MensagemSucessoJanelaPrincipal("Cadastro Realizado com Sucesso!")
                self.JanelaPrincipal.limpaCampo()
            else: 
                self.JanelaPrincipal.MensagemErroJanelaPrincipal("As Senhas Não Estão Iguais")
                self.JanelaPrincipal.limpaCampo()

    def Remover(self):
        if self.JanelaPrincipal.TxtEmailTP.text() == "":
            self.JanelaPrincipal.MensagemErroJanelaPrincipal("Os Campos Precisam Estar Preenchidos!")
            self.JanelaPrincipal.limpaCampo()
        else:
            self.model.Remover(self.JanelaPrincipal.TxtEmailTP.text())
            self.JanelaPrincipal.MensagemSucessoJanelaPrincipal("Remoção Realizada com Sucesso!")
            self.JanelaPrincipal.limpaCampo()

# Colocar um Verificador se As informações adicionadas são as mesmas das anteriores

    def Editar(self):
        if self.JanelaPrincipal.TxtEmailTP.text()== "" or self.JanelaPrincipal.TxtSenhaTP.text() == "" or self.JanelaPrincipal.TxtNomeTP.text() == "":
            self.JanelaPrincipal.MensagemErroJanelaPrincipal("Os Campos Precisam Estar Preenchidos!")
            self.JanelaPrincipal.limpaCampo()
        else:
            inf = self.buscarInformacaoUsuario()
            print(inf)

            if inf[0][0] == self.JanelaPrincipal.TxtNomeTP.text() and inf[0][1] == self.JanelaPrincipal.TxtEmailTP.text() and inf [0][2]== self.JanelaPrincipal.TxtSenhaTP.text():
                self.JanelaPrincipal.MensagemErroJanelaPrincipal("Nenhuma Alteração foi Feita em comparação à do banco")
            else:
                edicao = self.model.Editar(self.JanelaPrincipal.Opcoes.currentData(), self.JanelaPrincipal.TxtEmailTP.text(), self.JanelaPrincipal.TxtSenhaTP.text(), self.JanelaPrincipal.TxtNomeTP.text())

                if edicao == True:
                    self.JanelaPrincipal.MensagemSucessoJanelaPrincipal("Usuário Editado com Sucesso!")
                    self.JanelaPrincipal.Opcoes.setCurrentIndex(0)
                else:
                    self.JanelaPrincipal.MensagemErroJanelaPrincipal("Usuário não Encontrado no Banco")

    def Listar(self):
        # Separar usuários por Parágrafos
        lista = str(self.model.Listar())
        self.JanelaPrincipal.TxtListar.setText(lista)
        self.JanelaPrincipal.TxtListar.setReadOnly(True)