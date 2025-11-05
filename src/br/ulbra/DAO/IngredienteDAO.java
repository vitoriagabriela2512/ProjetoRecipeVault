package br.ulbra.DAO;

import br.ulbra.model.Ingrediente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAO extends AbstractDAO implements InterfaceDAO {

    private Connection conn;

    public IngredienteDAO(Connection conn) {
        this.conn = conn;
    }

    public IngredienteDAO() {
        // Usa getConnection() de abstractDAO
    }

    // ================================
    // MÉTODOS DA InterfaceDAO
    // ================================

    @Override
    public void adicionar(Object obj) throws SQLException {
        if (!(obj instanceof Ingrediente)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo Ingrediente.");
        }
        adicionar((Ingrediente) obj);
    }

    @Override
    public void editar(Object obj) throws SQLException {
        if (!(obj instanceof Ingrediente)) {
            throw new IllegalArgumentException("Objeto deve ser do tipo Ingrediente.");
        }
        editar((Ingrediente) obj);
    }

    @Override
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM ingrediente WHERE idIngrediente = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // ================================
    // MÉTODOS ESPECÍFICOS
    // ================================

    public void adicionar(Ingrediente i) throws SQLException {
        String sql = "INSERT INTO ingrediente (produtos, nomes, quantidade, unidadeMedida, informacoesNutricio, idReceita) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, i.getProdutos());
            stmt.setString(2, i.getNomes());
            stmt.setDouble(3, i.getQuantidade());
            stmt.setInt(4, i.getUnidadeMedida());
            stmt.setString(5, i.getInformacoesNutricio());
            stmt.setInt(6, i.getIdReceita());
            stmt.executeUpdate();

            // Se quiser atualizar o ID gerado (caso idIngrediente seja AUTO_INCREMENT)
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    i.setIdIngrediente(rs.getInt(1));
                }
            }
        }
    }

    public void editar(Ingrediente i) throws SQLException {
        String sql = "UPDATE ingrediente SET produtos = ?, nomes = ?, quantidade = ?, unidadeMedida = ?, informacoesNutricio = ?, idReceita = ? WHERE idIngrediente = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, i.getProdutos());
            stmt.setString(2, i.getNomes());
            stmt.setDouble(3, i.getQuantidade());
            stmt.setInt(4, i.getUnidadeMedida());
            stmt.setString(5, i.getInformacoesNutricio());
            stmt.setInt(6, i.getIdReceita());
            stmt.setInt(7, i.getIdIngrediente());
            stmt.executeUpdate();
        }
    }

    @Override
    public Ingrediente buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM ingrediente WHERE idIngrediente = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Ingrediente i = new Ingrediente();
                i.setIdIngrediente(rs.getInt("idIngrediente"));
                i.setProdutos(rs.getString("produtos"));
                i.setNomes(rs.getString("nomes"));
                i.setQuantidade(rs.getDouble("quantidade"));
                i.setUnidadeMedida(rs.getInt("unidadeMedida"));
                i.setInformacoesNutricio(rs.getString("informacoesNutricio"));
                i.setIdReceita(rs.getInt("idReceita"));
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Ingrediente> listar() throws SQLException {
        List<Ingrediente> lista = new ArrayList<>();
        String sql = "SELECT * FROM ingrediente";
        try (Connection con = conn != null ? conn : getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Ingrediente i = new Ingrediente();
                i.setIdIngrediente(rs.getInt("idIngrediente"));
                i.setProdutos(rs.getString("produtos"));
                i.setNomes(rs.getString("nomes"));
                i.setQuantidade(rs.getDouble("quantidade"));
                i.setUnidadeMedida(rs.getInt("unidadeMedida"));
                i.setInformacoesNutricio(rs.getString("informacoesNutricio"));
                i.setIdReceita(rs.getInt("idReceita"));
                lista.add(i);
            }
        }
        return lista;
    }

    // ================================
    // MÉTODO ÚTIL: buscar por receita
    // ================================

    public List<Ingrediente> buscarPorReceita(int idReceita) throws SQLException {
        List<Ingrediente> lista = new ArrayList<>();
        String sql = "SELECT * FROM ingrediente WHERE idReceita = ?";
        try (Connection con = conn != null ? conn : getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idReceita);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Ingrediente i = new Ingrediente();
                i.setIdIngrediente(rs.getInt("idIngrediente"));
                i.setProdutos(rs.getString("produtos"));
                i.setNomes(rs.getString("nomes"));
                i.setQuantidade(rs.getDouble("quantidade"));
                i.setUnidadeMedida(rs.getInt("unidadeMedida"));
                i.setInformacoesNutricio(rs.getString("informacoesNutricio"));
                i.setIdReceita(rs.getInt("idReceita"));
                lista.add(i);
            }
        }
        return lista;
    }
}
