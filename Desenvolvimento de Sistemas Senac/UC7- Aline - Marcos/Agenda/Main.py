import DAO_Usuario

dao = DAO_Usuario.DAO_Usuario()

def opcoes():
    while True:
        print("\n=-=-=-=-= OPÇÕES =-=-=-=-=")
        print("Aqui são as Opções da Agenda: \n")
        print("1- Cadastrar")
        print("2- Remover")
        print("3- Consultar")
        print("4- Sair")
        opcao = input("Digite a Opção que Deseja Realizar: ")
        try:
            if opcao == "1":
                nome = input("Digite o Nome da Pessoa: ")
                email = input("Digite o Email da Pessoa: ")
                senha = input("Digite a Senha da Pessoa: ")
                cadastro = dao.Cadastrar(nome, email, senha)
                if cadastro == True:
                    print("Usuário Adicionado com Sucesso!")
                    continue
                else:
                    print("Erro!")
                    continue
            elif opcao == "2":
                email = input("Digite o Email da Pessoa que Deseja Remover: ")
                remover = dao.Remover(email)
                if remover == True:
                    print("Contato Removido com Sucesso!")
                    continue
                else:
                    print("Erro!")
                    continue
            elif opcao == "3":
                consulta = dao.concultarTodos()
                print(f"Lista de Contatos: {consulta}")
                continue
            elif opcao == "4":
                print("Foi um Prazer te Receber, até Logo 👋\n")
                break
        except Exception:
                print("Digite apenas Valores Válidos!")

def main():
     while True:
        try:
            print("=-=-=-=-= BEM-VINDO À AGENDA =-=-=-=-=\n")
            print("* Primeiro Autentifique seu Usuário")
            email = input("Digite o seu Email de Login: ")
            senha = input("Digite sua Senha de Login: ")
            autentificar = dao.Autenticar(email, senha)
            if autentificar == True:
                opcoes()
            else:
                print("Tente Novamente")
        except:
            print("Insira Dados Válidos")

if __name__ == "__main__":
    main()