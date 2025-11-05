package br.ulbra.DAO;

import br.ulbra.model.Utensilio;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UtensilioDAO extends AbstractDAO implements InterfaceDAO {

    private Connection conn;

    public UtensilioDAO(Connection conn) {
        this.conn = conn;
    }

    public UtensilioDAO() {
        // Usa getConnection() herdado de abstractDAO
    }

    // ================================
    // MÉTODOS DA InterfaceDAO
    // ================================

    @Override
    public void adicionar(Object obj) throws SQLException {
        if (!(obj instanceof Utensilio)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo Utensilio.");
        }
        adicionar((Utensilio) obj);
    }

    @Override
    public void editar(Object obj) throws SQLException {
        if (!(obj instanceof Utensilio)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo Utensilio.");
        }
        editar((Utensilio) obj);
    }

    @Override
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM utensilio WHERE idUtensilio = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // ================================
    // MÉTODOS ESPECÍFICOS
    // ================================

    public void adicionar(Utensilio u) throws SQLException {
        String sql = "INSERT INTO utensilio (nome) VALUES (?)";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, u.getNome());
            stmt.executeUpdate();

            // Recupera o ID gerado (caso AUTO_INCREMENT)
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    u.setIdUtensilio(rs.getInt(1));
                }
            }
        }
    }

    public void editar(Utensilio u) throws SQLException {
        String sql = "UPDATE utensilio SET nome = ? WHERE idUtensilio = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, u.getNome());
            stmt.setInt(2, u.getIdUtensilio());
            stmt.executeUpdate();
        }
    }

    @Override
    public Utensilio buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM utensilio WHERE idUtensilio = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Utensilio u = new Utensilio();
                u.setIdUtensilio(rs.getInt("idUtensilio"));
                u.setNome(rs.getString("nome"));
                return u;
            }
        }
        return null;
    }

    @Override
    public List<Utensilio> listar() throws SQLException {
        List<Utensilio> lista = new ArrayList<>();
        String sql = "SELECT * FROM utensilio ORDER BY nome";
        try (Connection con = conn != null ? conn : getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Utensilio u = new Utensilio();
                u.setIdUtensilio(rs.getInt("idUtensilio"));
                u.setNome(rs.getString("nome"));
                lista.add(u);
            }
        }
        return lista;
    }

    // ================================
    // MÉTODO ÚTIL: buscar por nome (parcial)
    // ================================

    public List<Utensilio> buscarPorNome(String nomeParcial) throws SQLException {
        List<Utensilio> lista = new ArrayList<>();
        String sql = "SELECT * FROM utensilio WHERE nome LIKE ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nomeParcial + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Utensilio u = new Utensilio();
                u.setIdUtensilio(rs.getInt("idUtensilio"));
                u.setNome(rs.getString("nome"));
                lista.add(u);
            }
        }
        return lista;
    }
}

