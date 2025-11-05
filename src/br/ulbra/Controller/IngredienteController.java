package br.ulbra.Controller;

import br.ulbra.DAO.IngredienteDAO;
import br.ulbra.model.Ingrediente;
import java.sql.SQLException;
import java.util.List;


public class IngredienteController {
    private IngredienteDAO dao = new IngredienteDAO();
   
    public void adicionar(Ingrediente i) throws SQLException {
        // Você pode adicionar validações personalizadas aqui se necessário
        dao.adicionar(i);
    }
   
    public Ingrediente buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }
   
    public List<Ingrediente> listar() throws SQLException {
        return dao.listar();
    }
   
    public void editar(Ingrediente i) throws SQLException {
        dao.editar(i);
    }
   
    public void remover(int id) throws SQLException {
        dao.remover(id);
    }
   
    /**
     * Busca todos os ingredientes associados a uma receita específica
     */
    public List<Ingrediente> buscarPorReceita(int idReceita) throws SQLException {
        return dao.buscarPorReceita(idReceita);
    }
   
    /**
     * Verifica se existe pelo menos um ingrediente no sistema
     */
    public boolean existeIngredientes() throws SQLException {
        return !dao.listar().isEmpty();
    }
}
