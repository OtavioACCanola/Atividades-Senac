# Bibliotecas Requests e Sys
import requests, sys
from PyQt5.QtWidgets import  QApplication, QLabel, QLineEdit, QMessageBox, QPushButton, QWidget 

# Função para validar Limpar os Campos
def LimpaCampos():
    # Colocando os objetos de retorno nas caixas de Texto
    TxtCEP.clear()
    TxtRua.clear()
    TxtBairro.clear()
    TxtCidade.clear()
    TxtUF.clear()
    TxtCEP.setFocus()

# Funcão para Validar os Campos de CEP
def ValidaCampo():
    # Vincular o Objeto de Tela a Variável
    codigoCEP = TxtCEP.text().replace("-","")
    Nome = TxtNome.text()
    # Fazer Validação de Preenchimento do CEP
    if codigoCEP == "" and Nome == "":
        QMessageBox.critical(TelaCadastro, "Atenção", "CEP ou Nome precisa ser informado, verifique!")
        TxtCEP.setFocus()

    else:
        # Chamar a Rotina de Verificação do CEP
        TratarCEP(codigoCEP)

def TratarCEP(codigoCEP): # Estrutura Base Implementar API
    # URL da API
    url = f"https://viacep.com.br/ws/{codigoCEP}/json/"

    try:
        # Fazendo a Requisição GET
        response = requests.get(url)

        # Verificando o Resultado
        if response.status_code == 200:
            dados = response.json()

            # Verifica se a Chave "Erro" Existe e se o Valor é "True"
            if dados.get("erro") == "true":
                QMessageBox.critical(TelaCadastro, "Deu ruim", "CEP não Encontrado na Base de Dados do VIACEP")
            else:
                # Colocando os Objetos de Retorno nas Caixas de Texto
                TxtRua.setText(dados.get('logradouro', ''))
                TxtBairro.setText(dados.get('bairro', ''))
                TxtCidade.setText(dados.get('localidade', ''))
                TxtUF.setText(dados.get('uf', ''))

                QMessageBox.information(TelaCadastro, "Consulta do CEP", "Endereço Encontrado, parabens amiguinho!")
        else:
            QMessageBox.critical(TelaCadastro, "Deu Ruim", f"Erro na Requisição. Código de Status: {response.status_code}")
    except Exception as e:
        QMessageBox.critical(TelaCadastro, "Erro", f"Ocorreu uma Exeção: {str(e)}")

# Criando a Aplicação
app = QApplication(sys.argv)

# Janela
TelaCadastro = QWidget()
TelaCadastro.setWindowTitle("Verificação de CEP com API")
TelaCadastro.setGeometry(100, 100, 600, 200)
# TelaCadastro.setWindowIcon(QIcon("g:\Meu DriveSenacDesenvolvimento de Sistemas\UC06 - Materiais\cep.png"))

# Criando um Rótulo (Label)
# Nome:
LblNome = QLabel("Nome: ", TelaCadastro)
LblNome.move(10, 10)

# CEP:
LblCEP = QLabel("CEP: ", TelaCadastro)
LblCEP.move(10, 55)

# Unidade Federativa (UF):
LblUF = QLabel("Estado: ", TelaCadastro)
LblUF.move(530, 150)

# Cidade:
LblCidade = QLabel("Cidade: ", TelaCadastro)
LblCidade.move(10, 150)

# Bairro:
LblBairro = QLabel("Bairro: ", TelaCadastro)
LblBairro.move(270, 150)

# Rua:
LblRua = QLabel("Rua: ", TelaCadastro)
LblRua.move(10, 100)

# Criando uma Caixa de Texto
# Nome:
TxtNome = QLineEdit(TelaCadastro)
TxtNome.setFixedWidth(50)
TxtNome.move(10, 25)

# CEP:
TxtCEP = QLineEdit(TelaCadastro)
# Tamanho da Caixa de Texto na Tela:
TxtCEP.setFixedWidth(80)
# Colocando uma Máscara de CEP no QLineEdit (Como se fosse um molde de como terá que ser digitado na tela)
TxtCEP.setInputMask("00000-000") # Máscara / Modelo de CEP
TxtCEP.move(10, 75)

# Unidade Federativa (UF):
TxtUF = QLineEdit(TelaCadastro)
TxtUF.setFixedWidth(30)
TxtUF.move(530, 170)
TxtUF.setEnabled(False) # Deixa essa Caixa de Texto Imutável, ou seja, Não tem como Escrever nela

# Cidade:
TxtCidade = QLineEdit(TelaCadastro)
TxtCidade.setFixedWidth(250)
TxtCidade.move(10,170)
TxtCidade.setEnabled(False) # Deixa essa Caixa de Texto Imutável, ou seja, Não tem como Escrever nela

# Bairro:
TxtBairro = QLineEdit(TelaCadastro)
TxtBairro.move(270,170)
TxtBairro.setEnabled(False) # Deixa essa Caixa de Texto Imutável, ou seja, Não tem como Escrever nela

# Rua:
TxtRua = QLineEdit(TelaCadastro)
TxtRua.setFixedWidth(260)
TxtRua.move(10,120)
TxtRua.setEnabled(False) # Deixa essa Caixa de Texto Imutável, ou seja, Não tem como Escrever nela

# Criando o Botão de Busca do CEP
BtnBuscarCEP = QPushButton("Buscar CEP", TelaCadastro)
BtnBuscarCEP.move(100, 40)

# Conectando o Clique do Botão à Função
BtnBuscarCEP.clicked.connect(ValidaCampo)

# Criando o Botão de Limpar
BtnLimpar = QPushButton("Limpar Tela", TelaCadastro)
BtnLimpar.move(185, 40)

# Conectando o Clique do Botão à Função
BtnLimpar.clicked.connect(LimpaCampos)

# Exibindo a Janela
TelaCadastro.show()

# Iniciando o Loop de Eventos
sys.exit(app.exec_())


