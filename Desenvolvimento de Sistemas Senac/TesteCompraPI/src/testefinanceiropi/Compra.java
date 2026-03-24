package testefinanceiropi;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author otavio.accarmo
 */
public class Compra {
    private float valor;
    private String nome;
    private int quantidade;
    private float troco;
    
    public Compra(float valor, String nome, int quantidade){
        this.valor = valor;
        this.nome = nome;
        this.quantidade = quantidade;
    }
    
    public float getValor(){
        return valor;
}
    public void setVelor(float valor){
        this.valor = valor;
    }

    public float getTroco() {
        return troco;
    }

    public void setTroco(float troco) {
        this.troco = troco;
    }
    
    
    
    public void comprar(float dinheiro){
        if (dinheiro != valor){
            System.out.println("Dinheiro não foi suficiente, por favor complete o valor");
        }
        else if (dinheiro == valor){
            Financeiro financeiro = new Financeiro();
            System.out.println("Compra efetuada com sucesso");
            financeiro.computarValor(dinheiro);
        }
        else{
            troco = dinheiro - valor;
            System.out.println("Compra efetuada com sucesso, receba seu troco: "+ getTroco());
        }
    }
}
