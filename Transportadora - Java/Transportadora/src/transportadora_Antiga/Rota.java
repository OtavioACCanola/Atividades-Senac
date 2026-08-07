/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadora_Antiga;

/**
 *
 * @author otavio.accarmo
 */
public class Rota {
    private String origem;
    private String destino;
    private double distanciaKm;
    
    public double calculaTempoEstimado(double velocidade){
        double tempo = distanciaKm / velocidade;
        System.out.println("O tempo estimado é de: "+tempo);
        return tempo;
    }
}
