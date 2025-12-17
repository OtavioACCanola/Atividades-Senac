

import java.util.*;
import java.util.stream.Collectors;
import model_Transportadora.Model_Transportadora;

public class DAO_Transportadora {
    private final List<Model_Transportadora> ListaTransportadora = new ArrayList<>();
    
    public void Salvar(Model_Transportadora Transportadora){
        ListaTransportadora.add(Transportadora);
    }
    
    public List<Model_Transportadora> ListarTransportadora(UUID idTransportadora){
        return new ArrayList(ListaTransportadora);
    }
    
    public List<Model_Transportadora> FindbyID(UUID IdTransportadora){
        return ListaTransportadora.stream().filter(Transportadora -> Transportadora.getId().equals(IdTransportadora)).collect(Collectors.toList());
    }
}
