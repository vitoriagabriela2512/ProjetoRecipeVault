package br.ulbra.DAO;

import static br.ulbra.DAO.AbstractDAO.getConnection;
import br.ulbra.model.Avaliacao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO extends AbstractDAO implements InterfaceDAO {

    private Connection conn;

    public AvaliacaoDAO(Connection conn) {
        this.conn = conn;
    }

    public AvaliacaoDAO() {
        // Usa getConnection() herdado de abstractDAO
    }

    // ================================
    // MÉTODOS DA InterfaceDAO
    // ================================

    @Override
    public void adicionar(Object obj) throws SQLException {
        if (!(obj instanceof Avaliacao)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo Avaliacao.");
        }
        adicionar((Avaliacao) obj);
    }

    @Override
    public void editar(Object obj) throws SQLException {
        if (!(obj instanceof Avaliacao)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo Avaliacao.");
        }
        editar((Avaliacao) obj);
    }

    @Override
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM avaliacao WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // ================================
    // MÉTODOS ESPECÍFICOS (com LocalDate)
    // ================================

    public void adicionar(Avaliacao a) throws SQLException {
        String sql = "INSERT INTO avaliacao (idReceita, idUsuario, nota, comentario, data) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, a.getIdReceita());
            stmt.setInt(2, a.getIdUsuario());
            stmt.setInt(3, a.getNota());
            stmt.setString(4, a.getComentario());
            // Correção: converte LocalDate → java.sql.Date
            if (a.getData() != null) {
                stmt.setDate(5, java.sql.Date.valueOf(a.getData()));
            } else {
                stmt.setNull(5, Types.DATE);
            }
            stmt.executeUpdate();
        }
    }

    public void editar(Avaliacao a) throws SQLException {
        String sql = "UPDATE avaliacao SET idReceita = ?, idUsuario = ?, nota = ?, comentario = ?, data = ? WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, a.getIdReceita());
            stmt.setInt(2, a.getIdUsuario());
            stmt.setInt(3, a.getNota());
            stmt.setString(4, a.getComentario());
            if (a.getData() != null) {
                stmt.setDate(5, java.sql.Date.valueOf(a.getData()));
            } else {
                stmt.setNull(5, Types.DATE);
            }
            stmt.setInt(6, a.getId());
            stmt.executeUpdate();
        }
    }

    @Override
    public Avaliacao buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM avaliacao WHERE id = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Avaliacao a = new Avaliacao();
                a.setId(rs.getInt("id"));
                a.setIdReceita(rs.getInt("idReceita"));
                a.setIdUsuario(rs.getInt("idUsuario"));
                a.setNota(rs.getInt("nota"));
                a.setComentario(rs.getString("comentario"));
                // Correção: converte java.sql.Date → LocalDate
                java.sql.Date sqlDate = rs.getDate("data");
                a.setData(sqlDate != null ? sqlDate.toLocalDate() : null);
                return a;
            }
        }
        return null;
    }

    @Override
    public List<Avaliacao> listar() throws SQLException {
        List<Avaliacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM avaliacao ORDER BY data DESC";
        try (Connection con = conn != null ? conn : getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Avaliacao a = new Avaliacao();
                a.setId(rs.getInt("id"));
                a.setIdReceita(rs.getInt("idReceita"));
                a.setIdUsuario(rs.getInt("idUsuario"));
                a.setNota(rs.getInt("nota"));
                a.setComentario(rs.getString("comentario"));
                java.sql.Date sqlDate = rs.getDate("data");
                a.setData(sqlDate != null ? sqlDate.toLocalDate() : null);
                lista.add(a);
            }
        }
        return lista;
    }

    // ================================
    // MÉTODOS ÚTEIS
    // ================================

    public List<Avaliacao> buscarPorReceita(int idReceita) throws SQLException {
        List<Avaliacao> lista = new ArrayList<>();
        String sql = "SELECT * FROM avaliacao WHERE idReceita = ? ORDER BY data DESC";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idReceita);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Avaliacao a = new Avaliacao();
                a.setId(rs.getInt("id"));
                a.setIdReceita(rs.getInt("idReceita"));
                a.setIdUsuario(rs.getInt("idUsuario"));
                a.setNota(rs.getInt("nota"));
                a.setComentario(rs.getString("comentario"));
                java.sql.Date sqlDate = rs.getDate("data");
                a.setData(sqlDate != null ? sqlDate.toLocalDate() : null);
                lista.add(a);
            }
        }
        return lista;
    }

    public double calcularMediaReceita(int idReceita) throws SQLException {
        String sql = "SELECT AVG(nota) FROM avaliacao WHERE idReceita = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idReceita);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble(1);
            }
        }
        return 0.0;
    }
}
