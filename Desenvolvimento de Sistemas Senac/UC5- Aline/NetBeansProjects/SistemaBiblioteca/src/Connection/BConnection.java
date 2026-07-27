/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BConnection {
    
    private static final String URL 
            = "jdbc:sqlserver://DESKTOP-FIQ0BGR\\SQLEXPRESS;"
            + ";databaseName=Transactions"
            + ";integratedSecurity=true"
            + ";encrypt=true"
            + ";trustServerCertificate=true";
    
    private static final String USER = "";
    private static final String PASSWORD = "";
    
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e){
            throw new RuntimeException("Erro de Conexão: " + e.getMessage());            
        }
      
    }
}
