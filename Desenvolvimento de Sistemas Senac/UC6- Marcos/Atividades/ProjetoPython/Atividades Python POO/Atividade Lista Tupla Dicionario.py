# =-=-=-=-=-=-=-=-=-=-= LISTAS =-=-=-=-=-=-=-=-=-=-=

# Números
# lista_Numeros = [9,8,7,6,5,4,3,2,1]

# for i in lista_Numeros:
#     if(i % 2 == 0):
#         pass
#     else:
#         print(i)

# # Frutas
# frutas = ["maçã", "banana", "melão"]

# fruta = input("Escreva uma fruta para ver se está na lista: ")
# if fruta in frutas:
#     print("A fruta está na lista")
# else:
#     print("A fruta não estava na lista, adicionando fruta")
#     frutas.append(fruta)
#     print(frutas)

# =-=-=-=-=-=-=-=-=-=-= TUPLAS =-=-=-=-=-=-=-=-=-=-=

# Fahrenheit
temperaturaCelsius = (32, 17, 90)
  
for i in temperaturaCelsius:
    fahrenheit = (i * 9/5) + 32
    print(f"{fahrenheit:.2f}")

# Coordenadas:
coordenadas = (-1, 20, 30)
i = 0

while i < len(coordenadas):
    if coordenadas[i] > 0:
        print(f"A coordenada {coordenadas[i]} é maior que 0")
    else:
        print(f"0 é maior que a coordenada {coordenadas[i]}")
    i += 1

# =-=-=-=-=-=-=-=-=-=-= DICIONÁRIOS =-=-=-=-=-=-=-=-=-=-=

# Desconto:
dicionarioProdutos = {"Controle-VideoGame": 120.50, "Feijão": 10.99, "Farofa": 7.99}

for chave, valor in dicionarioProdutos.items():
    if valor > 100:
        desconto = valor * 0.1
        valor = valor - desconto
        print(f"{chave}: {valor}")

# Livro:
livro = {"Título": "Harry Potter", "Autora": "J.K Holling", "Ano-Publicação": 1996}

for chave, valor in livro.items():
    if chave == "Ano-Publicação" and valor > 2000:
        print(f"O Livro, {livro["Título"]}, foi publicado depois dos anos 2000")
    else:
        print(f"O Livro, {livro['Título']}, não foi publicado depois dos anos 2000")
