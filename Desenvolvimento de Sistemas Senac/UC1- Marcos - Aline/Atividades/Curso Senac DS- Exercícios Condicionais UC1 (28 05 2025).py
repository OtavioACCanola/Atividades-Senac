# Exercício 1- Inciante

n1 = int (input ('Escreva seu número aleatório: '))

if (n1>0):
    print('Seu número é Positivo')
elif (n1==0):
    print('Seu número é neutro')
else:
    print('Seu número é negativo')

# Exercício 2- Inciciante

n1 = int (input ('Escreva sua idade para checar se pode votar: '))

if (n1>=18):
    print('Pode Votar chefia!')
else:
    print('Pode votar não chefe, foi mal')

# Exercício 3- Iniciante

n1= int (input ('Escreva seu número: '))


if ((n1 % 2) == 0):
    print("Seu número é par")
else:
    print('Sei número é impar')

# Exercício 4- Intermediário

n1= int (input ('Escreva sua Nota'))
if (n1 >= 7):
    print('aprovado')
elif (5 <= n1 < 7):
    print('recuperação')
else:
    print('Reprovado')

# Exercício 5- Intermediário

Usuario= str (input('Escreva seu usuário: '))

Senha= int (input('Escreva sua senha: '))

if (Usuario == 'admim'):
    print('Usuário correto')

if (Senha == 1234):
    print('Acesso concedido')

else:
    print('Acesso Negado, tente novamente')

# Exercício 6- Intermediário

peso= float (input ('Escreva seu peso: '))

altura= float (input ('Escreva sua alrura: '))

IMC= (peso // altura ** 2)

print('Seu IMC é: ', (IMC)) 


