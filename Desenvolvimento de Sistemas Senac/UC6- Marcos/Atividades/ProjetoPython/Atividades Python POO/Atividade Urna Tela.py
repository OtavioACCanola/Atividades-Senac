# Cadastrar Candidatos antes da Urna Eletrônica Começar: OK
# Colocar Senha para Entrar na Urna: OK
# Mostrar os Números dos Candidatos para Vorar (Botão com o número) e Opção de Voto em Branco: Ok
# Após Votar mostrar que a urna encerrou o processo de votação ou retormar para a tela de votação, ambas pela senha: Ok
# Mostrar porcentagem dos candidatos individualmente, todos os votos acumulados e dos votos nulos e brancos no final quando encerrar: Ok
# Mostrar quem é o Eleito: Ok

# =-=-=-=-= IMPORTAÇÕES =-=-=-=-=
import sys
from PyQt5 import QtWidgets, uic
from PyQt5.QtWidgets import QMessageBox, QInputDialog
app = QtWidgets.QApplication([])
TelaSUrna = uic.loadUi("Atividades Python POO/TelaSenhaUrna.ui")
TelaVot = uic.loadUi("Atividades Python POO/TelaVotacao.ui")
TelaSairUrna = uic.loadUi("Atividades Python POO/TelaSenhaSairUrna.ui")

# =-=-=-=-= MÉTODOS E CLASSES =-=-=-=-=

lista_Candidatos = []
totalVotos = 0
votoCand1 = 0
votoCand2 = 0
votoCand3 = 0
votoBranco = 0
votoNulo = 0
class Candidato:

# =========================================== CANDIDATO ==================================================================
    def __init__(self, nome, idade, cpf, rg, nacionalidade, cor, numero):
        self.nome = nome
        self.idade = idade
        self.cpf = cpf
        self.rg = rg
        self.nacioladidade = nacionalidade
        self.cor = cor
        self.numero = numero

    def criar_Candidato(nome, idade, cpf, rg, nacionalidade, cor, numero):
        if (nome == "" or idade == "" or cpf == "" or rg == "" or nacionalidade == "" or cor == "" or numero == ""):
            print("Não é permitido deixar informações em branco")
        else:
            candidato = Candidato(nome, idade, cpf, rg, nacionalidade, cor, numero)
            print("\n=-=-=-=-=-=-= Candidato Cadastrado! =-=-=-=-=-=-=\n")
            lista_Candidatos.append(candidato)

# ========================================= URNA ==========================================================================

def senhaInicioUrna():
        TelaSUrna.show()
        try:
            senha = TelaSUrna.TxtSenha.text()
            if not senha:
                QMessageBox.information(TelaSUrna, "Atenção", "Digite a Senha para Continuar!")
                return
            
            senha_int = int(senha)

            if (senha_int == 123):
                QMessageBox.information(TelaSUrna, "Sucesso", "Você entrou na Urna")
                TelaSUrna.TxtSenha.clear()
                TelaSUrna.close()
                mostrarOpcoes()
                TelaVot.show()
                TelaVot.TxtVoto.setEnabled(True)
            else:
                QMessageBox.critical(TelaSUrna, "Erro", "Senha Incorreta, tente novamente")
        except ValueError:
            QMessageBox.critical(TelaSUrna, "Erro", "A Senha deve ser Numérica")
        

def senhaSairUrna():
        TelaVot.hide()
        TelaSairUrna.show()
        try:
            senha = TelaSairUrna.TxtSenhaSair.text()

            if not senha:
                QMessageBox.information(TelaSUrna, "Atenção", "Digite a Senha para Continuar!")
                return
            
            senha = int(senha)

            
            if (senha == 123):
                TelaSairUrna
                QMessageBox.information(TelaVot, "Sucesso", "Você saiu da Urna. A Apuração Será Exibida!")
                TelaSairUrna.TxtSenhaSair.clear()
                TelaSairUrna.close()
                apuracao()
                TelaVot.show()
                TelaVot.TxtVoto.setEnabled(False)
                TelaVot.BtnVotar.setEnabled(False)
                
            else:
                TelaSUrna.TxtSenha.clear()
                QMessageBox.critical(TelaSUrna, "Erro", "Senha Incorreta, tente novamente")
        except ValueError:
            QMessageBox.critical(TelaSUrna, "Erro", "A Senha deve ser Numérica")

