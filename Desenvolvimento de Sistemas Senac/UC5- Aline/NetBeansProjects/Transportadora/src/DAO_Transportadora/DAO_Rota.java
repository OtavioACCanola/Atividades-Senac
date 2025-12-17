package DAO_Transportadora;

import model_Transportadora.Rota;
import java.util.*;
import java.util.stream.Collectors;

public class DAO_Rota {
    
    private final List<Rota> Lista_Rota = new ArrayList<>();
    
    public DAO_Rota(){
    }
    
    public void Salvar_Rota(Rota Rota){
        Lista_Rota.add(Rota);
    }
    
    public List<Rota> Listar_Rota(){
        return new ArrayList(Lista_Rota);
    }
    
    public Optional<Rota> FindById(UUID IDRota){
        return Lista_Rota.stream().filter(Rota -> Rota.getId().equals(IDRota)).findFirst();
    }
}
