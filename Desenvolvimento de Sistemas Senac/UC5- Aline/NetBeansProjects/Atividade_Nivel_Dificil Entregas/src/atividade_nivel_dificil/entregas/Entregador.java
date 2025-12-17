/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade_nivel_dificil.entregas;

/**
 *
 * @author otavio.accarmo
 */
abstract class Entregador implements Pagamento {
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
    
    abstract double calcularTaxas();
    
    public void mostrarDados(){
        System.out.println("Dados do Entregador:\nNome: " + nome + "\nValorEntrega: " + valorEntrega);
    }
    
    @Override
    public Double processarPagamento(double valor){
        System.out.println("qualquer coisa");
        return 3.0;
    }

}
