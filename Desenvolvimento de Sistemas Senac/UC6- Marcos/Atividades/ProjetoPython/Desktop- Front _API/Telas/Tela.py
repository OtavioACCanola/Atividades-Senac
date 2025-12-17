# Importando a Biblioteca SYS

import sys
from PyQt5.Qtwidgets import QApplication, QtWidget

# Criando a Aplicação
app = QApplication(sys.argv)

# Criando a Janela Principal
janelinha= QtWidget()

# Exibindo a Janela
janelinha.show

# Iniciando o loop de eventos
sys.exit(app.exec_())



