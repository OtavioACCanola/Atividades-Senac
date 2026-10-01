// Cruação de variáveis
#define ledVerdePedestre 2
#define ledVermelhoPedestre 4
#define ledVermelhoCarro 9
#define ledAmareloCarro 10
#define ledVerdeCarro 11
#define botao 5

// Definindo entrada e saída
void setup() {
  pinMode(ledVerdePedestre, OUTPUT);
  pinMode(ledVermelhoPedestre, OUTPUT);
  pinMode(ledVerdeCarro, INPUT);
  pinMode(ledVermelhoCarro, OUTPUT);
  pinMode(ledAmareloCarro, OUTPUT);
  pinMode(botao, INPUT);
  
  Serial.begin(9600);
}

// Loop do programa
void loop() {
    const int valorBotao = digitalRead(botao);

    Serial.println(valorBotao);
  }
