/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import Connection.BibliotecaConnection;
import java.util.*;
import Model.Gerente;

public class FuncionarioDAO {
    
    public void InserirBibliotecario(String Nome, double Salario, String Cargo){
                
        try (Connection conn = BibliotecaConnection.getConnection();
                CallableStatement stmt = 
                        conn.prepareCall("{Call sp_AdicionarFuncionario(?, ?, ?)}")) {
            
                stmt.setString(1, Nome);
                stmt.setDouble(2, Salario);
                stmt.setString(3, Cargo);
                
                stmt.execute();
                
        }catch (Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
    
     public void InserirGerente(String Nome, double Salario, String Cargo){
                
        try (Connection conn = BibliotecaConnection.getConnection();
                CallableStatement stmt = 
                        conn.prepareCall("{Call sp_AdicionarFuncionario(?, ?, ?)}")) {
            
                stmt.setString(1, Nome);
                stmt.setDouble(2, Salario);
                stmt.setString(3, Cargo);
                
                stmt.execute();
                
        }catch (Exception e){
            System.out.println("Erro: "+ e.getMessage());
        }
    }
}
