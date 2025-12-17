/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory_Transportadora;

import model_Transportadora.*;
import java.util.UUID;

public class Factory_Veiculo {
    
    public static Model_Veiculo criar(Model_TipoVeiculo tipo, UUID transportadoraID, String placa, String modelo){
        switch(tipo){
            case MOTO:
                return new Model_Moto(transportadoraID, placa, modelo);
            case CARRO:
                return new Model_Carro(transportadoraID, placa, modelo);
            case CAMINHAO:
                return new Model_Caminhao(transportadoraID, placa, modelo);
            default:
                throw new IllegalArgumentException("Tipo Inválido!");
        }
    }
}
