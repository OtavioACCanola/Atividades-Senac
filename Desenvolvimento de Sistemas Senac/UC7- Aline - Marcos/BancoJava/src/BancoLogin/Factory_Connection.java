// Classe que Faz a Conxão com o Banco

package BancoLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory_Connection {
    
    private static final String URL 
            = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=JavaBanco;"
            + "integratedSecurity=true;"
            + "encrypt=false;"
            + "trustServerCertificate=true;";
    
    private static final String USER = "";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } 
        catch (SQLException e){
            throw new RuntimeException("Erro de Conexão: " + e.getMessage());   
        }
    }
}
