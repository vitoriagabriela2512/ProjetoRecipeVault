package br.ulbra.DAO;

import br.ulbra.model.Receita;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReceitaDAO extends AbstractDAO implements InterfaceDAO {

    private Connection conn;

    public ReceitaDAO(Connection conn) {
        this.conn = conn;
    }

    public ReceitaDAO() {
        // Usa getConnection() herdado de abstractDAO
    }

    // ================================
    // MÉTODOS DA InterfaceDAO
    // ================================

    @Override
    public void adicionar(Object obj) throws SQLException {
        if (!(obj instanceof Receita)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo Receita.");
        }
        adicionar((Receita) obj);
    }

    @Override
    public void editar(Object obj) throws SQLException {
        if (!(obj instanceof Receita)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo Receita.");
        }
        editar((Receita) obj);
    }

    @Override
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM receita WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // ================================
    // MÉTODOS ESPECÍFICOS
    // ================================

    public void adicionar(Receita r) throws SQLException {
        String sql = "INSERT INTO receita (nome, modoDePreparo, tempoDePreparo, quantidadeIngrediente) VALUES (?, ?, ?, ?)";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, r.getNome());
            stmt.setString(2, r.getModoDePreparo());
            stmt.setInt(3, r.getTempoDePreparo());
            stmt.setInt(4, r.getQuantidadeIngrediente());
            stmt.executeUpdate();

            // Recupera o ID gerado (se for AUTO_INCREMENT)
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    r.setId(rs.getInt(1));
                }
            }
        }
    }

    public void editar(Receita r) throws SQLException {
        String sql = "UPDATE receita SET nome = ?, modoDePreparo = ?, tempoDePreparo = ?, quantidadeIngrediente = ? WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, r.getNome());
            stmt.setString(2, r.getModoDePreparo());
            stmt.setInt(3, r.getTempoDePreparo());
            stmt.setInt(4, r.getQuantidadeIngrediente());
            stmt.setInt(5, r.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Receita buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM receita WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Receita r = new Receita();
                r.setId(rs.getInt("id"));
                r.setNome(rs.getString("nome"));
                r.setModoDePreparo(rs.getString("modoDePreparo"));
                r.setTempoDePreparo(rs.getInt("tempoDePreparo"));
                r.setQuantidadeIngrediente(rs.getInt("quantidadeIngrediente"));
                return r;
            }
        }
        return null;
    }

    @Override
    public List<Receita> listar() throws SQLException {
        List<Receita> lista = new ArrayList<>();
        String sql = "SELECT * FROM receita ORDER BY nome";
        try (Connection con = conn != null ? conn : getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Receita r = new Receita();
                r.setId(rs.getInt("id"));
                r.setNome(rs.getString("nome"));
                r.setModoDePreparo(rs.getString("modoDePreparo"));
                r.setTempoDePreparo(rs.getInt("tempoDePreparo"));
                r.setQuantidadeIngrediente(rs.getInt("quantidadeIngrediente"));
                lista.add(r);
            }
        }
        return lista;
    }

    // ================================
    // MÉTODO ÚTIL: buscar por nome (parcial)
    // ================================

    public List<Receita> buscarPorNome(String nomeParcial) throws SQLException {
        List<Receita> lista = new ArrayList<>();
        String sql = "SELECT * FROM receita WHERE nome LIKE ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + nomeParcial + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Receita r = new Receita();
                r.setId(rs.getInt("id"));
                r.setNome(rs.getString("nome"));
                r.setModoDePreparo(rs.getString("modoDePreparo"));
                r.setTempoDePreparo(rs.getInt("tempoDePreparo"));
                r.setQuantidadeIngrediente(rs.getInt("quantidadeIngrediente"));
                lista.add(r);
            }
        }
        return lista;
    }

  // Em ReceitaDAO.java
public boolean existePorNome(String nome) throws SQLException {
    String sql = "SELECT COUNT(*) FROM receita WHERE nome = ?";
    try (Connection con = conn != null ? conn : getConnection();
         PreparedStatement stmt = con.prepareStatement(sql)) {
        stmt.setString(1, nome.trim());
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
    }
    return false;
}
}
