/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import Connection.BConnection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import View.*;
import Controller.LivroConn;
import Model.Emprestimo;
import Model.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    
    public void Inserir(String Titulo, String Autor, int Quantidade){
                
        try (Connection conn = BConnection.getConnection();
                CallableStatement stmt = 
                        conn.prepareCall("{Call sp_AdicionarLivro(?, ?, ?)}")) {
            
                stmt.setString(1, Titulo);
                stmt.setString(2, Autor);
                stmt.setInt(3, Quantidade);
                
                stmt.execute();
                
        }catch (Exception e){
            System.out.println("Erro: "+ e.getMessage());
    }
 }
    
    public List<Livro> listarLivroComboBox(){
        String sql = "SELECT id, Titulo, Autor, QuantidadeDisponivel FROM TBL_Livros";
        List<Livro> lista = new ArrayList<>();
        
        try (Connection conn = BConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                lista.add(new Livro(
                    rs.getInt("Id"),
                    rs.getString("Titulo"),
                    rs.getString("Autor"),
                    rs.getInt("QuantidadeDisponivel")
                ));
            }
            
        }catch (SQLException e) {
                    System.out.println("Erro ao listar combo: " + e.getMessage());
                    }
            return lista;
    }
    
    public List<Livro> popularTabela(){
         String sql = "SELECT * FROM TBL_Livros";
        List<Livro> lista = new ArrayList<>();
        try (Connection conn = BConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
                
                try (ResultSet rs = stmt.executeQuery()) {
            
                while (rs.next()) {
                    lista.add(new Livro(
                        rs.getInt("Id"),
                        rs.getString("Titulo"),
                        rs.getString("Autor"),
                        rs.getInt("QuantidadeDisponivel")
                    ));
                }
            }
        }catch (SQLException e) {
                    System.out.println("Erro ao listar tabela: " + e.getMessage());
                    }
            return lista;
    }
}
