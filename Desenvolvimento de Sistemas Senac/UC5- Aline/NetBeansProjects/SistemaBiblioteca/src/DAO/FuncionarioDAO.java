/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import Connection.BConnection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Model.Gerente;

public class FuncionarioDAO {
    
     public void InserirFuncionario(String Nome, double Salario, String Cargo){
                
        try (Connection conn = BConnection.getConnection();
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
     
     public List<Gerente> listarFuncionarios(){
        String sql = "SELECT * FROM TBL_Funcionarios";
        List<Gerente> lista = new ArrayList<>();
        try (Connection conn = BConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
                            
                try (ResultSet rs = stmt.executeQuery()) {
            
                while (rs.next()) {
                    lista.add(new Gerente(
                        rs.getString("Nome"),
                        rs.getInt("Salario"),
                        rs.getString("Cargo")
                    ));
                }
            }
        }catch (SQLException e) {
                    System.out.println("Erro ao listar tabela: " + e.getMessage());
                    }
            return lista;
    }
}

