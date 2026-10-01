/*  Projeto: Controle de Motores 2WD com ESP32 via Bluetooth
 *  Foco: Controle via Smartphone (Sem sensores)
 *
 *  Comandos:
 *    F/f = frente | B/b = trás | L/l = esquerda | R/r = direita | S/s = parar
 *    '0'..'9'    = limite de velocidade (0 = mínima, 9 = máxima)
 *    'q'         = velocidade máxima
 *
 *  Requisitos: placa "ESP32 Dev Module" (ESP32 clássico, com Bluetooth Classic).
 *  Compatível com o core esp32 2.x e 3.x (a API de PWM é escolhida em tempo de compilação).
 *  Os jumpers ENA/ENB do L298 devem permanecer ligados: o PWM vai nos pinos IN1..IN4.
 */
 
#include "BluetoothSerial.h"
 
// Instância do Bluetooth do ESP32
BluetoothSerial SerialBT;
 
//================================================================================
//=================> Configuração dos pinos do L298 (GPIOs do ESP32)
#define dirFrente 13        //Pino referente ao IN1
#define dirTras   12        //Pino referente ao IN2
#define esqFrente 26      //Pino referente ao IN3
#define esqTras   27        //Pino referente ao IN4
 
//=================> Definições de Direção
#define FRENTE  1
#define PARADO  0
#define TRAS   -1
 
//=================> Configuração do PWM (LEDC do ESP32)
#define PWM_FREQ 1000       // Hz; suba para ~5000 se o motor "assobiar"
#define PWM_RES  8          // 8 bits => duty de 0 a 255
 
// Canais LEDC (só usados no core 2.x; no core 3.x o canal é atribuído ao pino)
#define CH_DIR_F 0
#define CH_DIR_T 1
#define CH_ESQ_F 2
#define CH_ESQ_T 3
 
// Camada de compatibilidade: a API de PWM mudou entre o core 2.x e o 3.x
#if ESP_ARDUINO_VERSION_MAJOR >= 3
  // Core 3.x: o PWM é configurado e escrito direto pelo número do pino
  #define PWM_ATTACH(pino, canal)       ledcAttach(pino, PWM_FREQ, PWM_RES)
  #define PWM_WRITE(pino, canal, duty)  ledcWrite(pino, duty)
#else
  // Core 2.x: o PWM passa por um canal, associado ao pino
  #define PWM_ATTACH(pino, canal)       do { ledcSetup(canal, PWM_FREQ, PWM_RES); ledcAttachPin(pino, canal); } while (0)
  #define PWM_WRITE(pino, canal, duty)  ledcWrite(canal, duty)
#endif
 
const int VEL_MIN = 120;    // Abaixo disso o motor não vence o atrito (ajuste na prática)
const int VEL_MAX = 255;
int velocidade = 200;       // Limite atual de velocidade (duty PWM base, antes da compensação)
 
// Fatores de correção entre os dois motores (1.0 = sem correção).
// Ajuste na prática: reduza o fator do motor que for mais forte, até o carrinho andar reto.
const float FATOR_ESQ = 1.0;
const float FATOR_DIR = 1.0;
 
// Sentido atual de cada motor (permite reaplicar ao mudar a velocidade)
int estadoEsq = PARADO;
int estadoDir = PARADO;
 
char comando; // Armazena a caractere recebido via Bluetooth
 
//================================================================================
//=================> Declaração das funções do motor
void configMotor();
void motorEsq(int direcao);
void motorDir(int direcao);
void parar();
void limitarVelocidade(int v);
 
//================================================================================
//=================> Início do setup
void setup() {
  configMotor(); // Inicializa os pinos dos motores (PWM) e garante motores parados
 
  // Nome que vai aparecer no Bluetooth do Celular
  SerialBT.begin("Carrinho_ESP32");
}
 
//================================================================================
//=================> Início do loop
void loop() {
  // Verifica se chegou algum dado vindo do aplicativo do celular
  if (SerialBT.available()) {
    comando = SerialBT.read(); // Lê o caractere enviado
 
    // Executa a ação de acordo com a letra recebida
    switch (comando) {
      case 'F':
      case 'f':
        motorEsq(FRENTE);
        motorDir(FRENTE);
        break;
 
      case 'B':
      case 'b':
        motorEsq(TRAS);
        motorDir(TRAS);
        break;
 
      case 'L':
      case 'l':
        motorEsq(TRAS);
        motorDir(FRENTE);
        break;
 
      case 'R':
      case 'r':
        motorEsq(FRENTE);
        motorDir(TRAS);
        break;
        
 
      case 'S':
      case 's':
        parar();
        break;
 
      case 'q':
        limitarVelocidade(VEL_MAX);
        break;
 
      default:
        // Dígitos '0'..'9' ajustam o limite de velocidade
        if (comando >= '0' && comando <= '9') {
          limitarVelocidade(map(comando - '0', 0, 9, VEL_MIN, VEL_MAX));
        }
        break;
    }
  }
}
 
//================================================================================
//=================> Implementação de funções
 
//=================> Função Configuração do Motor
void configMotor() {
  PWM_ATTACH(dirFrente, CH_DIR_F);
  PWM_ATTACH(dirTras,   CH_DIR_T);
  PWM_ATTACH(esqFrente, CH_ESQ_F);
  PWM_ATTACH(esqTras,   CH_ESQ_T);
 
  parar();
}
 
//=================> Função Configuração do motor esquerdo
// O pino da direção ativa recebe o PWM (já com o fator de compensação); o outro fica em 0.
void motorEsq(int direcao) {
  estadoEsq = direcao;
  int duty = velocidade * FATOR_ESQ;
  PWM_WRITE(esqFrente, CH_ESQ_F, direcao == FRENTE ? duty : 0);
  PWM_WRITE(esqTras,   CH_ESQ_T, direcao == TRAS   ? duty : 0);
}
 
//=================> Função Configuração do motor direito
void motorDir(int direcao) {
  estadoDir = direcao;
  int duty = velocidade * FATOR_DIR;
  PWM_WRITE(dirFrente, CH_DIR_F, direcao == FRENTE ? duty : 0);
  PWM_WRITE(dirTras,   CH_DIR_T, direcao == TRAS   ? duty : 0);
}
 
//=================> Função Parar (ambos os INs em 0 = roda livre)
void parar() {
  motorEsq(PARADO);
  motorDir(PARADO);
}
 
//=================> Função Limitar Velocidade
// Define o teto de velocidade base e reaplica no movimento em curso.
void limitarVelocidade(int v) {
  velocidade = constrain(v, VEL_MIN, VEL_MAX);
  motorEsq(estadoEsq);
  motorDir(estadoDir);
}