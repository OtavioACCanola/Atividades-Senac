import sys, requests, json
from PyQt5.QtWidgets import QApplication, QPushButton, QLabel, QWidget, QLineEdit, QMessageBox
from PyQt5.QtGui import QFont

url = f"https://viacep.com.br/ws/05767350/json/"
response = requests.get(url)
dados = response.json()
print("--Resultado da busca--")
print(f"CEP: {dados['cep']}")
print(f"Rua: {dados['logradouro']}")
print(f"Bairro: {dados['bairro']}")
print(f"Cidade: {dados['localidade']}")
print(f"Estado: {dados['uf']}")