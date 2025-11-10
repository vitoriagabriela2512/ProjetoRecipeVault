/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.DAO;

import br.ulbra.Model.Utensilio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno.saolucas
 */
public class ReceitaUtensílioDAO {
    private Connection connection;

  
    

    // Salvar novo utensílio
    public void salvar(Utensilio utensilio) throws SQLException {
        String sql = "INSERT INTO utensilio (nome, tipo, material) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, utensilio.getNome());
            stmt.setString(2, utensilio.getTipo());
            stmt.setString(3, utensilio.getMaterial());
            stmt.executeUpdate();

            // Recuperar o ID gerado
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    utensilio.setId(rs.getLong(1));
                }
            }
        }
    }

    // Atualizar utensílio existente
    public void atualizar(Utensilio utensilio) throws SQLException {
        String sql = "UPDATE utensilio SET nome = ?, tipo = ?, material = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, utensilio.getNome());
            stmt.setString(2, utensilio.getTipo());
            stmt.setString(3, utensilio.getMaterial());
            stmt.setLong(4, utensilio.getId());
            stmt.executeUpdate();
        }
    }

    // Buscar por ID
    public Utensilio buscarPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM utensilio WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Utensilio u = new Utensilio();
                    u.setId(rs.getLong("id"));
                    u.setNome(rs.getString("nome"));
                    u.setTipo(rs.getString("tipo"));
                    u.setMaterial(rs.getString("material"));
                    return u;
                }
            }
        }
        return null;
    }

    // Listar todos os utensílios
    public List<Utensilio> listarTodos() throws SQLException {
        List<Utensilio> utensilios = new ArrayList<>();
        String sql = "SELECT * FROM utensilio";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Utensilio u = new Utensilio();
                u.setId(rs.getLong("id"));
                u.setNome(rs.getString("nome"));
                u.setTipo(rs.getString("tipo"));
                u.setMaterial(rs.getString("material"));
                utensilios.add(u);
            }
        }
        return utensilios;
    }

    // Deletar por ID
    public void deletar(Long id) throws SQLException {
        String sql = "DELETE FROM utensilio WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    
    
    
    
}
