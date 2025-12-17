/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_Transportadora;

import DAO_Transportadora.*;
import model_Transportadora.*;
import exception_Transportadora.Exception_RegraNegocio;
import factory_Transportadora.Factory_Veiculo;
import java.util.*;

public class VeiculoController {
    
    private final DAO_Veiculo dao_veiculo;
    private final DAO_Transportadora dao_transportadora;
    
    public VeiculoController(DAO_Veiculo v, DAO_Transportadora t){
        this.dao_veiculo = v;
        this.dao_transportadora = t;
    }
    
    public void Cadastrar(UUID transportadoraId, TipoVeiculo tipo, String placa, String modelo){
        if (transportadoraId == null || tipo == null || Validators.isBlank(placa)){
            throw new Exception_RegraNegocio("Transportadora, Tipo e Placa são Obrigatórios!");
        }
        boolean existe = dao_transportadora.listar_Transportadora().stream().anyMatch(x -> x.getId().equals(transportadoraId));
        if (!existe){
            throw new Exception_RegraNegocio("Transportadora, tipo e placa são Obrigatórios!");
        }
        Veiculo v = Factory_Veiculo.criar(tipo, transportadoraId, placa, modelo);
        dao_veiculo.salvar_Veiculo(v);
    }
    
    public List<Veiculo> listar(){
        return dao_veiculo.listar_Veiculos();
    }
    
    public List<Veiculo> listarPorTransportadora(UUID t){
        return dao_veiculo.findByTransportadora(t);
    }
}
