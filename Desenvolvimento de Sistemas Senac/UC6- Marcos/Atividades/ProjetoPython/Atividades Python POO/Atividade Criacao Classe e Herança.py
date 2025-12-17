# Criação Classe:

class Pessoa():
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade
    def falar(self):
        print(f"Olá, meu nome é {self.nome} e eu tenho {self.idade} anos!")

pessoa = Pessoa("Lucas", 19)
pessoa.falar()

# Herança:

class Veiculo():
    def __init__(self, marca, ano):
        self.marca = marca
        self.ano = ano

class Carro(Veiculo):
    def __init__(self, marca, ano, NumeroPortas):
        super().__init__(marca, ano)
        self.NumeroPortas = NumeroPortas

class Moto(Veiculo):
    def __init__(self, marca, ano, TipoGuidao):
        super().__init__(marca, ano)
        self.tipoGuidao = TipoGuidao

carro = Carro("Chevrolet", 1990, 4)
moto = Moto("Hyundai", 1999, "alto")

print(f"Carro: {carro.marca}, {carro.ano}, {carro.NumeroPortas}")
print(f"Moto: {moto.marca}, {moto.ano}, {moto.tipoGuidao}")