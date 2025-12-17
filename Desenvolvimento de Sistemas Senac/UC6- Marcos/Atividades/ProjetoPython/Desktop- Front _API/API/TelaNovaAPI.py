# =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=Tarefas =-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=
"Criar Métodos: OK"
"Criar Tela: OK"
"Criar Labels e LineEdits: OK"
"Posicionar Labels e LineEdits: OK"
"Traduzir Textos: OK"
"Corrigir o ID e a Palavra-Chave: OK"
"Testar: OK"



# Bibliotecas Requests e Sys
import requests, sys, asyncio
from PyQt5.QtWidgets import  QApplication, QLabel, QLineEdit, QMessageBox,    QPushButton, QWidget 
from deep_translator import GoogleTranslator

# =-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=--= Métodos =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

def LimpaCampos(): # Limpa os Campos

    if TxtConselhoBusca.text() == "" and TxtConselhoID.text() == "":
        QMessageBox.information(TelaConselho, "Atenção", "Não tem Nada para Apagarmos")

    else:
        # Colocando os objetos de retorno nas caixas de Texto
        TxtConselhoBusca.clear()
        TxtNome.clear()
        TxtConselhoAleatorio.clear()
        TxtConselhoID.clear()

# Funcão para Validar os Campos de Conselhos

# == Métodos Tradução ==
def TraducaoAleatorio():
    tradutor = GoogleTranslator(source="en", target="pt")
    texto = TxtConselhoAleatorio.text()
    traducao = tradutor.translate(texto)
    TxtConselhoAleatorio.setText(traducao)

    return QMessageBox.information(TelaConselho, "Conselho", f"{TxtNome.text()}, seu conselho: {TxtConselhoAleatorio.text()}")

def TraducaoBusca():
    tradutor = GoogleTranslator(source="en", target="pt")
    texto = TxtConselhoBusca.text()
    traducao = tradutor.translate(texto)
    TxtConselhoBusca.setText(traducao)

    QMessageBox.information(TelaConselho, "Conselho", f"{TxtNome.text()}, seu Conselho: {TxtConselhoBusca.text()}")
    LimpaCampos()


def TraducaoID():
    tradutor = GoogleTranslator(source="en", target="pt")
    texto = TxtConselhoID.text()
    traducao = tradutor.translate(texto)
    TxtConselhoID.setText(traducao)

    QMessageBox.information(TelaConselho, "Conselho", f"{TxtNome.text()}, seu Conselho: {TxtConselhoID.text()}")
    LimpaCampos()


# == Métodos Conselho ==

def tratarConselhoAleatorio():
    # URL da API
    url = f"https://api.adviceslip.com/advice"

    if TxtNome.text() == "":
        QMessageBox.information(TelaConselho, "Atenção", "Digite seu Nome")
    
    else:

        try:
            # Fazendo a Requisição GET (Comunicação com a API: Pede os dados ao servidor)
            response = requests.get(url)

            # Verificando o Resultado (Verifica se o código de status HTTP retornado pelo servidor é 200, funcional)
            if response.status_code == 200: 
                # transforma o texto da resposta (que está em formato JSON) em um dicionário Python
                dados = response.json() 

                # Verifica se a Chave "Erro" Existe e se o Valor é "True"
                if dados.get("message"): 
                    QMessageBox.critical(TelaConselho, "Deu ruim", "Não Conseguimos Procurar um Conselho para Você")
                else:
                    # Colocando os Objetos de Retorno nas Caixas de Texto (Acessa o valor da chave 'logradouro' no dicionário dados e usa esse valor para preencher o campo de texto)
                    Id_Conselho = ""
                    Slip_data = dados.get("slip")
                    Id_Conselho == Slip_data.get("id")
                    TxtConselhoAleatorio.setText(Slip_data.get("advice")) 
                    QMessageBox.information(TelaConselho, "Busca do Conselho", f"ID: {TraducaoAleatorio()} {Id_Conselho}")
            else:
                QMessageBox.critical(TelaConselho, "Erro", f"Erro na Requisição. Código de Status: {response.status_code}")
        except Exception as e:
            QMessageBox.critical(TelaConselho, "Erro", f"Ocorreu uma Exeção: {str(e)}")

