/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade_nivel_medio_transporte;

/**
 *
 * @author otavio.accarmo
 */
public class Carro extends Veiculo{
    
    public Carro(String placa){
        super(placa);
    }
    
    @Override
    public void mover(){
        System.out.println("O carro está sendo dirigido!");
    }
}
