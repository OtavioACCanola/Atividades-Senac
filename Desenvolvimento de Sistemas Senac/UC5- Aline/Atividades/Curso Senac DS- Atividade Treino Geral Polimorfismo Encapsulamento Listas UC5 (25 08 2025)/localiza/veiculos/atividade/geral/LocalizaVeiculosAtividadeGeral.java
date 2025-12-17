/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package localiza.veiculos.atividade.geral;

/**
 *
 * @author otavio.accarmo
 */
public class LocalizaVeiculosAtividadeGeral {

      public static void main(String[] args) {
            // Definindo objetos para Carro
            Carro Obj1 = new Carro ("Toyota", "HB20", 2020, (float)180.0, 4);
            Carro Obj2 = new Carro ("Fiat", "Uno", 2015, (float)90.0, 2);
            Carro Obj3 = new Carro ("Ford", "Ka", 2017, (float)100.0, 4);
            
            // Definindo objetos para Moto
            Moto Obj4 = new Moto ("Honda", "CG 160 Start", 2021, (float)70, 160);
            Moto Obj5 = new Moto ("Yamaha", "Fazer 250 ABS", 2022, (float)100.0, 250);
            Moto Obj6 = new Moto ("BMW", "G 310 R", 2023, (float)180.0, 310);
   
            // Definindo objetos para Caminhão
            Caminhao Obj7 = new Caminhao ("Shineray", "Worker 125", 2019, (float)60.0, 25);
            Caminhao Obj8 = new Caminhao ("Honda", "Biz 125", 2022, (float)85.0, 10);
            Caminhao Obj9 = new Caminhao ("Kenton", "Delivery 150", 2023, (float)95.0, 30);
            
            // Exibindo informações dos veículos:
            System.out.println("Exibindo Informações veículos ");
            System.out.println("----------------------------------------------------------------------------------");
            Veículo[] Veiculos = {Obj1, Obj2, Obj3, Obj4, Obj5, Obj6, Obj7, Obj8, Obj9};
            Veiculos[0].exibirInformacoes();
            Veiculos[1].exibirInformacoes();
            Veiculos[2].exibirInformacoes();
            Veiculos[3].exibirInformacoes();
            Veiculos[4].exibirInformacoes();
            Veiculos[5].exibirInformacoes();
            Veiculos[6].exibirInformacoes();
            Veiculos[7].exibirInformacoes();
            Veiculos[8].exibirInformacoes();
                        
            // Calculando o aluguel dos veículos
            System.out.println("Calculando valor aluguel: ");
            float total = Veiculos[0].calcularAluguel(5);
            System.out.println ("O valor do alguel, para esse veículo, é de: R$ "+ total);
            
            System.out.println("----------------------------------------------------------------------------------");
            
            // Tentando buscar anos antes de 1900:
            System.out.println("Buscando erros: ");
            Veiculos[1].setano(-8);
            Veiculos[4].setvalorDiaria(0);
            Veiculos[7].setmodelo("");
            
            System.out.println("----------------------------------------------------------------------------------");

            // Questões no final:
            System.out.println("Questões finais: ");
            /* 1) */ System.out.println("Ele ajudou a trazer o ano com as condições que colocamos, pois se colocassemos a global, "
                    + "ele iria colocar normalmente, sem as expecificações, pois colocamos as expecificações no método set");
            /* 2) */ System.out.println("Ele trás facilmente para nós as variáveis da classe veículos para as outras classes filhas, "
                    + "além dos métodos de busca");
            /* 3) */ System.out.println("Ele alterou a estrutura dos métodos de exibição de informações sobre o veículo,"
                    + "possibilitando colocar os atributos respectivos para cada tipo de veículo diferente");
            /* 4) */ System.out.println("O construtor definil o valor dos atributos que precisavamos definir nos objetos que criamos para cada"
                    + "tipo de veículo");
      }
}