def tratarConselhoBusca():
    # URL da API

    url = f"https://api.adviceslip.com/advice/search/{TxtConselhoBusca.text()}"

    if TxtConselhoBusca.text() == "" and TxtNome.text() == "":
        QMessageBox.information(TelaConselho, "Atenção", "Digite seu Nome e Algo para Buscarmos")

    else:
        try:
            response = requests.get(url)

            if response.status_code == 200:
                dados = response.json()
                if dados.get("message"): 
                    QMessageBox.critical(TelaConselho, "Deu ruim", "Não Conseguimos Procurar um Conselho para Você")
                else:
                    Slip_data = dados.get("slips") # Lista do slips
                    ConselhoBusca = Slip_data[0] # Dicionario do slips
                    TxtConselhoBusca.setText(ConselhoBusca.get("advice"))

                    TraducaoBusca()
            else:
                QMessageBox.critical(TelaConselho, "Erro", f"Erro na Requisição. Código de Status: {response.status_code}")
        except Exception as e:
            QMessageBox.critical(TelaConselho, "Erro", f"Ocorreu uma Exeção: {str(e)}")

def tratarConselhoID():

    url = f"https://api.adviceslip.com/advice/{TxtConselhoID.text()}"

    if TxtConselhoID.text() == "" and TxtNome.text() == "":
        QMessageBox.information(TelaConselho, "Atenção", "Digite seu Nome e Algo para Buscarmos")

    else:
        try:
            response = requests.get(url)

            if response.status_code == 200:
                dados = response.json()
                if dados.get("message"):
                    QMessageBox.critical(TelaConselho, "Atenção", "Não Conseguimos Procurar um Conselho no site")
            
                else:
                    slip_data = dados.get("slip")
                    TxtConselhoID.setText(slip_data.get("advice"))
                    TraducaoID()
            else:
                QMessageBox.critical(TelaConselho, "Atenção", f"Erro na requisição. Código de Status: {response.status_code}")
        except Exception as e:
            QMessageBox.critical(TelaConselho, "Erro", f"Ocorreu uma Exeção: {e}")        

# =-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=--= Telas =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

# Criando a Aplicação
app = QApplication(sys.argv)

# Janela Conselho:
TelaConselho = QWidget()
TelaConselho.setWindowTitle("Conselhos por API")
TelaConselho.setGeometry(300, 300, 300, 150)
# TelaCadastro.setWindowIcon(QIcon("g:\Meu DriveSenacDesenvolvimento de Sistemas\UC06 - Materiais\cep.png"))

# =-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=--= Labels =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

LblTitulo = QLabel("Conselhos", TelaConselho)
LblTitulo.move(110, 10)

LblNome = QLabel("Nome: ", TelaConselho)
LblNome.move(8, 35)

LblConselhoID = QLabel("Busque por ID: ", TelaConselho)
LblConselhoID.move(8, 60)

LblConselhoBusca = QLabel("Busque por Palavra Chave: ", TelaConselho)
LblConselhoBusca.move(8,80)

# =-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-= Line Edit =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

TxtConselhoID = QLineEdit(TelaConselho)
TxtConselhoID.setFixedWidth(50)
TxtConselhoID.setFixedHeight(15)
TxtConselhoID.move(90, 60)

TxtConselhoBusca = QLineEdit(TelaConselho)
TxtConselhoBusca.setFixedWidth(50)
TxtConselhoBusca.setFixedHeight(15)
TxtConselhoBusca.move(145, 80)

TxtConselhoAleatorio = QLineEdit(TelaConselho)
TxtConselhoAleatorio.setVisible(False)

TxtNome = QLineEdit(TelaConselho)
TxtNome.setFixedWidth(40)
TxtNome.setFixedHeight(15)
TxtNome.move(45, 35)

# # =-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=--= Botões =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

BtnConselhoAleatorio = QPushButton("Aleatorio", TelaConselho)
BtnConselhoAleatorio.move(10, 110)
BtnConselhoAleatorio.setFixedWidth(55)

BtnConselhoBusca = QPushButton("Palavra-Chave", TelaConselho)
BtnConselhoBusca.move(70, 110)
BtnConselhoBusca.setFixedWidth(85)

BtnConselhoID = QPushButton("ID", TelaConselho)
BtnConselhoID.move(160, 110)
BtnConselhoID.setFixedWidth(45)

BtnLimpar = QPushButton("Limpar", TelaConselho)
BtnLimpar.move(210, 110)
BtnLimpar.setFixedWidth(45)

# Conectando o Clique do Botão à Função
BtnConselhoAleatorio.clicked.connect(tratarConselhoAleatorio)
BtnConselhoBusca.clicked.connect(tratarConselhoBusca)
BtnConselhoID.clicked.connect(tratarConselhoID)
BtnLimpar.clicked.connect(LimpaCampos)

# =-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=--= Exibição =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

TelaConselho.show()

# Iniciando o Loop de Eventos
sys.exit(app.exec_())




