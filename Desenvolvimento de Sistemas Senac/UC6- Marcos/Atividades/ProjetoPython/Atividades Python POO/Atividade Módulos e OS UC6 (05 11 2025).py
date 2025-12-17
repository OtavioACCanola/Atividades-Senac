import MinhaCalculadora as c # Módulo que Importa os Métodos do Arquivo "Minha Calculadora"
import os, requests, sys

# Teste Calculadora:

c.Soma(1,3)
c.Subtração(3,2)
c.Multiplicacao(4,3)
c.Divisao(6,3)

# Módulo os:

print(f"\nSeu diretório é: {os.getcwd()}") # Retorna o Diretório Atual

print(f"\nSeus diretórios da pasta: {os.listdir()}")

os.mkdir("Novo Diretório Teste os UC6 (05 11 2025).py")
print("Novo diretório criado com sucesso!")

if os.path.isdir("Novo Diretório Teste os UC6 (05 11 2025).py"):
    print("\nO Repositório Existe!")
else:
    print("\nO Repositório não Existe!")

# Módulo Externo (requests):
url = "https://api.github.com/"

response = requests.get(url)

if response.status_code == 200:
    dados = response.json()
    print("\nDeu certo!")
    print(dados)
else:
    print("Não foi Possível entrar no Site!")

