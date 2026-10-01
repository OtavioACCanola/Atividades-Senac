# Exercício 1- Soma

print('Exercício 1: Soma')
print("Escreva seu primeiro número:") 
numero1 = int (input())
print('Escreva seu segundo número: ')
numero2 = int (input())
r = numero1 + numero2
print ('O resultado é igual a:', r)

# Exercício 2- Subtração

print('Exercício 2: Subtração')
print('Escreva seu Primeiro Número: ')
Numero1= int (input ())
print('Escreva seu Segundo Número: ')
Numero2= int (input())
r= Numero1-Numero2
print('O Resultado é igual a: ', r)

# Exercício 3- Multiplicação

print('Exercício 3: Multiplicação')
print('Escreva seu Primeiro Número: ')
Numero1= int (input ())
print('Escreva seu Segundo Número: ')
Numero2= int (input())
r= Numero1*Numero2
print('O Resultado é igual a: ', r)

# Exercício 4- Divisão Inteira

print('Exercício 4: Divisão')
print('Escreva seu Primeiro Número: ')
Numero1= int (input ())
print('Escreva seu Segundo Número: ')
Numero2= int (input())
r= Numero1/Numero2
print('O Resultado é igual a: ', r)

# Exercício 5- Divisão Resto

print('Exercício 2: Divisão')
print('Escreva seu Primeiro Número: ')
Numero1= int (input ())
print('Escreva seu Segundo Número: ')
Numero2= int (input())
r= Numero1%Numero2
print('O Resultado da divisão é igual a: ', r)

# Exercício 6- Potência

print('Exercício 2: Divisão')
print('Escreva seu Número: ')
Numero1= int (input ())
print('Escreva sua Potência: ')
Numero2= int (input())
r= Numero1**Numero2
print('O Resultado da potência é igual a: ', r)

# Exercício 7- Comparação Dois Números Iguais

print('Escreva Primeiro Número: ')
a= int (input())
print('Escreva Segundo Número: ')
b= int (input())
if a==b: 
    print('Seus valores são iguais')
else:
    print('Seus valores são diferentes')

# Exercício 8- Verficação Dois Números Maior que o outro

print('Escreva Primeiro Número: ')
a= int (input())
print('Escreva Segundo Número: ')
b= int (input())
if a>b: 
    print('O primeiro número é maior que o segundo')
else:
    print('O segundo número é maior que o primeiro')

# Exercício 9- Verficação Dois Números Menor que o outro

print('Escreva Primeiro Número: ')
a= int (input())
print('Escreva Segundo Número: ')
b= int (input())
if a<b: 
    print('O primeiro número é menor que o segundo')
else:
    print('O segundo número é maior que o primeiro')

# Exercício 10- Verificação Dois Números Diferentes

print('Escreva Primeiro Número: ')
a= int (input())
print('Escreva Segundo Número: ')
b= int (input())
if a!=b: 
    print('Seus valores são diferentes')

# Exercício 11- Verificação Dois Números Diferentes

print('Escreva Primeiro Número: ')
a= int (input())
print('Escreva Outro Número: ')
b= int (input())
if a==b: 
    print('O primeiro número é igual ao segundo')
elif a>=b:
    print('Os primeiro número é maior que o segundo')
else:
    print('O segundo número é maior que o primeiro')

# Exercício 12- Verificação Dois Números Diferentes

print('Escreva Primeiro Número: ')
a= int (input())
print('Escreva Outro Número: ')
b= int (input())
if a==b: 
    print('O primeiro número é igual ao segundo')
elif a>=b:
    print('Os primeiro número é maior que o segundo')
else:
    print('O segundo número é maior que o primeiro')

# Exercício 13- And com Dois Valores Diferentes

a= int (input('Escreva o valor de a: '))
b= int (input('Escreva o valor de b: '))
print ((a>b) and (b<a))

# Exercício 14- Or Verificar Um Valor Verdadeiro

a= int (input('Digite o valor de a: '))
b= int (input('Digite o valor de b: '))
c= int (input('Digite o valor de c: '))

if a>b or a>c:
    print('O a é maior que b e c')

elif b>a or b>c:
    print('O b é maior que a e c')

elif c>a or c>b:
    print('O c é maior que a e b')

else:
    print('Os valores são iguais')

# Exercício 15- Not Inverter valor 

a= int (input('Digite o valor de a: '))
b= int (input('Digite o valor de b: '))

print (not a>b)

# Exercício 16- Operador += (Adicionar Valor Variável)

a= int(input('Escreva o valor de a: '))
a+=4
print(a)

# Exercício 17- Operador -= (Subtrair Valor Variável)

a= int(input('Escreva o valor de a: '))
a-=4
print(a)

# Exercício 18- Operador *= (Multipliar Valor Variável)

a= int (input('Escreva o valor a: '))
a *= 9 
print (a)

# Exercício 19- Operador /= (Dividir Valor Variável)

a= int (input ('Escreva o valor de a: '))
a /= 4 #Divisão comum
print(a)

# Exercício 20- Operador //= (Divisão Inteira Variável)

a= int (input('Escreva o valor de a: '))
a //= 4 #Divisão inteira
print(a)

# Exercício 21- Operador %= (Resto Divisão Variável)

a= int (input('Escreva o valor de a: '))
a %= 8 #Resto
print (a)

# Exercício 22- Operador **= (Potência Variável)

a= int(input('Escreva seu número: '))
a **= 3
print (a)

# Exercício 23- Operador is Mesmo Objeto

a= 1, 2, 3, 4
b= a

print ('As veriáveis a e b são:', (a is b))

# Exercício 24- Operador is not Não é Mesmo Objeto

a= 1, 2, 3, 4
b= 3, 4, 2, 1

print ('As veriáveis a e b não são iguais:', (a is not b))

# Exercício 25- Operador in em Lista

print ('O 3 está na lista?:', 3 in {1, 2, 3, 4})

# Exercício 26- Operador not in Não Está em Lista

print ('O 3 está na lista?:', 3 not in {1, 2, 4})

# Exercício 27- Operador in Está presente em um Dicionário
dicionario = {"Nome": "Paulo"}
print ('A variável Nome está no dicionário?: ', "Nome" in dicionario)

# Exercício 28- Operador in Está presente em uma String
print ('A palavra "b" está presente na palavra "batata"?:', "b" in "batata")