import sys, requests
from PyQt5.QtWidgets import QApplication, QPushButton, QLabel, QWidget, QLineEdit, QMessageBox
from PyQt5.QtGui import QFont

Informacoes_Geral = ""

# Criação Aplicação
app = QApplication(sys.argv)

# Criando Métodos
def Limpar():
    if TNome_Completo.text() == "":
        QMessageBox.information(None, "Atenção", "Os campos já estão vazios!!")
    else: 
        TNome_Completo.clear()
        TData_Nascimento.clear()
        TNome_Mae.clear()
        TRG.clear()
        TCEP.clear()
        TCPF.clear()
        TNome_Completo.setFocus()

def Informacoes_CEP(TCEP):
    global Informacoes_Geral 

    Cep = TCEP.text()
    url = f"https://viacep.com.br/ws/{Cep}/json/"

    # Fazendo a Requisição GET
    try:    
        Informacoes = ""
        response = requests.get(url)
        # Verificando o Resultado
        if response.status_code == 200:
            dados = response.json()
            # Verifica se a Chave "Erro" Existe e se o Valor é "True"

            if dados.get("erro") == "true":
                QMessageBox.critical(window, "Informação CEP", "Erro: CEP não Encontrado")
            else:
                #Pegar Informações Campos ViaCep
                icep = dados.get('cep', '')
                irua = dados.get('logradouro', '')
                ibairro = dados.get('bairro', '')
                icidade = dados.get('localidade', '')
                iestado = dados.get('uf','')

                # Texto Para mostrar na Tela
                Informacoes += (f"CEP: {icep}\nRua: {irua}\nBairro: {ibairro}\nCidade: {icidade}\nEstado: {iestado}")
                Informacoes_Geral = Informacoes
                QMessageBox.information(window, "Informação CEP!", "CEP Encontrado!")
        
        else:
            QMessageBox.critical(window, "Informação CEP", f"Erro na Requisição. Código de Status: {response.status_code}")

    except Exception as e:
        QMessageBox.critical(window, "Atenção", f"Erro de conexão! {str(e)}")
 
    
def Cadastrar():
    if(TNome_Completo.text() == "" or TCPF.text() == "" or TCEP.text() == "" or TData_Nascimento.text() == "" or TNome_Mae.text() == "" or TRG.text() == ""):
        QMessageBox.information(None, "Atenção", "Todos os Campos Precisam Estar Devidamente Preenchidos!")
        TNome_Completo.clear()
        TNome_Mae.clear()
        TData_Nascimento.clear()
        TCEP.clear()
        TRG.clear()
        TCPF.clear()
        TNome_Completo.setFocus()
    elif(len(TCPF.text()) != 14 or len(TRG.text()) != 12 or len(TData_Nascimento.text()) != 10):
        QMessageBox.information(window, "Atemção!", "Os caracteres de cada campo precisam estar devidamente preenchidos")
    elif(TNome_Completo.text() != "" and TCEP.text() != "" and TCPF.text() != "" and TData_Nascimento.text() != "" and TNome_Mae.text() != "" and TRG.text() != ""):
        Lista_de_Usuario=[]
        Usuario = {"Nome Completo:": TNome_Completo.text(), "CPF:": TCPF.text(), "CEP:": Informacoes_CEP(TCEP), "Data de Nascimento:": TData_Nascimento.text(), "Nome da Mãe:": TNome_Mae.text(), "RG:": TRG.text()}
        Lista_de_Usuario.append(Usuario)
        Mensagem = "Nome: "+TNome_Completo.text()+"\nCPF: "+TCPF.text()+"\nData_Nascimento: "+TData_Nascimento.text()+"\nNome da Mãe: "+TNome_Mae.text()+"\n"+Informacoes_Geral
        QMessageBox.information(window, "Sucesso", f"Cadastro Executado, seja bem vindo, {TNome_Completo.text()}!")
        QMessageBox.information(window, "Sua Lista", Mensagem)
    else:
        QMessageBox.information(window, "Atenção!", "Todos os campos precisam ser preenchidos!")

# Criação Janela
window = QWidget()
window.setWindowTitle('Cadastro')
window.setGeometry(750,350, 400, 250)

# Criando Rótulos (Labels)
Nome = QLabel
Negrito = QFont()
Negrito.setBold(True)

Nome_Completo = QLabel("Nome Completo: ", window)
Nome_Completo.move(40,60)
Nome_Completo.setFont(Negrito)

CPF = QLabel("CPF: ", window)
CPF.move(40,80)
CPF.setFont(Negrito)

CEP = QLabel("Endereco: ", window)
CEP.move(40, 100)
CEP.setFont(Negrito)

Data_Nascimento = QLabel("Data de Nascimento: ", window)
Data_Nascimento.move(40,120)
Data_Nascimento.setFont(Negrito)

Nome_Mae= QLabel("Nome da Mãe: ", window)
Nome_Mae.move(40,140)
Nome_Mae.setFont(Negrito)

RG= QLabel("RG: ", window)
RG.move(40,160)
RG.setFont(Negrito)

# Criando Caixas de Texto
TNome_Completo = QLineEdit(window)
TNome_Completo.move(180,60)

TCPF = QLineEdit(window)
#TCPF.setEchoMode(QLineEdit.Password)
TCPF.setInputMask("000.000.000-00")
TCPF.move(180,80)

TCEP = QLineEdit(window)
TCEP.move(180,100)

TData_Nascimento= QLineEdit(window)
TData_Nascimento.move(180,120)
TData_Nascimento.setInputMask("00/00/0000")

TNome_Mae= QLineEdit(window)
TNome_Mae.move(180,140)

TRG= QLineEdit(window)
TRG.setInputMask("00.000.000-0")
TRG.move(180, 160)

url = f"https://viacep.com.br/ws/{TCEP}/json"
# Criando Botões
BtnCadastrar = QPushButton("Cadastrar", window)
BtnCadastrar.move(90,210)

BtnLimpar = QPushButton("Limpar", window)
BtnLimpar.move(200, 210)

# Criando o Clique do botão à função
BtnCadastrar.clicked.connect(Cadastrar)
BtnLimpar.clicked.connect(Limpar)

# Rodando a Janela
window.show()

# Inicioando o Loop de Eventos
sys.exit(app.exec())

