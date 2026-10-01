# Exercícios concatenação "f":

# Ex1: Peça para o usuário digitar o nome dele e depois exiba uma frase de boas-vindas usando concatenação tradicional (+):
nome= str (input("Digite seu nome: "))
frase1= "Olá "
frase2= ", Tudo bem? Como vai?"
input (frase1+ nome+ frase2)

# Ex2: Refaça o exercício acima, mas usando f-strings no lugar do +.
nome= str (input("Digite seu nome: "))
print(f"Olá {nome}, tudo bem? Como vai?")

# Ex3: Peça para o usuário digitar um número decimal (ex.: 3.14159) e mostre esse número com apenas duas casas decimais usando f-strings.
nd= float (input("Escreva seu número decimal: "))
print(f"Você escreveu o número {nd:.2f} né?")

# Ex4: Peça dois números ao usuário e mostre a soma entre eles usando f-strings para exibir:
n1= int (input("Escreva um número inteiro aleatório: "))
n2= int (input("Escreva outro número inteiro aleatório: "))
resultado= n1+n2
print (f"A soma desses dois números é: {resultado}")
