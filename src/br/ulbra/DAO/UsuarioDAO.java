package br.ulbra.DAO;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import br.ulbra.model.usuarioModel;

public class UsuarioDAO extends abstractDAO implements InterfaceDAO {
    private Connection conn;

    public UsuarioDAO(Connection conn) {
        this.conn = conn;
    }

    public UsuarioDAO() {
       
    }

 
    // Salvar usuário
    public void adicionar(usuarioModel u) throws SQLException {
        String sql = "INSERT INTO usuario (nome, login, senha, idade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.setString(3, u.getTipo());
            
  
            stmt.executeUpdate();
        }
    }

    // Verificar se login já existe
    public boolean Login(String email) throws SQLException {
        String sql = "SELECT COUNT(*) FROM usuario WHERE login = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        }
        return false;
    }

    // Buscar usuário pelo ID
    public usuarioModel buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new usuarioModel(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("tipo")
                );
            }
        }
        return null;
    }

    // Listar todos os usuários
    public List<usuarioModel> listar() throws SQLException {
        List<usuarioModel> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                lista.add(new usuarioModel(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("senha"),
                    rs.getString("tipo")
                ));
            }
        }
        return lista;
    }
    
      public void editar(usuarioModel u) throws SQLException {
        String sql = "UPDATE usuario SET login = ?, nome = ?, ativo = ? WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, u.getEmail());
            ps.setString(2, u.getNome());
            ps.setBoolean(3, u.isAtivo());
            ps.setInt(4, u. getIdUsuario());

            ps.executeUpdate();
        }
    }

    @Override
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM usuario WHERE id = ?";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }



    public usuarioModel autenticar(String trim, String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void adicionar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  



}
