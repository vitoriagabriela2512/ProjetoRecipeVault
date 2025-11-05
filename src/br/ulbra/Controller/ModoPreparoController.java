package br.ulbra.Controller;

import br.ulbra.DAO.ModoPreparoDAO;
import br.ulbra.model.ModoPreparo;
import java.sql.SQLException;
import java.util.List;


public class ModoPreparoController {
    private ModoPreparoDAO dao = new ModoPreparoDAO();
   
    public void adicionar(ModoPreparo mp) throws SQLException {
        // Validações adicionais podem ser incluídas aqui se necessário
        dao.adicionar(mp);
    }
   
    public ModoPreparo buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }
   
    public List<ModoPreparo> listar() throws SQLException {
        return dao.listar();
    }
   
    public void editar(ModoPreparo mp) throws SQLException {
        dao.editar(mp);
    }
   
    public void remover(int id) throws SQLException {
        dao.remover(id);
    }
   
    /**
     * Busca todos os passos do modo de preparo associados a uma receita específica
     */
    public List<ModoPreparo> buscarPorReceita(int idReceita) throws SQLException {
        return dao.buscarPorReceita(idReceita);
    }
   
    /**
     * Verifica se existe pelo menos um passo de modo de preparo no sistema
     */
    public boolean existeModosPreparo() throws SQLException {
        return !dao.listar().isEmpty();
    }
}
