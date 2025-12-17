/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadora_Antiga;

/**
 *
 * @author otavio.accarmo
 */
public class Caminhao extends Veiculo{
 
    public Caminhao(String placa, String modelo, int ano, float capacidade, float km){
    }
    
    @Override
    public void calcularFrete(double distancia){
     double frete = 2.50 * distancia;
        System.out.println("Valor do frete: R$"+frete);
    }
}
