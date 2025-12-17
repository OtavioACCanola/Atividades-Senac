

import model_Transportadora.Model_Motorista;
import java.util.*;
import java.time.*;
import java.util.stream.Collectors;

public class DAO_Motorista {
    
    
    private final List<Model_Motorista> lista_Motorista = new ArrayList();
    
    public void salvar_Motorista(Model_Motorista motorista){
        lista_Motorista.add(motorista);
    }
    
    public List<Model_Motorista> listar_Motorista(){
        return new ArrayList(lista_Motorista);   
    }
    
    public Optional<Model_Motorista> findById (UUID id){
    return lista_Motorista.stream().filter(motorista -> motorista.getId().equals(id)).findFirst(); // Opitinal: lista onde pode passar as informações vazias
    }
    public List<Model_Motorista> findByTransportadora(UUID idt){
        return lista_Motorista.stream().filter(motorista -> motorista.getTransportadoraId().equals(idt)).collect(Collectors.toList());
    }
}


