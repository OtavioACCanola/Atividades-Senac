package DAO_Transportadora;

import java.util.*;
import model_Transportadora.Veiculo;
import java.util.stream.Collectors;

public class DAO_Veiculo {
    
    private final List<Veiculo> lista_Veiculos = new ArrayList<>();
    
    public void salvar_Veiculo(Veiculo veiculo){
        lista_Veiculos.add(veiculo);
    }
    
    public List<Veiculo> listar_Veiculos(){
        return new ArrayList(lista_Veiculos);   
    }
    
    public Optional<Veiculo> findById (UUID id){
        return lista_Veiculos.stream().filter(veiculo -> veiculo.getId().equals(id)).findFirst(); // Opitinal: lista onde pode passar as informações vazias
    }
    public List<Veiculo> findByTransportadora(UUID idt){
        return lista_Veiculos.stream().filter(veiculo -> veiculo.getTransportadoraId().equals(idt)).collect(Collectors.toList());
    }
    
}
