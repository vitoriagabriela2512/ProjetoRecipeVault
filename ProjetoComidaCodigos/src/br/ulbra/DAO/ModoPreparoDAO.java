/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.DAO;

import br.ulbra.Model.ModoPreparo;
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
public class ModoPreparoDAO {
   private Connection connection;

    public ModoPreparoDAO(Connection connection) {
        this.connection = connection;
    }

    public ModoPreparoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Salvar novo modo de preparo
    public void salvar(ModoPreparo modoPreparo) throws SQLException {
        String sql = "INSERT INTO modo_preparo (id_receita, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, modoPreparo.getIdReceita());
            stmt.setString(2, modoPreparo.getDescricao());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    modoPreparo.setId(rs.getLong(1));
                }
            }
        }
    }

    // Atualizar modo de preparo existente
    public void atualizar(ModoPreparo modoPreparo) throws SQLException {
        String sql = "UPDATE modo_preparo SET id_receita = ?, descricao = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, modoPreparo.getIdReceita());
            stmt.setString(2, modoPreparo.getDescricao());
            stmt.setLong(3, modoPreparo.getId());
            stmt.executeUpdate();
        }
    }

    // Buscar por ID
    public ModoPreparo buscarPorId(Long id) throws SQLException {
        String sql = "SELECT * FROM modo_preparo WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ModoPreparo mp = new ModoPreparo();
                    mp.setId(rs.getLong("id"));
                    mp.setIdReceita(rs.getLong("id_receita"));
                    mp.setDescricao(rs.getString("descricao"));
                    return mp;
                }
            }
        }
        return null;
    }

    // Buscar modo de preparo por ID da receita
    public ModoPreparo buscarPorReceita(Long idReceita) throws SQLException {
        String sql = "SELECT * FROM modo_preparo WHERE id_receita = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, idReceita);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    ModoPreparo mp = new ModoPreparo();
                    mp.setId(rs.getLong("id"));
                    mp.setIdReceita(rs.getLong("id_receita"));
                    mp.setDescricao(rs.getString("descricao"));
                    return mp;
                }
            }
        }
        return null; // ou lançar exceção se for obrigatório
    }

    // Listar todos os modos de preparo
    public List<ModoPreparo> listarTodos() throws SQLException {
        List<ModoPreparo> modos = new ArrayList<>();
        String sql = "SELECT * FROM modo_preparo";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ModoPreparo mp = new ModoPreparo();
                mp.setId(rs.getLong("id"));
                mp.setIdReceita(rs.getLong("id_receita"));
                mp.setDescricao(rs.getString("descricao"));
                modos.add(mp);
            }
        }
        return modos;
    }

    // Deletar por ID
    public void deletar(Long id) throws SQLException {
        String sql = "DELETE FROM modo_preparo WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }

    // Deletar por ID da receita (útil ao excluir uma receita)
    public void deletarPorReceita(Long idReceita) throws SQLException {
        String sql = "DELETE FROM modo_preparo WHERE id_receita = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, idReceita);
            stmt.executeUpdate();
        }
    }

    public void adicionar(ModoPreparo passo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<ModoPreparo> buscarPorReceita(int receitaId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ModoPreparo buscarPorId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
}
