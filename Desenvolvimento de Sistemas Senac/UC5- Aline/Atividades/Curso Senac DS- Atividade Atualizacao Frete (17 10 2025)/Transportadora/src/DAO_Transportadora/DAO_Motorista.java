/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_Transportadora;

import model_Transportadora.Model_Motorista;
import java.util.*;
import java.util.stream.Collectors;

public class DAO_Motorista {
    private final List<Model_Motorista> lista_Motorista = new ArrayList();
    
    public DAO_Motorista(Model_Motorista motorista){
    }
    
    public void salvar_Motorista(Model_Motorista motorista){
        lista_Motorista.add(motorista);
    }
    
    public List<Model_Motorista> listar_Motorista(){
        return new ArrayList(lista_Motorista);
    }
    
    public Optional<Model_Motorista> findById (UUID idm){
        return lista_Motorista.stream().filter(veiculo -> veiculo.getId().equals(idm)).findFirst(); // Opitinal: lista onde pode passar as informações vazias
    }
    
    public List<Model_Motorista> findByTransportadora(UUID idt){
        return lista_Motorista.stream().filter(veiculo -> veiculo.getTransportadoraId().equals(idt)).collect(Collectors.toList());
    }
}
