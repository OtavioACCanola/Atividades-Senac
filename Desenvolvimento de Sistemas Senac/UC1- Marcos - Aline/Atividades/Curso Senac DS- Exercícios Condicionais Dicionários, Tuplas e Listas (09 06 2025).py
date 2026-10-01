# *Nível Iniciante

# Exercício 1: Imprimir Mensagem 5 Vezes

for i in range (6):
    print ("Olá Mundo")

# Exercício 2: Contar de 1 a 10

i= 0
while i <= 10:
    print (i)
    i+=1

# Exercício 3: Percorrer Lista Frutas

frutas= ["maça", "banana", "melância", "uva"]
for i in (frutas):
    print (f"Eu gosto de {i}")

# Exercício 4: Verificar Número está Lista

numeros= [1, 2, 3, 7, 37]

ne= int (input ("Escreva um número para conferir se está na lista: "))
if ne in numeros:
    print ("Seu número está na lista")
elif ne not in numeros:
    print ("Seu número não está na lista")

# Exercício 5: Somar Elementos Lista

numeros= [1, 2, 3, 4, 5]

for i in numeros:
    print ((i) + 90)

# * Nível Intermediário

# Exercício 6: Filtrar Pares Lista

numeros= [1, 2, 4, 7, 8, 60, 42, 67, 89, 15]

for i in numeros:
    if i % 2 == 1:
        print(i)
    else:
        continue


# Exercício 7: Modificar Elementos Listas

pl= [90, 70, 100]

for i in range (len(pl)):
    a= (pl [i] * 0.9)
    print (a)

# Exercício 8: Exibir informações Pessoas Dicionário

pessoa= {'Nome': 'Otávio', 'Idade': 18, 'Cidade': 'São Paulo'}
for chave, valor in pessoa.items():
   print (f"Olá! Meu nome é {pessoa['Nome']}, tenho {pessoa['Idade']} e moro em {pessoa['Cidade']}")

# Exercício 9: Criar uma Nova Lista com Valores Acima de 50

numeroab50= [80, 78, 47, 34,70, 28, 15]
numeroac50= []
 
for i in numeroab50:
    if i > 50:
        numeroac50.append(i)
        print (f"Sua lista de números maiores que 50 ficou: {numeroac50}")

# * Nível Desafio 

# Exercício 10: Simular Caixa Eletrônico

escolha1= "sim" 
escolha2= "não" 

usuario= input(("Escreva seu usuário: "))
print (f"Bem vindo a sua conta {usuario}!")
Saldo= 5000
print (f"{usuario}, o saldo da sua conta é: {Saldo}")
saque1= int (input("Digite quanto você quer sacar da sua conta: "))
restante1= Saldo-saque1
print("Ação efetuada com sucesso, pegue seu dinheiro no totem :)")
escolhausu= input(f"O saldo da sua conta, agora, ficou de: {restante1}, deseja efetuar mais um saque? ")

while escolhausu.lower()== "sim":
    saque2= int (input(f"Você quer sacar mais quanto de sua conta? Seu saldo agora é de {restante1}: "))
    restante2= restante1-saque2
    print("Ação efetuada com sucesso, pegue seu dinheiro no totem :)")
    escolhausu= input(f"O saldo da sua conta, agora, ficou de: {restante2}, deseja efetuar mais um saque? ")

print (f"Você decidiu sair, até logo {usuario}")

# Exercício 11: 