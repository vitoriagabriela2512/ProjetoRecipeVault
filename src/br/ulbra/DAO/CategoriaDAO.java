package br.ulbra.DAO;

import br.ulbra.model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO extends AbstractDAO implements InterfaceDAO {

    private Connection conn;

    public CategoriaDAO(Connection conn) {
        this.conn = conn;
    }

    public CategoriaDAO() {
        // Construtor vazio para compatibilidade (mas requer getConnection() no abstractDAO)
    }

    // ================================
    // IMPLEMENTAÇÃO DOS MÉTODOS CRUD
    // ================================

    @Override
    public void adicionar(Object obj) throws SQLException {
        if (!(obj instanceof Categoria)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo Categoria.");
        }
        adicionar((Categoria) obj);
    }

    public void adicionar(Categoria c) throws SQLException {
        String sql = "INSERT INTO categoria (nome, doce, salgado, vegano, fitness, vegetariano) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn != null ? conn.prepareStatement(sql) : getConnection().prepareStatement(sql)) {
            stmt.setString(1, c.getNome());
            stmt.setBoolean(2, c.isDoce());
            stmt.setBoolean(3, c.isSalgado());
            stmt.setBoolean(4, c.isVegano());
            stmt.setBoolean(5, c.isFitness());
            stmt.setBoolean(6, c.isVegetariano());
            stmt.executeUpdate();
        }
    }

    @Override
    public void editar(Object obj) throws SQLException {
        if (!(obj instanceof Categoria)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo Categoria.");
        }
        editar((Categoria) obj);
    }

    public void editar(Categoria c) throws SQLException {
        String sql = "UPDATE categoria SET nome = ?, doce = ?, salgado = ?, vegano = ?, fitness = ?, vegetariano = ? WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, c.getNome());
            stmt.setBoolean(2, c.isDoce());
            stmt.setBoolean(3, c.isSalgado());
            stmt.setBoolean(4, c.isVegano());
            stmt.setBoolean(5, c.isFitness());
            stmt.setBoolean(6, c.isVegetariano());
            stmt.setInt(7, c.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM categoria WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // ================================
    // MÉTODOS ESPECÍFICOS
    // ================================

    @Override
    public Categoria buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM categoria WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setDoce(rs.getBoolean("doce"));
                c.setSalgado(rs.getBoolean("salgado"));
                c.setVegano(rs.getBoolean("vegano"));
                c.setFitness(rs.getBoolean("fitness"));
                c.setVegetariano(rs.getBoolean("vegetariano"));
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Connection con = conn != null ? conn : getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setDoce(rs.getBoolean("doce"));
                c.setSalgado(rs.getBoolean("salgado"));
                c.setVegano(rs.getBoolean("vegano"));
                c.setFitness(rs.getBoolean("fitness"));
                c.setVegetariano(rs.getBoolean("vegetariano"));
                lista.add(c);
            }
        }
        return lista;
    }

    // ================================
    // MÉTODOS AUXILIARES (opcionais)
    // ================================

    public boolean existePorNome(String nome) throws SQLException {
        String sql = "SELECT COUNT(*) FROM categoria WHERE nome = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    
}
