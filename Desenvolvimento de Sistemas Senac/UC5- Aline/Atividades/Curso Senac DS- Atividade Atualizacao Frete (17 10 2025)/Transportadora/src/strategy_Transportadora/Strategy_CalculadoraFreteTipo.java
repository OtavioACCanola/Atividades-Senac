/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy_Transportadora;

import model_Transportadora.*;

public class Strategy_CalculadoraFreteTipo implements Strategy_CalculadoraFrete{

    @Override
    public double calcular(Model_Veiculo v, Model_Rota r){
        return v.getTipo().getCustoPorKm() * r.getDistanciaKm();
    }
}
