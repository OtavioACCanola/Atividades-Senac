/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package DAO;

import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import java.sql.SQLException;
import Connection.BConnection;
import Model.Emprestimo;

public class EmprestimoDAO {

    public void emprestar(int idUsuario, int idLivro) {
        
        try (Connection conn = BConnection.getConnection();
                CallableStatement stmt = 
                        conn.prepareCall("{call sp_RealizarEmprestimo(?, ?)}")) {
                        
                    stmt.setInt(1, idUsuario);
                    stmt.setInt(2, idLivro);
                    
                    stmt.execute();
                    
                    System.out.println("Empréstimo realizado com Sucesso!");
                    
        }catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public void devolver(int idUsuario, int idLivro) {
        try (Connection conn = BConnection.getConnection();
                CallableStatement stmt = 
                        conn.prepareCall("{call sp_DevolverLivro(?, ?)}")){
            
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idLivro);
            
            stmt.execute();
            
            System.out.println("Devolução Realizada com Sucesso!");
            
        }catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            
        }
    }
    
     public List<Emprestimo> listarEmprestimos(int id){
        String sql = "SELECT e.Id, l.Titulo, u.Nome, e.DataEmprestimo, e.Situacao FROM dbo.TBL_Emprestimos e INNER JOIN TBL_Livros l ON e.LivroId = l.Id INNER JOIN TBL_Usuarios u ON e.IdUsuario = u.Id WHERE e.Situacao = 'Emprestado' AND u.Id = ?";
        List<Emprestimo> lista = new ArrayList<>();
        try (Connection conn = BConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)){
            
                stmt.setInt(1, id);
                
                try (ResultSet rs = stmt.executeQuery()) {
            
                while (rs.next()) {
                    lista.add(new Emprestimo(
                        rs.getInt("Id"),
                        rs.getString("Nome"),
                        rs.getString("Titulo"),
                        rs.getString("DataEmprestimo"),
                        rs.getString("Situacao")
                    ));
                }
            }
        }catch (SQLException e) {
                    System.out.println("Erro ao listar tabela: " + e.getMessage());
                    }
            return lista;
        }
     
        
}
