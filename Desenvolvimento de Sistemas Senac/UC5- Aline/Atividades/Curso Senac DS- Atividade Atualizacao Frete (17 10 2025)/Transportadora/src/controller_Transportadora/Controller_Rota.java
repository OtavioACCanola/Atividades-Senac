/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller_Transportadora;

import java.util.*;
import model_Transportadora.*;
import DAO_Transportadora.*;
import exception_Transportadora.Exception_RegraNegocio;

public class Controller_Rota {
    
    private final DAO_Rota dao_rota;
    
    public Controller_Rota(DAO_Rota rota){
        this.dao_rota = rota;
    }
    
    public void Cadastrar(String origem, String destino, double distanciaKm){
        if (Validators.isBlank(origem) || Validators.isBlank(destino) || distanciaKm <= 0){
            throw new Exception_RegraNegocio("Origem, destino e distância > 0 são obrigatórios!");
        }
        dao_rota.Salvar_Rota(new Model_Rota(origem, destino, distanciaKm));
    }
    
    public List<Model_Rota> listar(){
        return dao_rota.Listar_Rota();
    }
}
