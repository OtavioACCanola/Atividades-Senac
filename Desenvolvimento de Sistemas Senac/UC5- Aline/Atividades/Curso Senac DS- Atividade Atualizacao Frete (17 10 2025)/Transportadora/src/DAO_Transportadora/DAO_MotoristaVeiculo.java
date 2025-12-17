package DAO_Transportadora;

import java.util.*;
import java.time.*;
import model_Transportadora.Model_MotoristaVeiculoLink;
import java.util.stream.Collectors;


public class DAO_MotoristaVeiculo {
    private final List<Model_MotoristaVeiculoLink> ListaMotoristaVeiculo = new ArrayList<>();
    
    public void Salvar_LinkMotoristaVeiculo(Model_MotoristaVeiculoLink motorista){
        ListaMotoristaVeiculo.add(motorista);
    }
    
    public boolean exists(UUID motorista, UUID veiculo){
        return ListaMotoristaVeiculo.stream().anyMatch(x -> x.getMotoristaId().equals(motorista) && x.getVeiculoId().equals(veiculo)) ;
    }
    
    public List<Model_MotoristaVeiculoLink> FindByotorista(UUID id){
        return ListaMotoristaVeiculo.stream().filter(motorista -> motorista.getMotoristaId().equals(id)).collect(Collectors.toList());
    }
}
