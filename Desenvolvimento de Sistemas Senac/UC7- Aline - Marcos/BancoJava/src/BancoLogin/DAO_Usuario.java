// Classe que gere os Scripts do Banco, ou seja, Faz os Comandos de Banco (SELECT, INSERT, etc)

package BancoLogin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DAO_Usuario {
    
    public boolean Autenticar(String username, String senha){
        
        String sql = "SELECT * FROM Usuarios WHERE username = ? AND senha = ?";
        
        try (
            Connection conn = Factory_Connection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            return rs.next();
        }
        
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao Autenticar: " + e.getMessage());
            return false;
        }
    }
}
