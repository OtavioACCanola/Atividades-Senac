/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atividade_nivel_medio_transporte;

/**
 *
 * @author otavio.accarmo
 */
public class Bicicleta extends Veiculo{
    
    public Bicicleta (String placa){
        super (placa);
    }
    
    @Override
    public void mover(){
        System.out.println("A bicicleta está a ser pedalada!");
    }
}
