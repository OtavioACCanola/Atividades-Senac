import pyodbc

class ConnectionFactory:
    @staticmethod
    def get_Connection():
        connection_String = (
            "Driver={SQL Server};"
            "Server=DESKTOP-FIQ0BGR\SQLEXPRESS;"                 # ou NOME-DO-PC\SQLEXPRESS
            "Database=LoginBanco;"              # Nome do DataBase
            "Trusted_Connection=yes;"           # Usa Login do Windows
            "Encrypt=no;"                       # Evita Erros do SSL
        )
        try:
            conn = pyodbc.connect(connection_String)
            return conn
        except Exception as e:
            raise RuntimeError(f"Erro de Conexão: {e}")