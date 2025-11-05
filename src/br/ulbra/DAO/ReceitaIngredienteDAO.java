package br.ulbra.DAO;

import static br.ulbra.DAO.AbstractDAO.getConnection;
import br.ulbra.model.ReceitaIngrediente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaIngredienteDAO extends AbstractDAO implements InterfaceDAO {

    private Connection conn;

    public ReceitaIngredienteDAO(Connection conn) {
        this.conn = conn;
    }

    public ReceitaIngredienteDAO() {
        // Usa getConnection() de abstractDAO
    }

    // ================================
    // MÉTODOS DA InterfaceDAO
    // ================================

    @Override
    public void adicionar(Object obj) throws SQLException {
        if (!(obj instanceof ReceitaIngrediente)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo ReceitaIngrediente.");
        }
        adicionar((ReceitaIngrediente) obj);
    }

    @Override
    public void editar(Object obj) throws SQLException {
        if (!(obj instanceof ReceitaIngrediente)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo ReceitaIngrediente.");
        }
        editar((ReceitaIngrediente) obj);
    }

    @Override
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM receitaIngrediente WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // ================================
    // MÉTODOS ESPECÍFICOS
    // ================================

    public void adicionar(ReceitaIngrediente ri) throws SQLException {
        String sql = "INSERT INTO receitaIngrediente (idReceita, idIngrediente, quantidade, unidadeMedida, observacao) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, ri.getIdReceita());
            stmt.setInt(2, ri.getIdIngrediente());
            stmt.setDouble(3, ri.getQuantidade());
            stmt.setInt(4, ri.getUnidadeMedida());
            stmt.setString(5, ri.getObservacao());
            stmt.executeUpdate();

            // Recupera o ID gerado (caso use PK autoincremental)
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    ri.setId(rs.getInt(1));
                }
            }
        }
    }

    public void editar(ReceitaIngrediente ri) throws SQLException {
        String sql = "UPDATE receitaIngrediente SET idReceita = ?, idIngrediente = ?, quantidade = ?, unidadeMedida = ?, observacao = ? WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, ri.getIdReceita());
            stmt.setInt(2, ri.getIdIngrediente());
            stmt.setDouble(3, ri.getQuantidade());
            stmt.setInt(4, ri.getUnidadeMedida());
            stmt.setString(5, ri.getObservacao());
            stmt.setInt(6, ri.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public ReceitaIngrediente buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM receitaIngrediente WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ReceitaIngrediente ri = new ReceitaIngrediente();
                ri.setId(rs.getInt("id"));
                ri.setIdReceita(rs.getInt("idReceita"));
                ri.setIdIngrediente(rs.getInt("idIngrediente"));
                ri.setQuantidade(rs.getDouble("quantidade"));
                ri.setUnidadeMedida(rs.getInt("unidadeMedida"));
                ri.setObservacao(rs.getString("observacao"));
                return ri;
            }
        }
        return null;
    }

    @Override
    public List<ReceitaIngrediente> listar() throws SQLException {
        List<ReceitaIngrediente> lista = new ArrayList<>();
        String sql = "SELECT * FROM receitaIngrediente";
        try (Connection con = conn != null ? conn : getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ReceitaIngrediente ri = new ReceitaIngrediente();
                ri.setId(rs.getInt("id"));
                ri.setIdReceita(rs.getInt("idReceita"));
                ri.setIdIngrediente(rs.getInt("idIngrediente"));
                ri.setQuantidade(rs.getDouble("quantidade"));
                ri.setUnidadeMedida(rs.getInt("unidadeMedida"));
                ri.setObservacao(rs.getString("observacao"));
                lista.add(ri);
            }
        }
        return lista;
    }

    // ================================
    // MÉTODO ÚTIL: buscar ingredientes de uma receita
    // ================================

    public List<ReceitaIngrediente> buscarPorReceita(int idReceita) throws SQLException {
        List<ReceitaIngrediente> lista = new ArrayList<>();
        String sql = "SELECT * FROM receitaIngrediente WHERE idReceita = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idReceita);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ReceitaIngrediente ri = new ReceitaIngrediente();
                ri.setId(rs.getInt("id"));
                ri.setIdReceita(rs.getInt("idReceita"));
                ri.setIdIngrediente(rs.getInt("idIngrediente"));
                ri.setQuantidade(rs.getDouble("quantidade"));
                ri.setUnidadeMedida(rs.getInt("unidadeMedida"));
                ri.setObservacao(rs.getString("observacao"));
                lista.add(ri);
            }
        }
        return lista;
    }
}
