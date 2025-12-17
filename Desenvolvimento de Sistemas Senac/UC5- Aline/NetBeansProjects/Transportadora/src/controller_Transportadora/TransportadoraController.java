package controller_Transportadora;

import DAO_Transportadora.DAO_Transportadora;
import exception_Transportadora.Exception_RegraNegocio;
import model_Transportadora.*;
import java.util.*;

public class TransportadoraController {
    
    private DAO_Transportadora dao_transportadora;
    
    public TransportadoraController(DAO_Transportadora t){
        this.dao_transportadora = t;
    }
    
    public void Cadastrar(String razao, String cnpj, String endereco){
        if (Validators.isBlank(cnpj) || Validators.isBlank(razao)){
            throw new Exception_RegraNegocio("Razão e CNPJ são Obrigatórios");
        }
        if (Validators.cnpjValido(cnpj)){
            throw new Exception_RegraNegocio("CNPJ Inválido!");
        }
        dao_transportadora.salvar_Transportadora(new Transportadora(razao, cnpj, endereco));
    }
    
    public List<Transportadora> Listar(){
        return dao_transportadora.listar_Transportadora();
    }
}
