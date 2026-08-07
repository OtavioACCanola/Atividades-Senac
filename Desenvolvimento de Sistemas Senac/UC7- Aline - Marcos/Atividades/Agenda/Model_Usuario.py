# Importações

from DAO_Usuario import DAO_Usuario

class Model_Usuario():

    def __init__(self):
        self.dao = DAO_Usuario()

    def Cadastrar(self, Nome, Email, Senha):
        if Nome == "" or Email == "" or Senha == "":
            return False
        else:
            return self.dao.Cadastrar(Nome, Email, Senha)
            

    def Autenticar(self, email, senha):
        if email == "" or senha == "":
            return False
        else:
            return self.dao.Autenticar(email, senha)
        
    def Remover(self, email):
        if email == "":
            return False
        else:
            return self.dao.Remover(email)
        
    def Editar(self, Id, Email, Senha, Nome):
        if Id == "" or Email == "" or Senha == "" or Nome == "":
            return False
        else:
            return self.dao.Editar(Id, Email, Senha, Nome)
        
    def Listar(self):
        lista = self.dao.concultarTodos()
        return lista
    
    def ListarInfId(self, id):
        infId = self.dao.consultarInformacoesId(id)
        return infId
    
    def ListarNomeId(self):
        listaNome = self.dao.consultarNomesId()
        return listaNome

    def consultarEmail(self, email):
        constEmail = self.dao.consultaEmailCadastro(email)
        return constEmail

            
        
            


