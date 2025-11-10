package br.ulbra.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public abstract class abstractDAO {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // Versão mais recente do driver
    private static final String URL = "jdbc:mysql://localhost:3306/crudgamevault?useSSL=false&serverTimezone=UTC"; // Corrigido e com parâmetros úteis
    private static final String USER = "root";
    private static final String PASSWORD = ""; // senha vazia (remova o espaço)

    /**
     * Estabelece e retorna uma conexão com o banco de dados.
     * 
     * @return Connection válida com o banco de dados
     * @throws SQLException se ocorrer erro na conexão
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Opcional desde JDBC 4.0, mas mantido para compatibilidade com versões antigas
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            String msg = "Driver do MySQL não encontrado: " + e.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Erro de Configuração", JOptionPane.ERROR_MESSAGE);
            throw new SQLException(msg, e);
        }

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            String msg = "Falha ao conectar ao banco de dados:\n" + e.getMessage();
            JOptionPane.showMessageDialog(null, msg, "Erro de Conexão", JOptionPane.ERROR_MESSAGE);
            throw e; // Relança a exceção para que o chamador trate adequadamente
        }
    }
}