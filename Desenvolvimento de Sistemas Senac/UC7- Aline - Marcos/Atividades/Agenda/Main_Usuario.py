from PyQt5.QtWidgets import QApplication
import sys
from Controller_Agenda import Controller

if __name__ == "__main__":
    app = QApplication(sys.argv)
    conn = Controller()
    conn.Iniciar()
    sys.exit(app.exec_())