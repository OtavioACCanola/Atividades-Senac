/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_Transportadora;

import DAO_Transportadora.*;
import model_Transportadora.*;
import java.util.*;
import java.time.*;
import java.util.stream.Collectors;
import java.util.UUID;

public class Controller_Relatorio {
    private final DAO_Frete dao_frete;
    private final DAO_Transportadora dao_transportadora;
    private final DAO_Motorista dao_motorista;
    private final DAO_Veiculo dao_veiculo;
    
    public Controller_Relatorio(DAO_Frete frete, DAO_Motorista motorista, DAO_Veiculo veiculo, DAO_Transportadora transportadora){
        this.dao_frete = frete;
        this.dao_motorista = motorista;
        this.dao_transportadora = transportadora;
        this.dao_veiculo = veiculo;
    } 
    
    public List<Model_Frete> fretesDia(LocalDate dia){
        return dao_frete.findByPeriod(dia, dia);
    }
    
    public List<Model_Frete> fretesMes(YearMonth am){
        return dao_frete.findByPeriod(am.atDay(1), am.atEndOfMonth());   
    }
    
    public List<Model_Frete> fretesPeriodo(LocalDate ini, LocalDate fim){
        return dao_frete.findByPeriod(ini, fim);
    }
    
    public Map<String, Double> consolidarPorMotorista(List<Model_Frete> fretes){
        Map<UUID, String> nomes = dao_motorista.listar_Motorista().stream().collect(Collectors.toMap(Model_Motorista::getId, Model_Motorista::getNome));
        return fretes.stream().collect(Collectors.groupingBy(f -> nomes.getOrDefault(f.getMotoristaId(), "(?)"), Collectors.summingDouble(Model_Frete::getValor)));   
    }
    
     public Map<String, Double> consolidarPorVeiculo(List<Model_Frete> fretes) {
        Map<UUID, String> vv = dao_veiculo.listar_Veiculos().stream().collect(Collectors.toMap(Model_Veiculo::getId, v -> v.getTipo() + "/" + v.getPlaca()));
        return fretes.stream().collect(Collectors.groupingBy(f -> vv.getOrDefault(f.getVeiculoId(), "(?)"), Collectors.summingDouble(Model_Frete::getValor)));
    }
     
    public Map<String, Double> consolidarPorTransportadora(List<Model_Frete> fretes) {
       Map<UUID, String> tt = dao_transportadora.listar_Transportadora().stream().collect(Collectors.toMap(Model_Transportadora::getId, Model_Transportadora::getRazaoSocial));
       return fretes.stream().collect(Collectors.groupingBy(f -> tt.getOrDefault(f.getId(), "(?)"), Collectors.summingDouble(Model_Frete::getValor)));
    }
     
     
    
    
}
