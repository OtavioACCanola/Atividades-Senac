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






