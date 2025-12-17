# =-=-=-=-=-=-= ATIVIDADES POO PYTHON  =-=-=-=-=-=-=

# Método / Função de Saudação do Usuário

def saudacao(nome):
    print(f"---- Saudação ----\n\nOlá, {nome}, como você está?")

saudacao("Otávio")

# Método / Função de Soma e Multiplicação de Produtos

def soma_Produto(num1, num2):
    soma = num1+num2
    multiplicacao = num1 * num2

    print(f"\n---- Calculadora ----\n\nCalculos: \n\nSoma: {soma}\nMultiplicação: {multiplicacao}")

soma_Produto(8,2)

# Método / Função com Variável Local

def variável_Local():
    exemplo = 1
    exemplo = 2
    print(f"\n---- Exemplo Variável Local----")
variável_Local()
# print(exemplo) # Dá erro pois não Acha a Variável por Conta dela Estar Dentro do Nétodo (Variável Local)

# Método / Função Argumento Padrão (Conta Quantidade Palavras na Frase)

def conta_Palavra(frase, serparador = ' '):

    palavra_Separada = frase.split(serparador) # cada vez que ele encontrar espaço ele separa na frase
    numero_palavras = len(palavra_Separada)
    print(f"\n---- Conta Palavra ----\n\nSua Frase Separada: {palavra_Separada}\nNumero de Palavras na Frase: {numero_palavras}")
conta_Palavra("Olá Mundo")

# Métodos / Função Lambda Qyadrado dos Numeros

numeros = [2,3,4]
quadrados_Numeros = lambda numeros: (numeros[0] * numeros[0], numeros[1] * numeros[1], numeros[2] * numeros[2])
resultado = quadrados_Numeros(numeros)
print(resultado)

# Método / Função Recursiva

def fibonacci(n): # metodo
    if (n == 0): # Se o valor de n é igual a 0 ele guarda o resultado 0
        return 0
    elif (n == 1): # Se o valor de n é igual a 1 ele guarda o resultado 1
        return 1
    else: # Se não for nenhum desses casos ele vai guardar o resultado do método fibonacci(5 - 1) + fibonacci(5-2)
        return (fibonacci(n-1) + fibonacci(n-2))
print(f"O Valor da Sequencia de fibonacci na 5º Casa é: {fibonacci(5)}")



