package br.ulbra.Controller;

import br.ulbra.DAO.CategoriaDAO;
import br.ulbra.model.Categoria;
import java.sql.SQLException;
import java.util.List;


public class CategoriaController {
    private CategoriaDAO dao = new CategoriaDAO();
   
    public void adicionar(Categoria c) throws SQLException {
        // Verifica se o nome da categoria já existe
        if (dao.existePorNome(c.getNome())) {
            throw new SQLException("Categoria já existe no sistema!");
        }
        dao.adicionar(c);
    }
   
    public Categoria buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }
   
    public List<Categoria> listar() throws SQLException {
        return dao.listar();
    }
   
    public void editar(Categoria c) throws SQLException {
        dao.editar(c);
    }
   
    public void remover(int id) throws SQLException {
        dao.remover(id);
    }
   
    /**
     * Verifica se existe pelo menos uma categoria no sistema
     */
    public boolean existeCategorias() throws SQLException {
        return !dao.listar().isEmpty();
    }
}
