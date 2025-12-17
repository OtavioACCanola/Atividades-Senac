/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package localiza.veiculos.atividade.geral;

/**
 *
 * @author Dell
 */
public class Veículo {
    private String marca;
    private String modelo;
    private int ano;
    private int valorDiaria;
    
    public Veículo(String marca, String modelo, int ano, int valorDiaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.valorDiaria = valorDiaria;
    }
    
    public void setmarca(String marca) {
    this.marca = marca;
    }
    public String getmarca(){
        return marca;
    }
    
    public void setmodelo (String modelo){
        this.modelo = modelo;
    } 
    public String getmodelo(){
        return modelo;
    }
    public void setano (int ano) {
        if (ano>=1900){
                this.ano = ano;}
        else{
            System.out.println("Ano incorreto");}
    }
    public int getano (){
        return ano;
}
    public void setvalorDiaria(int valorDiaria){
      if (valorDiaria>0) {
        this.valorDiaria = valorDiaria; }
    else {
        System.out.println("Você não tem valor a pagar");}
    }
    
    public int getvalorDiaria(){
        return valorDiaria; 
    }
    
    public int calcularAluguel(int dias){
        int aluguel = valorDiaria * dias;
        return aluguel;
    }
    
    public void exibirInformacoes(){
        System.out.println("O veículo abaixo foi brigado em nosso cadastro: \n Marca: " + marca + "\n Modelo: "+ modelo + "\n Ano: "+ ano);
    }
}
