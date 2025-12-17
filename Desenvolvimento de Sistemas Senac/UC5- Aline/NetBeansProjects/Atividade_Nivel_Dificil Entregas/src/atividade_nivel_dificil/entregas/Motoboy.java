/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade_nivel_dificil.entregas;

/**
 *
 * @author otavio.accarmo
 */
public class Motoboy extends Entregador{
    
    public Motoboy(String nome, float valorEntrega){
        super(nome, valorEntrega);
    
    @Override
    public double calcularTaxas(){
        double taxa = km * 6.80;
        double EntregaTotal = getValorEntrega() + taxa;
    }
    
    @Override
    public Double processarPagamento(double valor){

}