def mostrarOpcoes():
    listaItems =  ["==== Números dos Votos ====\n"
    f"1º Candidato: {candidato1.nome} | Número: {candidato1.numero}\n"
    f"2º Candidato: {candidato2.nome} | Número: {candidato2.numero}\n"
    f"3º Candidato: {candidato3.nome} | Número: {candidato3.numero}\n"
    "4º Voto em Branco | Número: 99\n"
    "5º Voto Nulo | Qualquer Número Diferente\n"
    "6º Sair | 0\n"]
    TelaVot.LblNumeroCandidatos.clear()
    TelaVot.LblNumeroCandidatos.addItems(listaItems)

def PerguntaVotoNovo():
    resposta = QMessageBox.question(TelaVot, "Pergunta", "Voto Computador. Deseja Votar Novamente?", QMessageBox.Yes | QMessageBox.No)

    if resposta == QMessageBox.Yes:
        TelaVot.hide()
        TelaSUrna.show()
        TelaVot.TxtVoto.setEnabled(True)
        senhaInicioUrna()
    elif resposta == QMessageBox.No:
        TelaSUrna.BtnEntrar.clicked.connect(senhaSairUrna)
        senhaSairUrna()
        TelaVot.TxtVoto.setEnabled(False)
        
def apagarVoto():
    TelaVot.TxtVoto.clear()
        

def ValidaVoto():
       global totalVotos, votoCand1, votoCand2, votoCand3, votoBranco, votoNulo

       voto = TelaVot.TxtVoto.text()
       if not voto:
           QMessageBox.critical(TelaVot, "Atenção", "Não foi registrado nenhum voto!")

       if voto == "0":
           senhaSairUrna()
       
       try:
            if voto == "26":
                totalVotos += 1
                votoCand1 += 1
                QMessageBox.information(TelaVot, "Voto", f"Você votou no candidato, {candidato1.nome}\n")
                PerguntaVotoNovo()
                apagarVoto()
                 
            elif voto == "21":
                totalVotos += 1
                votoCand2 += 1
                QMessageBox.information(TelaVot, "Voto", f"Você votou na candidata, {candidato2.nome}")
                PerguntaVotoNovo()
                apagarVoto()
                        
            elif voto == "40":
                totalVotos += 1
                votoCand3 += 1
                QMessageBox.information(TelaVot, "Voto", f"Você votou no candidato, {candidato3.nome}\n")
                PerguntaVotoNovo()
                apagarVoto()

            elif voto == "99":
                QMessageBox.information(TelaVot, "Voto", "Você votou em Branco")
                totalVotos += 1
                votoBranco += 1
                PerguntaVotoNovo()
                apagarVoto()

            elif voto == "0":
                senhaSairUrna()

            else:
                print("Você votou Nulo\n")
                totalVotos += 1
                votoNulo += 1
                PerguntaVotoNovo()
                apagarVoto()
       except ValueError:
            print("O voto tem que ser numérico!")

