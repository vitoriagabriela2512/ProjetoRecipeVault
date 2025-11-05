package br.ulbra.DAO;

import br.ulbra.model.UnidadeMedida;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnidadeMedidaDAO extends AbstractDAO implements InterfaceDAO {

    private Connection conn;

    public UnidadeMedidaDAO(Connection conn) {
        this.conn = conn;
    }

    public UnidadeMedidaDAO() {
        // Usa getConnection() herdado de abstractDAO
    }

    // ================================
    // MÉTODOS DA InterfaceDAO
    // ================================

    @Override
    public void adicionar(Object obj) throws SQLException {
        if (!(obj instanceof UnidadeMedida)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo UnidadeMedida.");
        }
        adicionar((UnidadeMedida) obj);
    }

    @Override
    public void editar(Object obj) throws SQLException {
        if (!(obj instanceof UnidadeMedida)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo UnidadeMedida.");
        }
        editar((UnidadeMedida) obj);
    }

    @Override
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM unidadeMedida WHERE idUnidade = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // ================================
    // MÉTODOS ESPECÍFICOS
    // ================================

    public void adicionar(UnidadeMedida um) throws SQLException {
        String sql = "INSERT INTO unidadeMedida (nome, abreviacao, tipo) VALUES (?, ?, ?)";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, um.getNome());
            stmt.setString(2, um.getAbreviacao());
            stmt.setString(3, um.getTipo());
            stmt.executeUpdate();

            // Recupera o ID gerado (caso AUTO_INCREMENT)
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    um.setIdUnidade(rs.getInt(1));
                }
            }
        }
    }

    public void editar(UnidadeMedida um) throws SQLException {
        String sql = "UPDATE unidadeMedida SET nome = ?, abreviacao = ?, tipo = ? WHERE idUnidade = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, um.getNome());
            stmt.setString(2, um.getAbreviacao());
            stmt.setString(3, um.getTipo());
            stmt.setInt(4, um.getIdUnidade());
            stmt.executeUpdate();
        }
    }

    @Override
    public UnidadeMedida buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM unidadeMedida WHERE idUnidade = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                UnidadeMedida um = new UnidadeMedida();
                um.setIdUnidade(rs.getInt("idUnidade"));
                um.setNome(rs.getString("nome"));
                um.setAbreviacao(rs.getString("abreviacao"));
                um.setTipo(rs.getString("tipo"));
                return um;
            }
        }
        return null;
    }

    @Override
    public List<UnidadeMedida> listar() throws SQLException {
        List<UnidadeMedida> lista = new ArrayList<>();
        String sql = "SELECT * FROM unidadeMedida ORDER BY nome";
        try (Connection con = conn != null ? conn : getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                UnidadeMedida um = new UnidadeMedida();
                um.setIdUnidade(rs.getInt("idUnidade"));
                um.setNome(rs.getString("nome"));
                um.setAbreviacao(rs.getString("abreviacao"));
                um.setTipo(rs.getString("tipo"));
                lista.add(um);
            }
        }
        return lista;
    }

    // ================================
    // MÉTODO ÚTIL: buscar por tipo (ex: "peso", "volume")
    // ================================

    public List<UnidadeMedida> buscarPorTipo(String tipo) throws SQLException {
        List<UnidadeMedida> lista = new ArrayList<>();
        String sql = "SELECT * FROM unidadeMedida WHERE tipo = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, tipo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UnidadeMedida um = new UnidadeMedida();
                um.setIdUnidade(rs.getInt("idUnidade"));
                um.setNome(rs.getString("nome"));
                um.setAbreviacao(rs.getString("abreviacao"));
                um.setTipo(rs.getString("tipo"));
                lista.add(um);
            }
        }
        return lista;
    }
}
