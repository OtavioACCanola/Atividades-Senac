/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package localiza.veiculos.atividade.geral;

/**
 *
 * @author otavio.accarmo
 */
public class Veículo {
    private String marca;
    private String modelo;
    private int ano;
    private float valorDiaria;
    
    public Veículo(String marca, String modelo, int ano, float valorDiaria) {
        setmarca (marca);
        setmodelo(modelo);
        setano(ano);
        setvalorDiaria(valorDiaria);
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
    public void setvalorDiaria(float valorDiaria){
      if (valorDiaria>0) {
        this.valorDiaria = valorDiaria; }
    else {
        System.out.println("Valor da diária precisa ser meior que 0");}
    }
    
    public float getvalorDiaria(){
        return valorDiaria;
    }
    
    public float calcularAluguel(int dias){
        float aluguel = valorDiaria * dias;
        return aluguel;
    }
    
    public void exibirAluguel(){
        System.out.println("O valor do alguguel é de: ");
    }
    // Podemos fazer assim
    public void exibirInformacoes(){
        System.out.println("O veículo abaixo foi brigado em nosso cadastro: \n Marca: " + marca + "\n Modelo: " + modelo + "\n Ano: " + ano + "\n Valor da Diária: " + valorDiaria);
    }
        /* Ou fazer assim
    public String exibir(){
        String dadosVeiculo = "Marca: " + marca + "\nModelo: " + modelo;
        return dadosVeiculo;
    } */
}


