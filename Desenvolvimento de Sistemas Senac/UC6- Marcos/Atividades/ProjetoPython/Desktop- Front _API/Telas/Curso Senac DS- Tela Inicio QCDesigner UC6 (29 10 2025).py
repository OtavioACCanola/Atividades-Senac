# Chamar o Tamplate da Tela que Criamos

from PyQt5 import QtWidgets, uic
app = QtWidgets.QApplication([])
janelinha = uic.loadUi("Tela Inicio.ui")

def boasVindas():
   if janelinha.iLogin.text() == "Otávio" and janelinha.iSenha.text() == "123":
    CampoLogin= janelinha.iLogin.text()
    print(CampoLogin)
    CampoSenha = janelinha.iSenha.text()
    print(CampoSenha)
    janelinha.LblImputText.setText(f"Usuario: {CampoLogin}\nSenha: {CampoSenha}")
   elif janelinha.iLogin.text() == "" and janelinha.iSenha.text() == "":
     janelinha.LblImputText.setText("Erro! Login e Senha\nprecisam estar\npreenchidos")
   elif janelinha.iLogin.text() != "Otávio" and janelinha.iSenha.text() != "123":
     janelinha.LblImputText.setText("Erro! Login ou Senha\ninvalidos")
    


   
    

def limpar():
    janelinha.iLogin.clear()
    janelinha.iSenha.clear()


janelinha.bLogar.clicked.connect(boasVindas)
janelinha.bLimpar.clicked.connect(limpar)

janelinha.show()
app.exec_()
