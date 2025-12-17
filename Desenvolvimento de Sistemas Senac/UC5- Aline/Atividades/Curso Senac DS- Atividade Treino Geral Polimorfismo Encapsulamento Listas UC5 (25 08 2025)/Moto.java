/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package localiza.veiculos.atividade.geral;

/**
 *
 * @author Dell
 */
public class Moto extends Veículo {
    int cilindrada;

    public Moto (String marca, String modelo, int ano, int valorDiaria, int cilindrada){
        super (marca, modelo, ano, valorDiaria);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    @Override
    public void exibirInformacoes(){
        System.out.println("O veículo abaixo foi brigado em nosso cadastro: \n Marca: " + getmarca() + "\n Modelo: " + getmodelo() + "\n Ano: " + getano() + "\n cilindradas: " + cilindrada + "\n --------------------------------------------------");
    }
}
