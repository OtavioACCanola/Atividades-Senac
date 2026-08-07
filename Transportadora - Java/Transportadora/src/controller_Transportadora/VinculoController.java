/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_Transportadora;

import DAO_Transportadora.*;
import java.util.*;
import exception_Transportadora.Exception_RegraNegocio;
import java.util.stream.Collectors;
import model_Transportadora.*;

public class VinculoController {
    private final DAO_Motorista dao_motorista;
    private final DAO_Transportadora dao_transportadora;
    private final DAO_Veiculo dao_veiculo;
    private final DAO_MotoristaVeiculo dao_link;

    public VinculoController(DAO_MotoristaVeiculo l, DAO_Motorista m, DAO_Veiculo v, DAO_Transportadora t){
        this.dao_motorista = m;
        this.dao_link = l;
        this.dao_transportadora = t;
        this.dao_veiculo = v;
    }
    
    public void vincular(UUID motoristaId, UUID veiculoId){
        var mot = dao_motorista.findById(motoristaId).orElseThrow(() -> new Exception_RegraNegocio("Motorista não Encontrado!"));
        var vei = dao_veiculo.findById(veiculoId).orElseThrow(() -> new Exception_RegraNegocio("Veiculo não Encontrado!"));
        if (!mot.getTransportadoraId().equals(vei.getTransportadoraId())){
            throw new Exception_RegraNegocio("Motorista e Veículo devem ser da Mesma Transportadora");
        }
        if(dao_link.exists(motoristaId, veiculoId)){
            throw new Exception_RegraNegocio("Vínculo já Existe!");
        }
        dao_link.Salvar_LinkMotoristaVeiculo(new MotoristaVeiculoLink(motoristaId, veiculoId));
    }
    
    public List<Veiculo> listarVeiculosdoMotorista(UUID motoristaId){
        var links = dao_link.FindByotorista(motoristaId);
        var ids = links.stream().map(MotoristaVeiculoLink::getVeiculoId).collect(Collectors.toSet());
        return dao_veiculo.listar_Veiculos().stream().filter(v -> ids.contains(v.getId())).collect(Collectors.toList());
    }
}
