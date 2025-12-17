package com.mycompany.backup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
 
    public static Connection getConexao() throws SQLException{ // Esse método vai conectar com o banco que queremos
        
        final String SERVIDOR = "jdbc:sqlserver://127.0.0.1:1433;databaseName=MercadoLivre;encrypt=false;trustServerCertificate=true"; 
        // jdbc permite a conexao com o SQL Server, que é da Microsoft, banco_teste vai ser o nome do nosso database, a linha final é para deixar opcional
        final String USUARIO = "sa";
        final String SENHA = "pw_user_app";
        // Esse método passa todos os parâmetros para entrar no banco de dados do SQL Server
        return DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
    }
    
}
