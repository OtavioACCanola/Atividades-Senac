# Cadastrar Candidatos antes da Urna Eletrônica Começar: OK
# Colocar Senha para Entrar na Urna: OK
# Mostrar os Números dos Candidatos para Vorar (Botão com o número) e Opção de Voto em Branco: Ok
# Após Votar mostrar que a urna encerrou o processo de votação ou retormar para a tela de votação, ambas pela senha: Ok
# Mostrar porcentagem dos candidatos individualmente, todos os votos acumulados e dos votos nulos e brancos no final quando encerrar
# Mostrar quem é o Eleito

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

    def mostrar_Numero(self):
        print(f"Nome Candidato: {self.nome}\nNumero Candidato: {self.numero}")

    def criar_Candidato(nome, idade, cpf, rg, nacionalidade, cor, numero):
        if (nome == "" or idade == "" or cpf == "" or rg == "" or nacionalidade == "" or cor == "" or numero == ""):
            print("Não é permitido deixar informações em branco")
        else:
            candidato = Candidato(nome, idade, cpf, rg, nacionalidade, cor, numero)
            print("\n=-=-=-=-=-=-= Candidato Cadastrado! =-=-=-=-=-=-=\n")
            lista_Candidatos.append(candidato)

# ========================================= URNA ==========================================================================

def senhaInicioUrna():
    while True:
        try:
            senha = input("Digite a Senha para Acessar a Urna: ")
            senha = int(senha)
            if (senha == 123):
                print("Você entrou na Urna\n")
                break
            else:
                print("Senha Incorreta, tente novamente\n")
                continue
        except ValueError:
            print(f"A Senha deve ser Numérica\n")

def mostrarVotos(self):
    return print(f"Nome: {candidato1.nome} | Votos: {votoCand1}\nNome: {candidato2.nome} | Votos: {votoCand2}")

def ValidaVoto():
    global totalVotos, votoCand1, votoCand2, votoCand3, votoBranco, votoNulo
    while True: 
    
       voto = input("\nDigite seu Voto: ")

       if voto == 0:
           senha = ("Digite a Senha da Urna para Sair: ")
           if senha == "123":
              print("\nVocê saiu da Votação!")
              break
           elif senha != "123":
              print("Senha Incorreta")
       else:
            try:
               if voto == "26":
                totalVotos += 1
                votoCand1 += 1
                print(f"Você votou no candidato, {candidato1.nome}\n")
                pergunta = input("Deseja Votar Novamente?: ")
                if pergunta.lower() == "sim":
                    senhaV = input("Digite a snha da Urna para Continuar: ")
                    if senhaV == "123":
                        continue
                    else:
                        senhaV = input("Digite a snha da Urna para parar: ")
                    if senhaV == "123":
                        print("\nVocê saiu da Votação!")
                        break
                    else:
                        print("Senha Incorreta!")
                        continue
                elif pergunta.lower() == "não":
                    senhaV = input("Digite a snha da Urna para Parar: ")
                    if senhaV == "123":
                        print("\nVocê saiu da Votação!")
                        break
                    else:
                        print("Senha Incorreta!")
                        continue
               elif voto == "21":
                totalVotos += 1
                votoCand2 += 1
                print(f"Você votou na candidata, {candidato2.nome}\n")
                pergunta = input("Deseja Votar Novamente?: ")
                if pergunta.lower() == "sim":
                    senhaV = input("Digite a snha da Urna para Continuar: ")
                    if senhaV == "123":
                        continue
                    else:
                        senhaV = input("Digite a snha da Urna para parar: ")
                    if senhaV == "123":
                        print("\nVocê saiu da Votação!")
                        break
                    else:
                        print("Senha Incorreta!")
                        continue
                elif pergunta.lower() == "não":
                    senhaV = input("Digite a snha da Urna para Parar: ")
                    if senhaV == "123":
                        print("\nVocê saiu da Votação!")
                        break
                    else:
                        print("Senha Incorreta!")
                        continue
               elif voto == "40":
                totalVotos += 1
                votoCand3 += 1
                print(f"Você votou no candidato, {candidato3.nome}\n")
                pergunta = input("Deseja Votar Novamente?: ")
                if pergunta.lower() == "sim":
                    senhaV = input("Digite a snha da Urna para Continuar: ")
                    if senhaV == "123":
                        continue
                    else:
                        print("Senha Incorreta!")
                        break
                elif pergunta.lower() == "não":
                    senhaV = input("Digite a snha da Urna para Parar: ")
                    if senhaV == "123":
                        print("\nVocê saiu da Votação!")
                        break
                    else:
                        print("Senha Incorreta!")
                        continue
               elif voto == "99":
                print("Você votou em Branco\n")
                totalVotos += 1
                votoBranco += 1
                pergunta = input("Deseja Votar Novamente?: ")
                if pergunta.lower() == "sim":
                    senhaV = input("Digite a snha da Urna para Continuar: ")
                    if senhaV == "123":
                        continue
                    else:
                        print("Senha Incorreta!")
                        break
                elif pergunta.lower() == "não" or "nao":
                    senhaV = input("Digite a snha da Urna para Parar: ")
                    if senhaV == "123":
                        print("\nVocê saiu da Votação!")
                        break
                    else:
                        print("Senha Incorreta!")
                        continue

               elif voto == "0":
                senhaV = input("Você quer Sair da Votação, digite a senha da urna para sair: ")
                if senhaV == "123":
                    print("\nVocê saiu da Votação!")
                    break
                else:
                    print("Senha Incorreta!")
                    continue
               else:
                print("Você votou Nulo\n")
                totalVotos += 1
                votoNulo += 1
                pergunta = input("Deseja Votar Novamente?: \n")
                if pergunta.lower() == "sim":
                    senhaV = input("Digite a snha da Urna para Continuar: ")
                    if senhaV == "123":
                        continue
                    else:
                        print("Senha Incorreta!")
                        break
                elif pergunta.lower() == "não":
                    senhaV = input("Digite a snha da Urna para Parar: ")
                    if senhaV == "123":
                        print("\nVocê saiu da Votação!")
                        break
                    else:
                        print("Senha Incorreta!")
                        continue
            except ValueError:
             print("O voto tem que ser numérico!")

