/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package atividade_nivel_medio_transporte;

/**
 *
 * @author otavio.accarmo
 */
public class Atividade_Nivel_Medio_transporte {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Veiculo Tucson = new Carro ("FFS9163");
        Veiculo Caloi = new Bicicleta ("XVM-02");
        
        Tucson.mover();
        Caloi.mover();
    }
    
}
