/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade_nivel_dificil_entregas;

/**
 *
 * @author Dell
 */
abstract class Entregador implements Pagamento{
    private String nome;
    private float valorEntrega;
    
    public Entregador (String nome, float valorEntrega){
        this.nome = nome;
        this.valorEntrega = valorEntrega;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorEntrega() {
        return valorEntrega;
    }

    public void setValorEntrega(float valorEntrega) {
        this.valorEntrega = valorEntrega;
    }
    
    abstract void calcularTaxas();
    
    public void mostrarDados(){
        System.out.println("Informações do Entregador: \nNome: "+getNome()+" \nValor da Entrega: "+getValorEntrega());   
    }
}
