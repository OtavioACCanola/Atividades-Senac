/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_Transportadora;

import java.util.UUID;
import DAO_Transportadora.DAO_Motorista;
import DAO_Transportadora.DAO_Transportadora;
import model_Transportadora.Motorista;
import exception_Transportadora.Exception_RegraNegocio;
import java.util.*;


public class MotoristaController {
   
    private final DAO_Motorista dao;
    private final DAO_Transportadora transportadoraDAO;
    
    public MotoristaController(DAO_Motorista d, DAO_Transportadora t){
        this.dao = d;
        this.transportadoraDAO = t;
    }
    
    public void cadastrar(UUID transportadoraId, String nome, String cpf, String cnh, String tel){
        if (transportadoraId == null || Validators.isBlank(nome) || Validators.isBlank(cpf) || Validators.isBlank(cnh)){
            throw new Exception_RegraNegocio("Transportadora, Nome, CPF ou CNH são Obrigatórios");
        }
        
        if (!Validators.cpfValido(cpf)){
            throw new Exception_RegraNegocio("CPF Invalido");
        }
        boolean existe = transportadoraDAO.listar_Transportadora().stream().anyMatch(x -> x.getId().equals(transportadoraId));
        if(existe){
            throw new Exception_RegraNegocio("Trnasportadora Inexistente");
        }
        dao.salvar_Motorista(new Motorista(transportadoraId, nome, cpf, cnh, tel));
    }
    
    public List<Motorista> listar(){
        return dao.listar_Motorista();
    }
    
    public List<Motorista> listarPorTransportadora(UUID transportadora){
        return dao.findByTransportadora(transportadora);
    }
}
