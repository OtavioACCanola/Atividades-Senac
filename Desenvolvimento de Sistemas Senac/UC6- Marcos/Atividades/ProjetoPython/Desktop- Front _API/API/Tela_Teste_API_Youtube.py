# Bibliotecas 
from deep_translator import GoogleTranslator # Biblioteca com Vários tipos de Tradutores da Internet

# Cria a Variável de Tradução
tradutor = GoogleTranslator(source="en", target="pt")

# Cria o texto à ser Traduzido 
texto = "Hello World"

# A Tradução 
traducao = tradutor.translate(texto)
print(traducao)