def apuracao():
    porcentagemCand1 = (votoCand1 / totalVotos) * 100
    porcentagemCand2 = (votoCand2 / totalVotos) * 100
    porcentagemCand3 = (votoCand3 / totalVotos) * 100
    porcentagemBranco = (votoBranco / totalVotos) * 100
    porcentagemNulo = (votoNulo / totalVotos) * 100
    print(f"O total de Votos é de: {totalVotos}")
    print(f"Porcentagem Votos Candidato {candidato1.nome}: {porcentagemCand1}")
    print(f"Porcentagem Votos Candidato {candidato2.nome}: {porcentagemCand2}")
    print(f"Porcentagem Votos Candidato {candidato3.nome}: {porcentagemCand3}")
    print(f"Porcentagem Votos em Branco: {porcentagemBranco}")
    print(f"Porcentagem Votos Nulos: {porcentagemNulo}")

    print(f"Ganhador: ")
    if porcentagemCand1 > porcentagemCand2 and porcentagemCand1 > porcentagemCand3 and porcentagemCand1 > porcentagemBranco and porcentagemCand1 > porcentagemNulo:
        print(f"O Candidato {candidato1.nome} ganhou!")
    elif porcentagemCand2 > porcentagemCand1 and porcentagemCand2 > porcentagemCand3 and porcentagemCand2 > porcentagemBranco and porcentagemCand2 > porcentagemNulo:
        print(f"O Candidato {candidato2.nome} ganhou!")
    elif porcentagemCand3 > porcentagemCand1 and porcentagemCand3 > porcentagemCand2 and porcentagemCand3 > porcentagemBranco and porcentagemCand3 > porcentagemNulo:
        print(f"O Candidato {candidato3.nome} ganhou!")

# ======================================= CODIGOS ========================================================================
print("==================================================================================================================")
print("                                    CADASTRO CANDIDATOS                                                           ")
print("==================================================================================================================\n")

candidato1 = Candidato("Roger", "34", "914.686.810-01", "44.169.198-5", "Brasileiro", "Pardo", "26")
candidato2 = Candidato("Fernanda", "29", "805.335.180-83", "41.098.683-5", "Brasileira", "Preta", "21")
candidato3 = Candidato("Lucas", "30", "717.386.860-27", "35.695.582-5", "Brasileiro", "Branco", "40")
print("Cadastro Concluído!")


print("\n==================================================================================================================")
print("                                    URNA ELETRÔNICA                                                          ")
print("==================================================================================================================\n")

# Urna Inicio
senhaInicioUrna()

# Mostra Números Candidatos e Opções de Voto

print("==== Números dos Votos ====")
print("\nPara Votar, Digite o Número Correspondente a Opção: ")
print(f"1º Candidato: {candidato1.nome} | Número: {candidato1.numero}")
print(f"2º Candidato: {candidato2.nome} | Número: {candidato2.numero}")
print(f"3º Candidato: {candidato3.nome} | Número: {candidato3.numero}")
print("4º Voto em Branco | Número: 99")
print("5º Voto Nulo | Qualquer Número Diferente")
print("6º Sair | 0")

ValidaVoto()
apuracao()

    






