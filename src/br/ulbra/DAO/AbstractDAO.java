
package br.ulbra.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



  public abstract class AbstractDAO {
      private static final String DRIVER = "com.mysql.jdbc.Driver"; //Driver JDBC
    private static final String URL = "jdbc:mysql://localhost:3306/recipevault";
    private static final String USER = "root"; // seu usuário do MySQL
    private static final String PASSWORD = ""; // sua senha (ou "" se estiver vazia)

    // Método de conexão
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o banco de dados: " + e.getMessage());
        }
    }
}
  

