/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_Transportadora;

import java.util.*;
import DAO_Transportadora.*;
import model_Transportadora.*;
import strategy_Transportadora.*;
import exception_Transportadora.*;
import java.time.LocalDateTime;


public class Controller_Frete {
    private final DAO_Frete daofrete;
    private final DAO_Rota daoRota;
    private final DAO_Veiculo daoVeiculo;
    private final Strategy_CalculadoraFreteTipo calculadoraFrete;
    
    public Controller_Frete(DAO_Frete frete, DAO_Veiculo veiculo, DAO_Rota rota, Strategy_CalculadoraFreteTipo calculadoraFrete){
        this.daofrete = frete;
        this.daoRota = rota;
        this.daoVeiculo = veiculo;
        this.calculadoraFrete = calculadoraFrete;
        
    }
    
    public double calcularValor(UUID veiculoId, UUID rotaId){
        var veiculo = daoVeiculo.findById(veiculoId).orElseThrow(() -> new Exception_RegraNegocio("Veiculo não Encontrado"));
        var rota = daoRota.FindById(rotaId).orElseThrow(() -> new Exception_RegraNegocio("Rota não Encontrada")); 
        return calculadoraFrete.calcular(veiculo, rota);
    }
    
    public void registrarFrete(UUID transportadoraId, UUID motoristaId, UUID veiculoId, UUID rotaId){
        double valor = calcularValor(veiculoId, rotaId);
        daofrete.salvar_Frete(new Model_Frete(transportadoraId, motoristaId, veiculoId, rotaId, LocalDateTime.now(), valor));
    }
}
