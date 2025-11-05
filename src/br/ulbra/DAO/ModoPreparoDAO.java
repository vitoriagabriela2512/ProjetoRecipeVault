package br.ulbra.DAO;

import br.ulbra.model.ModoPreparo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModoPreparoDAO extends AbstractDAO implements InterfaceDAO {

    private Connection conn;

    public ModoPreparoDAO(Connection conn) {
        this.conn = conn;
    }

    public ModoPreparoDAO() {
        // Usa getConnection() herdado de abstractDAO
    }

    // ================================
    // MÉTODOS DA InterfaceDAO
    // ================================

    @Override
    public void adicionar(Object obj) throws SQLException {
        if (!(obj instanceof ModoPreparo)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo ModoPreparo.");
        }
        adicionar((ModoPreparo) obj);
    }

    @Override
    public void editar(Object obj) throws SQLException {
        if (!(obj instanceof ModoPreparo)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo ModoPreparo.");
        }
        editar((ModoPreparo) obj);
    }

    @Override
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM modoPreparo WHERE idModoPreparo = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // ================================
    // MÉTODOS ESPECÍFICOS
    // ================================

    public void adicionar(ModoPreparo mp) throws SQLException {
        String sql = "INSERT INTO modoPreparo (idReceita, numeroPasso, descricaoPasso, tempoEstimado, imagem) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, mp.getIdReceita());
            stmt.setInt(2, mp.getNumeroPasso());
            stmt.setString(3, mp.getDescricaoPasso());
            stmt.setString(4, mp.getTempoEstimado());
            stmt.setString(5, mp.getImagem());
            stmt.executeUpdate();

            // Recupera o ID gerado (caso AUTO_INCREMENT)
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    mp.setIdModoPreparo(rs.getInt(1));
                }
            }
        }
    }

    public void editar(ModoPreparo mp) throws SQLException {
        String sql = "UPDATE modoPreparo SET idReceita = ?, numeroPasso = ?, descricaoPasso = ?, tempoEstimado = ?, imagem = ? WHERE idModoPreparo = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, mp.getIdReceita());
            stmt.setInt(2, mp.getNumeroPasso());
            stmt.setString(3, mp.getDescricaoPasso());
            stmt.setString(4, mp.getTempoEstimado());
            stmt.setString(5, mp.getImagem());
            stmt.setInt(6, mp.getIdModoPreparo());
            stmt.executeUpdate();
        }
    }

    @Override
    public ModoPreparo buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM modoPreparo WHERE idModoPreparo = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                ModoPreparo mp = new ModoPreparo();
                mp.setIdModoPreparo(rs.getInt("idModoPreparo"));
                mp.setIdReceita(rs.getInt("idReceita"));
                mp.setNumeroPasso(rs.getInt("numeroPasso"));
                mp.setDescricaoPasso(rs.getString("descricaoPasso"));
                mp.setTempoEstimado(rs.getString("tempoEstimado"));
                mp.setImagem(rs.getString("imagem"));
                return mp;
            }
        }
        return null;
    }

    @Override
    public List<ModoPreparo> listar() throws SQLException {
        List<ModoPreparo> lista = new ArrayList<>();
        String sql = "SELECT * FROM modoPreparo ORDER BY idReceita, numeroPasso";
        try (Connection con = conn != null ? conn : getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                ModoPreparo mp = new ModoPreparo();
                mp.setIdModoPreparo(rs.getInt("idModoPreparo"));
                mp.setIdReceita(rs.getInt("idReceita"));
                mp.setNumeroPasso(rs.getInt("numeroPasso"));
                mp.setDescricaoPasso(rs.getString("descricaoPasso"));
                mp.setTempoEstimado(rs.getString("tempoEstimado"));
                mp.setImagem(rs.getString("imagem"));
                lista.add(mp);
            }
        }
        return lista;
    }

    // ================================
    // MÉTODO ÚTIL: buscar passos por receita
    // ================================

    public List<ModoPreparo> buscarPorReceita(int idReceita) throws SQLException {
        List<ModoPreparo> lista = new ArrayList<>();
        String sql = "SELECT * FROM modoPreparo WHERE idReceita = ? ORDER BY numeroPasso";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idReceita);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ModoPreparo mp = new ModoPreparo();
                mp.setIdModoPreparo(rs.getInt("idModoPreparo"));
                mp.setIdReceita(rs.getInt("idReceita"));
                mp.setNumeroPasso(rs.getInt("numeroPasso"));
                mp.setDescricaoPasso(rs.getString("descricaoPasso"));
                mp.setTempoEstimado(rs.getString("tempoEstimado"));
                mp.setImagem(rs.getString("imagem"));
                lista.add(mp);
            }
        }
        return lista;
    }
}
