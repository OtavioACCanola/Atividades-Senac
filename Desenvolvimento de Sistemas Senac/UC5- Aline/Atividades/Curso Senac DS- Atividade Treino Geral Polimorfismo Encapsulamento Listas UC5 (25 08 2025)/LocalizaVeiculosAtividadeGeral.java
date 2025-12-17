/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package localiza.veiculos.atividade.geral;

/**
 *
 * @author Dell
 */
public class LocalizaVeiculosAtividadeGeral {

   public static void main(String[] args) {
            Carro Obj1 = new Carro ("Toyota", "HB20", 2020, 180, 4);
            Carro Obj2 = new Carro ("Fiat", "Uno", 2015, 90, 2);
            Carro Obj3 = new Carro ("Ford", "Ka", 2017, 100, 4);
   
            Moto Obj4 = new Moto ("Honda", "CG 160 Start", 2021, 70, 160);
            Moto Obj5 = new Moto ("Yamaha", "Fazer 250 ABS", 2022, 100, 250);
            Moto Obj6 = new Moto ("BMW", "G 310 R", 2023, 180, 310);
   
            Caminhao Obj7 = new Caminhao ("Shineray", "Worker 125", 2019, 60, 25);
            Caminhao Obj8 = new Caminhao ("Honda", "Biz 125", 2022, 85, 10);
            Caminhao Obj9 = new Caminhao ("Kenton", "Delivery 150", 2023, 95, 30);
            
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

    }
}
    
