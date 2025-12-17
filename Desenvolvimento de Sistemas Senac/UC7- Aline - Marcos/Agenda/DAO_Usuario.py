from Connection_Factory import ConnectionFactory

class DAO_Usuario:
    def Cadastrar(self, Nome, Email, Senha):
        sql = """
            INSERT INTO TBL_Usuarios (Nome, Email, Senha) VALUES
            (?, ?, ?)
        """      
        try:
            conn = ConnectionFactory.get_Connection()
            cursor = conn.cursor()
            cursor.execute(sql, (Nome, Email, Senha))
            conn.commit()
            cursor.close()
            conn.close()
            return True
        except Exception as e:
            print(f"Erro ao Cadastrar Usuário: {e}")
        
    def Autenticar(self, Email, Senha):
        sql = """
            SELECT * FROM TBL_Usuarios
            WHERE Email = ? AND Senha = ?
            """
        try:
            conn = ConnectionFactory.get_Connection()
            cursor = conn.cursor()
            cursor.execute(sql, (Email, Senha))
            resultado = cursor.fetchone()
            cursor.close()
            conn.close()
            return resultado is not None
        except Exception as e:
            RuntimeError(f"Erro ao Autentificar: {e}")
            return False
        
    def concultarTodos(self):
        sql = """
            SELECT Id, Nome, Email FROM TBL_Usuarios
            """
        try:
            conn = ConnectionFactory.get_Connection()
            cursor = conn.cursor()
            cursor.execute(sql)
            usuarios = cursor.fetchall()
            cursor.close()
            conn.close() 
            return usuarios # Ret0rja a Lista de Usuários
        except Exception as e:
            print(f"Erro ao Consultar Usuários: {e}")
            return []

    def Remover(self, Email):
        sql_Verifica = "SELECT Id FROM TBL_Usuarios WHERE Email = ?"
        sql_Deleta = "DELETE FROM TBL_Usuarios WHERE Email = ?"
        try:
            conn = ConnectionFactory.get_Connection()
            cursor = conn.cursor()
            # Verifica se Existe o Usuário
            cursor.execute(sql_Verifica, (Email))
            usuario = cursor.fetchone() # Faz uma Procura dos Valores da 
            # Tabela do Banco e Guarda na Variável
            if usuario is None:
                # Não Existe -> nada será Removido
                cursor.close()
                conn.close()
                return False
        
            # Remove o Usuário
            cursor.execute(sql_Deleta, (Email))
            conn.commit()
            cursor.close()
            conn.close()
            return True
        except Exception as e:
            print(f"Erro ao Remover Usuário: {e}")
            return False
        