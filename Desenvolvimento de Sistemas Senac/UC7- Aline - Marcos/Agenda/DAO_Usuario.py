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
            print(f"Erro ao Autentificar: {e}")
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
            return usuarios # Retorna a Lista de Usuários
        except Exception as e:
            print(f"Erro ao Consultar Usuários: {e}")
            return []

    def consultarNomes(self):
        sql = """
              SELECT Nome FROM TBL_Usuarios
              """
        try:
            conn = ConnectionFactory.get_Connection()
            cursor = conn.cursor()
            cursor.execute(sql)
            nomeUsuarios = cursor.fetchall()
            cursor.close()
            conn.close()
            return nomeUsuarios
        except Exception as e:
            print(f"Erro ao Consultar Nome dos Usuários: {e}")
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

# Corrigir Editar
    def Editar(self, Id, Email, Senha, Nome):
        sql_VerificaId = "SELECT Id FROM TBL_Usuarios WHERE Id = ?"

        sql_Editar = "UPDATE TBL_Usuarios SET Email = ?, Nome = ?, Senha = ? WHERE Id = ?" 
        # Não pode colocar '' onde estão as ?, vai dar erro
        
        try:
            conn = ConnectionFactory.get_Connection()
            cursor = conn.cursor()
            cursor.execute(sql_VerificaId, (Id))
            usuario = cursor.fetchone()
            if usuario is None:
                cursor.close()
                conn.close()
                return False  
            edicao = Email, Nome, Senha, Id, # Precisa de uma virgulo aqui também, para virar uma tupla, é como se fosse o parenteses que vira tupla
            cursor.execute(sql_Editar, edicao)
            conn.commit()
            cursor.close()
            conn.close()
            return True
        except Exception as e:
            print(f"Erro ao Editar o Usuário: {e}")
            return False
        