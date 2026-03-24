/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.BibliotecaConnection;
import java.util.List;
import java.util.ArrayList;
import Model.Usuario;


public class UsuarioDAO {
    
    public void CriarUsuario(String Nome, int Idade) {
        
        try (Connection conn = BibliotecaConnection.getConnection();
                CallableStatement stmt = 
                        conn.prepareCall("{call sp_AdicionarUsuario(?, ?)}")) {
                        
                    stmt.setString(1, Nome);
                    stmt.setInt(2, Idade);
                    
                    stmt.execute();
                    
                    System.out.println("Usuario realizado com Sucesso!");
                    
        }catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public List<Usuario> listarUsuarios(){
        String sql = "SELECT Id, Nome, idade FROM TBL_Usuarios";
        List<Usuario>lista = new ArrayList<>();
        
        try (Connection conn = BibliotecaConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                lista.add(new Usuario(
                    rs.getInt("Id"),
                    rs.getString("Nome"),
                    rs.getInt("Idade")
                ));
            }
            
        }catch (SQLException e) {
                    System.out.println("Erro ao listar combo: " + e.getMessage());
                    }
            return lista;
    }
    
    
}

