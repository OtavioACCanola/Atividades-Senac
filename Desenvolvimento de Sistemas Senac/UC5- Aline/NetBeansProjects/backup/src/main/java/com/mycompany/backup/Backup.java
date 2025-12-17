package com.mycompany.backup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Backup {

    public void fazerBackup() throws SQLException{
        
        String sql = "EXEC sp_FazerBackup";
        
        try (
            // Criar uma conexçao com o Banco de Dados
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = con.prepareStatement(sql); 
        ){
                stmt.executeUpdate();
        }
        
    }
    
}
