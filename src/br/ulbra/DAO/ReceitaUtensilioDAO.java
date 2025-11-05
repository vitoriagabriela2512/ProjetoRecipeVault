package br.ulbra.DAO;

import static br.ulbra.DAO.AbstractDAO.getConnection;
import br.ulbra.model.ReceitaUtensilio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaUtensilioDAO extends AbstractDAO implements InterfaceDAO {

    private Connection conn;

    public ReceitaUtensilioDAO(Connection conn) {
        this.conn = conn;
    }

    public ReceitaUtensilioDAO() {
        // Usa getConnection() herdado de abstractDAO
    }

    // ================================
    // MÉTODOS DA InterfaceDAO
    // ================================

    @Override
    public void adicionar(Object obj) throws SQLException {
        if (!(obj instanceof ReceitaUtensilio)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo ReceitaUtensilio.");
        }
        adicionar((ReceitaUtensilio) obj);
    }

    @Override
    public void editar(Object obj) throws SQLException {
        if (!(obj instanceof ReceitaUtensilio)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo ReceitaUtensilio.");
        }
        editar((ReceitaUtensilio) obj);
    }

    @Override
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM receitaUtensilio WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // ================================
    // MÉTODOS ESPECÍFICOS
    // ================================

    public void adicionar(ReceitaUtensilio ru) throws SQLException {
        // Evita duplicatas (opcional, mas recomendado)
        if (existeAssociacao(ru.getIdReceita(), ru.getIdUtensilio())) {
            return; // ou lançar exceção, se preferir
        }

        String sql = "INSERT INTO receitaUtensilio (idReceita, idUtensilio) VALUES (?, ?)";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, ru.getIdReceita());
            stmt.setInt(2, ru.getIdUtensilio());
            stmt.executeUpdate();

            // Recupera o ID gerado (se necessário)
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    ru.setId(rs.getInt(1));
                }
            }
        }
    }

    public void editar(ReceitaUtensilio ru) throws SQLException {
        String sql = "UPDATE receitaUtensilio SET idReceita = ?, idUtensilio = ? WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, ru.getIdReceita());
            stmt.setInt(2, ru.getIdUtensilio());
            stmt.setInt(3, ru.getId());
            stmt.executeUpdate();
        }
    }

    public ReceitaUtensilio buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM receitaUtensilio WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ReceitaUtensilio ru = new ReceitaUtensilio();
                ru.setId(rs.getInt("id"));
                ru.setIdReceita(rs.getInt("idReceita"));
                ru.setIdUtensilio(rs.getInt("idUtensilio"));
                return ru;
            }
        }
        return null;
    }

    public List<ReceitaUtensilio> listar() throws SQLException {
        List<ReceitaUtensilio> lista = new ArrayList<>();
        String sql = "SELECT * FROM receitaUtensilio";
        try (Connection con = conn != null ? conn : getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ReceitaUtensilio ru = new ReceitaUtensilio();
                ru.setId(rs.getInt("id"));
                ru.setIdReceita(rs.getInt("idReceita"));
                ru.setIdUtensilio(rs.getInt("idUtensilio"));
                lista.add(ru);
            }
        }
        return lista;
    }

    // ================================
    // MÉTODO ÚTIL: buscar utensílios por receita
    // ================================

    public List<ReceitaUtensilio> buscarPorReceita(int idReceita) throws SQLException {
        List<ReceitaUtensilio> lista = new ArrayList<>();
        String sql = "SELECT * FROM receitaUtensilio WHERE idReceita = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idReceita);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ReceitaUtensilio ru = new ReceitaUtensilio();
                ru.setId(rs.getInt("id"));
                ru.setIdReceita(rs.getInt("idReceita"));
                ru.setIdUtensilio(rs.getInt("idUtensilio"));
                lista.add(ru);
            }
        }
        return lista;
    }

    // ================================
    // MÉTODO AUXILIAR: evitar duplicatas
    // ================================

    private boolean existeAssociacao(int idReceita, int idUtensilio) throws SQLException {
        String sql = "SELECT COUNT(*) FROM receitaUtensilio WHERE idReceita = ? AND idUtensilio = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idReceita);
            stmt.setInt(2, idUtensilio);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }
}
