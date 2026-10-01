# Exercício 1:

print('Bem vindo a calculadora de área e perímetro de retângulo!')
lr= int (input('Por favor, escreva o lado do retângulo: '))
ar= int (input('Por favor, agora escreva a altura do retângulo: '))
print('A área do retângulo é: ', lr * ar , 'm²')
print('O perímetro do retângulo é: ', lr*2 + ar*2, 'm')

# Exercício 2: 

print('Bem vindo a calculadora de área e perimetro de quadrado!')
lq= int (input('Escreva o lado do seu quadrado: '))
print ('A área do seu quadrado é: ', lq * lq), 'm²'
print ('O perímetro do seu quadrado é: ', lq * 4), 'm'

# Exercício 3:

print ('Bem vindo a calculadora de área e perímetro de círculo: ')
rc= float (input('Escreva o valor do raio do círculo: '))
print('O perímetro do seu círculo é: ', 2 * 3.14 * rc)
print('A área do seu círculo é: ', 3.14 * rc ** 2)

# Exercício 4:

print ('Bem vindo a calculadora de perímetro de triângulo:')
l1= int (input('Escreva o 1º lado do seu triângulo: '))
l2= int (input('Escreva o 2º lado do seu triângulo: '))
l3= int (input('Escreva o 3º lado do seu triângulo: '))
print('O perímetro do seu triângulo é: ', l1 + l2 + l3)
print ('Para descobrir a área do seu triângulo ')
vb= int (input('Escreva o valor da base do seu triângulo: '))
at= int (input('Escreva o valor da altura do seu triângulo: '))
print ('A área do seu triângulo é: ', vb * at / 2)

# Exercício 5:

vni= int (input('Escreva um número: '))
print('O sucessor do número digitado é ', vni + 1)

# Exercício 6: 

nd = int (input ("Escreva seu Dividendo: "))
nv = int (input ("Escreva seu Divisor: "))

rq= nd // nv
print("Seu Quociente é: ", (rq))

resultado_resto= nd % nv
print("Seu Resto é: ", (resultado_resto))

# Exercicio 7:

id_d= int (input ("Escreva sua idade em dias: "))
id_a= int (id_d // 365.25)
id_m= int (id_d // 30.44)

print("Sua idade em dias é: ", (id_d))
print("Sua idade em meses é: ", (id_m))
print("Sua idade em anos é: ", (id_a))

# Exercício 8- Desafio

nf= int (input ("Escreva sua temperatura em Fahrenheit para transformar em Celsius: "))
Celsius= (nf - 32) / 1.8
print ("Sua Temperatura em Celsius é: ", Celsius) 

# Exercício 9-

rlo= int (input ("Escreva o raio da circunferência: "))
alo= int (input("Escreva a altura da sua circunferência: "))
Volume= 3.14 * (rlo ** 2) * alo
print ("O volume da sua Lata é: ", (Volume))

# Exercício 10- 

ni= int (input ("Escreva um número menor que 32 para informar sua representação em binário: "))
if ni >= 32:
    print ("Escreva outro número menor que 32")
else:
    print ("Seu número, em binário é: ", bin (ni) [2:])

# Exercício 11-

print ("Escreva suas notas do Primeiro Bimenstre: ")
nP1= int, input (("Escreva a nota da P1: "))
nP2= int, input (("Escreva a nota da P2: "))
MB1= int, (nP1 + nP2) // 2

print ("Escreva suas notas do Segundo Bimestre")
nP3= int, input (("Escreva a nota da P1: "))
nP4= int, input (("Escreva a nota da P2: "))
MB2= int, (nP3 + nP4) // 2

MNoSemes= int, (MB1+MB2)

print ("A sua Nota Semestral é:" (MNoSemes))

# Exercício 12

vms= float (input("Escreva a distância desejada em m/s: "))
print (f"O valor da sua distância em Km/h é igual a: {vms:,.2f} km²")

