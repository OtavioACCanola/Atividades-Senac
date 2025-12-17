import csv, uuid

# # =-=-=-= LEITURA DE TEXTO =-=-=-=
# # ---- Leitor por Linha (Com os Colchetes) ----
# # with open("Poema.txt", 'r') as arquivo:
# #     leitor = csv.reader(arquivo)
# #     for linha in leitor:
# #         print(linha)

# # # ---- Leitor Direto (Sem os Colchetes) ----
# # with open("Poema.txt", "r") as arquivo:
# #     conteudo = arquivo.read()
# #     print(conteudo)
# # 
# # # =-=-=-= ESCRITOR DE TEXTOS =-=-=-=

# # ---- Escritor que se Sobrepõe ao Conteúdo já Escrito do Arquivo ----
# # with open("Textos.txt", "w") as arquivo_texto:
# #     escritor = arquivo_texto.write("Olá Mundo! Isso é um teste, sou o texto que se sobrepõe ao texto antigo")

# # ---- Escritor que Adiciona Textos no Arquivo Escrito ----
# # with open("Textos.txt", "a") as arquivo_textoadd:
# #     escritor = arquivo_textoadd.write("\n\nOlá eu sou o texto novo da função de adicionar texto!")

# # =-=-=-= LEITOR DE CSV =-=-=-=
# # with open ('dados.csv', 'r') as arquivo:
# #     leitor = csv.reader(arquivo)
# #     for linha in leitor:
# #         print(linha)

# # =-=-=-= ESCRITOR DE CSV =-=-=-=
# # dados = [
# #     ["Nome","Idade","Cidade"]
# #     ["Ana", 22, "São Paulo"]
# #     ["Carlos", 30, "Rio de Janeiro"]
# # ]
# # with open('dados.csv', 'w', newline='') as arquivo:
# #     escritor = csv.writer(arquivo)
# #     escritor.writerows(dados)

# # =-=-=-= ATIVIDADES PROGRAMAS =-=-=-=

# # Métodos:

# # Método Sobreescrever:
# def escreverTextoSemSobreescrever():
#     texto = input("\n\nDigite um Texto que goste: " )
#     with open("Textos.txt", "a") as arquivo_textoadd:
#         escritor = arquivo_textoadd.write(texto)

# # Método Mostrar Texto
# def mostrarTexto():
#     with open("Textos.txt", "r") as arquivo_textoler:
#         conteudo = arquivo_textoler.read()
#         print(f"\n\nSeus textos: {conteudo}")

# # Método Mostrar Poema
# def leitorPoema():
#     with open("Poema.txt", "r") as arquivo:
#         conteudo = arquivo.read()
#         print(conteudo)

# # Método Escrever Arquivo Excel
# def escreverExcel():
#     dados = [
#         ["Nome","Idade","Nota"]
#         ["Ana", 22, "São Paulo"]
#         ["Carlos", 30, "Rio de Janeiro"]
#     ]
#     with open('Alunos.csv', 'w', newline='') as arquivo:
#         escritor = csv.writer(arquivo)
#         escritor.writerows(dados)

# # Método Ler Arquivo Planilha
# def lerExcel():
#     with open("Alunos.csv", "r") as leitor_planilha:
#         leitor = csv.reader(leitor_planilha)
#         for linha in leitor:
#             print(linha)



# =-=-=-=-= ATIVIDADES =-=-=-=-=

# # ===== Ler Poema =====
# print("=-=-=-=-= LEITOR DO ARQUIVO POEMA =-=-=-=-=\n")

# with open("Poema.txt", "r") as arquivo:
#         conteudo = arquivo.read()
#         print(f"Seu Poema: {conteudo} ")

# # ===== Escrever e Mostrar suas Citações Favoritas ===== 

# # ---- Escrever: ----
# print("=-=-=-=-= ESCREVER TEXTOS E VISUAlIZAR =-=-=-=-=\n")
# texto = input("Digite um Texto que goste: \n" )
# with open("Citações.txt", "a") as arquivo_textoadd:
#     escritor = arquivo_textoadd.write(f"\n\n{texto}")

# # ---- Mostrar: ----
# with open("Citações.txt", "r") as arquivo_textoler:
#     conteudo = arquivo_textoler.read()
#     print(f"\n---- Seus textos ---- \n\n{conteudo}")

# # ===== Ler Arquivo CSV ======

# # ---- Escrever: ----
# Escrever o nome do aluno, idade e nota dela, com o cabeçalho desses componentes

print("=-=-=-=-= ESCREVER E VISUALIZAR ARQUIVOS CSV =-=-=-=-=")
NomeAluno = input("Escreva o Nome do Aluno: ")
IdadeAluno = input("Digire a Idade do Aluno: ")
notaAluno = input("Digite a Nota do Aluno: ")

dados = [
    ["Nome","Idade","Nota"],
    [f"{NomeAluno}", f"{IdadeAluno}", f"{notaAluno}"]    
]

with open('Atividades Python POO\Alunos.csv', 'a', newline='') as arquivo:
    escritor = csv.writer(arquivo)
    escritor.writerows(dados)

# # ---- Mostrar: ----

# with open ('Alunos.csv', 'r') as arquivo:
#     leitor = csv.reader(arquivo)
#     for linha in leitor:
#         print(linha)