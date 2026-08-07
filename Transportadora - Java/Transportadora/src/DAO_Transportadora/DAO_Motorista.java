/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_Transportadora;

import model_Transportadora.Motorista;
import java.util.*;
import java.util.stream.Collectors;

public class DAO_Motorista {
    private final List<Motorista> lista_Motorista = new ArrayList();
    
    public DAO_Motorista(){
    }
    
    public void salvar_Motorista(Motorista motorista){
        lista_Motorista.add(motorista);
    }
    
    public List<Motorista> listar_Motorista(){
        return new ArrayList(lista_Motorista);
    }
    
    public Optional<Motorista> findById (UUID idm){
        return lista_Motorista.stream().filter(veiculo -> veiculo.getId().equals(idm)).findFirst(); // Opitinal: lista onde pode passar as informações vazias
    }
    
    public List<Motorista> findByTransportadora(UUID idt){
        return lista_Motorista.stream().filter(veiculo -> veiculo.getTransportadoraId().equals(idt)).collect(Collectors.toList());
    }
}
