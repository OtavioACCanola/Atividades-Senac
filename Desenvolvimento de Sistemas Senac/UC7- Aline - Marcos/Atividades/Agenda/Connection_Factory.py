import pyodbc

class ConnectionFactory:
    @staticmethod
    def get_Connection():
        connection_String = (
            "Driver={SQL Server};"
            "Server=DESKTOP-FIQ0BGR\SQLEXPRESS;"  # NOME-DO-PC\SQLEXPRESS (PC da Escola: TBS0676755W11-1\SQLEXPRESS) / (PC de Casa: DESKTOP-FIQ0BGR\SQLEXPRESS)  ou localhost se o BD estiver na mesma máquina
            "Database=LoginBanco;"              # Nome do DataBase
            "Trusted_Connection=yes;"           # Usa Login do Windows
            "Encrypt=no;"                       # Evita Erros do SSL
        )
        try:
            conn = pyodbc.connect(connection_String)
            return conn
        except Exception as e:
            raise RuntimeError(f"Erro de Conexão: {e}")