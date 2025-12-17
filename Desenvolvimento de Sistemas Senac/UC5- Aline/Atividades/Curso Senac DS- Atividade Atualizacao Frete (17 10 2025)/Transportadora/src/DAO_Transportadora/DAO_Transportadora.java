/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO_Transportadora;

import model_Transportadora.Model_Transportadora;
import java.util.*;
import java.util.stream.Collectors;

public class DAO_Transportadora {
    private final List<Model_Transportadora> lista_Transportadora = new ArrayList();
    
    public DAO_Transportadora(){
    }
    
    public void salvar_Transportadora(Model_Transportadora transportadora){
        lista_Transportadora.add(transportadora);
    }
    
    public List<Model_Transportadora> listar_Transportadora(){
        return lista_Transportadora;
    }
    
    public List<Model_Transportadora> findById(UUID idt){
        return lista_Transportadora.stream().filter(transportadora -> transportadora.getId().equals(idt)).collect(Collectors.toList());
    }
}
