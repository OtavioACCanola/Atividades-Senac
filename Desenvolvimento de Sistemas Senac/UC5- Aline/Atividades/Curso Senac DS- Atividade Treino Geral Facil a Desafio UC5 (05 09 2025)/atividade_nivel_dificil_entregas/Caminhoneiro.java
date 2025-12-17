/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade_nivel_dificil_entregas;

/**
 *
 * @author Dell
 */
public class Caminhoneiro extends Entregador{
    
    public Caminhoneiro (String nome, float valorEntrega){
        super(nome, valorEntrega);
    }
    
    @Override
    public void calcularTaxas(){
        double taxa = (getValorEntrega() * 0.15) + getValorEntrega();
        System.out.println("Novo valor da entrega com a taxa: " +taxa);
    }
    
    @Override
    public void processarPagamento(double valor){
        System.out.println(getNome() + " recebeu seu salário de R$ " +valor);
    }

}