def apuracao():
    TelaVot.LblNumeroCandidatos.clear()
    
    if totalVotos == 0:
        mensagem = ["Nenhuma Votação Resgistrada para Apuração!"]
        TelaVot.LblNumeroCandidatos.addItems(mensagem)
        return
    
    porcentagemCand1 = (votoCand1 / totalVotos) * 100
    porcentagemCand2 = (votoCand2 / totalVotos) * 100
    porcentagemCand3 = (votoCand3 / totalVotos) * 100
    porcentagemBranco = (votoBranco / totalVotos) * 100
    porcentagemNulo = (votoNulo / totalVotos) * 100
    vencedor = None

    
    listaVoto = [
    f"O total de Votos é de: {totalVotos}\n"
    f"Porcentagem Votos Candidato {candidato1.nome}: {porcentagemCand1:.2f}%\n"
    f"Porcentagem Votos Candidato {candidato2.nome}: {porcentagemCand2:.2f}%\n"
    f"Porcentagem Votos Candidato {candidato3.nome}: {porcentagemCand3:.2f}%\n"
    f"Porcentagem Votos em Branco: {porcentagemBranco:.2f}%\n"
    f"Porcentagem Votos Nulos: {porcentagemNulo:.2f}%\n"]
    TelaVot.LblNumeroCandidatos.addItems(listaVoto)

    if porcentagemCand1 > porcentagemCand2 and porcentagemCand1 > porcentagemCand3:
        vencedor = candidato1.nome
        mensagem = [f"O vencedor é: {vencedor}"] 
        TelaVot.LblNumeroCandidatos.addItems(mensagem)
        
    elif porcentagemCand2 > porcentagemCand1 and porcentagemCand2 > porcentagemCand3:
        vencedor = candidato2.nome
        mensagem = [f"O vencedor é: {vencedor}"]
        TelaVot.LblNumeroCandidatos.addItems(mensagem)

    elif porcentagemCand3 > porcentagemCand1 and porcentagemCand3 > porcentagemCand2:
        vencedor = candidato3.nome
        mensagem = [f"O vencedor é: {vencedor}"]
        TelaVot.LblNumeroCandidatos.addItems(mensagem)
    
    elif porcentagemCand1 == porcentagemCand2 or porcentagemCand2 == porcentagemCand1:
        mensagem = [f"Ocorreu um Empate entre o Candidato {candidato1.nome} e a Candidata\n {candidato2.nome}, ambos vão para o 2º Turno."]
        TelaVot.LblNumeroCandidatos.addItems(mensagem)

    
    elif porcentagemCand2 == porcentagemCand3 or porcentagemCand3 == porcentagemCand2:
         mensagem = [f"Ocorreu um Empate entre a Candidata {candidato2.nome} e o Candidato\n {candidato3.nome}, ambos vão para o 2º Turno."]
         TelaVot.LblNumeroCandidatos.addItems(mensagem)


    elif porcentagemCand3 == porcentagemCand1 or porcentagemCand1 == porcentagemCand3:
         mensagem = [f"Ocorreu um Empate entre o Candidato {candidato1.nome} e o Candidato\n {candidato3.nome}, ambos vão para o 2º Turno."]
         TelaVot.LblNumeroCandidatos.addItems(mensagem)

    else:
        mensagem = [f"Não obteve votos válidos na votação!"]
        TelaVot.LblNumeroCandidatos.addItems(mensagem)




# ======================================= CODIGOS ========================================================================
"=================================================================================================================="
"                                    CADASTRO CANDIDATOS                                                           "
"=================================================================================================================="

candidato1 = Candidato("Roger", "34", "914.686.810-01", "44.169.198-5", "Brasileiro", "Pardo", "26")
candidato2 = Candidato("Fernanda", "29", "805.335.180-83", "41.098.683-5", "Brasileira", "Preta", "21")
candidato3 = Candidato("Lucas", "30", "717.386.860-27", "35.695.582-5", "Brasileiro", "Branco", "40")
QMessageBox.information(TelaSUrna, "Cadastro", "Cadastro Concluído!")


("==================================================================================================================")
("                                       TELA                                                                       ")
("==================================================================================================================")

TelaSairUrna.BtnSair.clicked.connect(senhaSairUrna)
TelaSUrna.BtnEntrar.clicked.connect(senhaInicioUrna)
TelaVot.BtnVotar.clicked.connect(ValidaVoto)


# Exibindo a Janela
TelaSUrna.show()

# Iniciando o Loop de Eventos
sys.exit(app.exec_())
