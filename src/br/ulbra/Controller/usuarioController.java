
package br.ulbra.Controller;



import br.ulbra.DAO.UsuarioDAO;
import br.ulbra.model.usuarioModel;
import java.sql.SQLException;
import java.util.List;

/**
 * Controller para operações com usuários
 * @author qijef
 */
public class usuarioController {
    private UsuarioDAO dao = new UsuarioDAO();
   
    public void adicionar(usuarioModel u) throws SQLException {
        // Verifica se o login já existe
        if (dao.Login(u.getEmail())) {
            throw new SQLException("EMAIL já existe no sistema!");
        }
        dao.adicionar(u);
    }
   
    public usuarioModel buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }
   
    public List<usuarioModel> listar() throws SQLException {
        return dao.listar();
    }
   
    public void editar(usuarioModel u) throws SQLException {
        dao.editar(u);
    }
   
    public void remover(int id) throws SQLException {
        dao.remover(id);
    }
   
    /**
     * Autentica um usuário no sistema
     * @param login Login do usuário
     * @param senha Senha em texto plano
     * @return Usuario autenticado ou null se login/senha inválidos
     */
    public usuarioModel autenticar(String login, String senha) throws SQLException {
        if (login == null || login.trim().isEmpty()) {
            throw new SQLException("Login é obrigatório");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new SQLException("Senha é obrigatória");
        }
       
        return dao.autenticar(login.trim(), senha);
    }
   
    /**
     * Verifica se existe pelo menos um usuário no sistema
     */
    public boolean existeUsuarios() throws SQLException {
        return !dao.listar().isEmpty();
    }
}