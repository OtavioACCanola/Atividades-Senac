# Importação Tela
import csv, os
from PyQt5 import QtWidgets, uic, QtGui
from PyQt5.QtWidgets import QMessageBox
app = QtWidgets.QApplication([])
janelinha = uic.loadUi("TelaAddMidias.ui")

# Classes
class Midia():
    def exibir_info():
     raise NotImplementedError("Subclasses devem importar esse método")

class Livro(Midia):
    def __init__(self, titulo, autor, numero_Paginas):
        self.titulo = titulo
        self.autor = autor
        self.numeroPaginas = numero_Paginas
        super().__init__()

    def exibir_info(self):
        mensagem = f"Livro:\n\nTítulo: {self.titulo}\nAutor:{self.autor}\nQuantidade de Páginas: {self.numeroPaginas}"
        janelinha.TxtResultado.setText(mensagem)

class Filme(Midia):
    def __init__(self, titulo, diretor, duracao_minutos):
        self.titulo = titulo
        self.diretor = diretor
        self.duracao = duracao_minutos
        super().__init__()

    def exibir_info(self):
        mensagem = f"Filme:\n\nTítulo: {self.titulo}\nDiretor:{self.diretor}\nDuração em Minutos: {self.duracao}"
        janelinha.TxtResultado.setText(mensagem)

class Musica(Midia):
    def __init__(self, titulo, artista, duracao_segundos):
        self.titulo = titulo
        self.artista = artista
        self.duracao = duracao_segundos
        super().__init__()
        return

    def exibir_info(self):
        mensagem = f"Filme:\n\nTítulo: {self.titulo}\nArtista:{self.artista}\nDuração em Segundos: {self.duracao}"
        janelinha.TxtResultado.setText(mensagem)

def informacoes_entretenimento(midia):
    midia.exibir_info()
    return

def limparCampos():
    janelinha.TxtValor1.clear()
    janelinha.TxtValor2.clear()
    janelinha.TxtValor3.clear()

def criarMidia(self):
    if janelinha.OpcLivro.isChecked():
        if janelinha.TxtValor1.text() == "" or janelinha.TxtValor2.text() == "" or janelinha.TxtValor3.text() == "":
            QMessageBox.critical(janelinha, "Atenção", "Não é permitido deixar os campos Vazios!")
        else:
            objetoLivro = Livro(janelinha.TxtValor1.text(), janelinha.TxtValor2.text(), janelinha.TxtValor3.text())
            QMessageBox.information(janelinha, "Criação", f"Livro Criado")
            dados = [
                ["Livro"],
                ["Título", " Autor", " Quantidade de Páginas"],
                [f"{objetoLivro.titulo}", f" {objetoLivro.autor}", f" {objetoLivro.numeroPaginas}\n"]
            ]
            with open("Mídias.csv", "a", newline= '') as arquivo:
                escritor = csv.writer(arquivo)
                escritor.writerows(dados)

    elif janelinha.OpcMusica.isChecked():
        if janelinha.TxtValor1.text() == "" or janelinha.TxtValor2.text() == "" or janelinha.TxtValor3.text() == "":
            QMessageBox.critical(janelinha, "Atenção", "Não é permitido deixar os campos Vazios!")
        else:
            objetoMusica = Musica(janelinha.TxtValor1.text(), janelinha.TxtValor2.text(), janelinha.TxtValor3.text())
            QMessageBox.information(janelinha, "Criação", f"Música Criada")
            dados = [
                ["Música"],
                ["Titulo", "Artista", "Duração Segundos"],
                [f"{objetoMusica.titulo}, {objetoMusica.artista}, {objetoMusica.duracao}\n"]
            ]
            with open("Mídias.csv", "a", newline= '') as arquivo:
                escritor = csv.writer(arquivo)
                escritor.writerows(dados)

    elif janelinha.OpcFilme.isChecked():
        if janelinha.TxtValor1.text() == "" or janelinha.TxtValor2.text() == "" or janelinha.TxtValor3.text() == "":
            QMessageBox.critical(janelinha, "Atenção", "Não é permitido deixar os campos Vazios!")
        else:
            objetoFilme = Filme(janelinha.TxtValor1.text(), janelinha.TxtValor2.text(), janelinha.TxtValor3.text())
            QMessageBox.information(janelinha, "Criação", f"Filme Criado")
            dados = [
                ["Filme"],
                ["Titulo", "Diretor", "Duração Minutos"],
                [f"{objetoFilme.titulo}, {objetoFilme.diretor}, {objetoFilme.duracao}\n"]
            ]
            with open("Mídias.csv", "a", newline= '') as arquivo:
                escritor = csv.writer(arquivo)
                escritor.writerows(dados)
    else:
        QMessageBox.critical(janelinha, "Erro", "Não foi Possível Criar uma Mídia, Selecione um Tipo de Mídia para Criar")

def listarMidias():
    if os.path.getsize("Mídias.csv") == 0:
        QMessageBox.critical(janelinha, "Atenção", "Não tem Nenhuma Mídia Adicionada")
    with open ('Mídias.csv', 'r') as arquivo:
        leitor = csv.reader(arquivo)
        vetorFormatado = []
        for linha in leitor:
            linha_String = ", ".join(linha)
            vetorFormatado.append(linha_String)
        string_final = "\n".join(vetorFormatado)
        janelinha.TxtResultado.setText(string_final)


def definirTextos():

    if janelinha.OpcLivro.isChecked():
        limparCampos()
        janelinha.TxtValor1.setPlaceholderText("Título do Livro")
        janelinha.TxtValor2.setPlaceholderText("Autor do Livro")
        janelinha.TxtValor3.setPlaceholderText("Quantidade de Páginas")

    elif janelinha.OpcFilme.isChecked():
        limparCampos()
        janelinha.TxtValor1.setPlaceholderText("Título do Filme")
        janelinha.TxtValor2.setPlaceholderText("Diretor do Filme")
        janelinha.TxtValor3.setPlaceholderText("Duração em Minutos")

    elif janelinha.OpcMusica.isChecked():
        limparCampos()
        janelinha.TxtValor1.setPlaceholderText("Título da Música")
        janelinha.TxtValor2.setPlaceholderText("Artista")
        janelinha.TxtValor3.setPlaceholderText("Duração em Segundos")

# ============================================ TELA =====================================================

# Definindo Botões e TextFields
janelinha.OpcLivro.toggled.connect(definirTextos)
janelinha.OpcFilme.toggled.connect(definirTextos)
janelinha.OpcMusica.toggled.connect(definirTextos)
janelinha.BtnAdicionar.clicked.connect(criarMidia)
janelinha.BtnListar.clicked.connect(listarMidias)
janelinha.TxtResultado.setReadOnly(True)

# Colocando Imagem como Ícone da Tela
janelinha.setWindowIcon(QtGui.QIcon("IconMusicaFilmeLivro.png"))

# Execução Janela
janelinha.show()
app.exec_()