/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transportadora;

/**
 *
 * @author otavio.accarmo
 */
public class Carro extends Veiculo{
    
    public Carro(String placa, String modelo, int ano, float capacidade, float km){
    }
    
    @Override
    public void calcularFrete(double distancia){
     double frete = 1 * distancia;
        System.out.println("Valor do frete: R$"+frete);
    }
}
