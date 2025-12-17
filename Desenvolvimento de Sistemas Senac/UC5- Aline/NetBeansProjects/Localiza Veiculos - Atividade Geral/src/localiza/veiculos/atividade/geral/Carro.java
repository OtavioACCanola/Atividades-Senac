/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package localiza.veiculos.atividade.geral;

/**
 *
 * @author otavio.accarmo
 */
public class Carro extends Veículo {
    int portas;
    
    public Carro(String marca, String modelo, int ano, float valorDiaria, int portas) {
        super (marca, modelo, ano, valorDiaria);
        this.portas = portas;
    }
 
    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    @Override
    public void exibirInformacoes(){
        System.out.println("O veículo abaixo foi brigado em nosso cadastro: \n Marca: "+ getmarca() + "\n Modelo: " 
                + getmodelo() + "\n Ano: "+ getano() + "\n Valor da Diária: " +getvalorDiaria()+ "\n Portas: " + portas +   "\n -----------------------------------------");
    }
    
    /* OU assim:

    @Override
    public String exibir(){
    String dadosVeiculo = "Marca: " + getmarca() + "\nModelo: " + getmodelo();
        return dadosVeiculo;
    } */
}            

