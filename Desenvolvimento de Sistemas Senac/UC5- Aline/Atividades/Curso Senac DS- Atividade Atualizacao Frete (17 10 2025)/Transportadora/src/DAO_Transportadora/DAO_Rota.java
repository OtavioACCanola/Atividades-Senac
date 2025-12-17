package DAO_Transportadora;

import model_Transportadora.Model_Rota;
import java.util.*;
import java.util.stream.Collectors;

public class DAO_Rota {
    
    private final List<Model_Rota> Lista_Rota = new ArrayList<>();
    
    public DAO_Rota(Model_Rota rota){
    }
    
    public void Salvar_Rota(Model_Rota Rota){
        Lista_Rota.add(Rota);
    }
    
    public List<Model_Rota> Listar_Rota(){
        return new ArrayList(Lista_Rota);
    }
    
    public Optional<Model_Rota> FindById(UUID IDRota){
        return Lista_Rota.stream().filter(Rota -> Rota.getId().equals(IDRota)).findFirst();
    }
}
