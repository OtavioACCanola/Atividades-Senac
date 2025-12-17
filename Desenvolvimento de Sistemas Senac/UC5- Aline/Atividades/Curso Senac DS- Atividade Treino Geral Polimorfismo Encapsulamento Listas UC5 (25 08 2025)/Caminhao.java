/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package localiza.veiculos.atividade.geral;

/**
 *
 * @author Dell
 */
public class Caminhao extends Veículo {
    int capacidadeCarga;

    public Caminhao(String marca, String modelo, int ano, int valorDiaria, int capacidadeCarga){
        super (marca, modelo, ano, valorDiaria);
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
    
    @Override
    public void exibirInformacoes() {
        System.out.println("O veículo abaixo foi brigado em nosso cadastro: \n Marca: "+ getmarca() + "\n Modelo: " + getmodelo() + "\n Ano: "+ getano() + "\n Capacidade de Carga: " + capacidadeCarga + " Kg \n ------------------------------------------------------------------");
    }  
}

