package DAO_Transportadora;

import java.util.*;
import java.time.*;
import model_Transportadora.MotoristaVeiculoLink;
import java.util.stream.Collectors;


public class DAO_MotoristaVeiculo {
    private final List<MotoristaVeiculoLink> ListaMotoristaVeiculo = new ArrayList<>();
    
    public void Salvar_LinkMotoristaVeiculo(MotoristaVeiculoLink motorista){
        ListaMotoristaVeiculo.add(motorista);
    }
    
    public boolean exists(UUID motorista, UUID veiculo){
        return ListaMotoristaVeiculo.stream().anyMatch(x -> x.getMotoristaId().equals(motorista) && x.getVeiculoId().equals(veiculo)) ;
    }
    
    public List<MotoristaVeiculoLink> FindByotorista(UUID id){
        return ListaMotoristaVeiculo.stream().filter(motorista -> motorista.getMotoristaId().equals(id)).collect(Collectors.toList());
    }
}
