package br.ulbra.Controller;

import br.ulbra.DAO.ReceitaUtensilioDAO;
import br.ulbra.model.ReceitaUtensilio;
import java.sql.SQLException;
import java.util.List;

public class ReceitaUtensilioController {
    private ReceitaUtensilioDAO dao = new ReceitaUtensilioDAO();
   
    public void adicionar(ReceitaUtensilio ru) throws SQLException {
        if (ru.getIdReceita() <= 0) {
            throw new SQLException("ID da receita inválido.");
        }
        if (ru.getIdUtensilio() <= 0) {
            throw new SQLException("ID do utensílio inválido.");
        }
        // O DAO já verifica duplicidade internamente (conforme seu código)
        dao.adicionar(ru);
    }
   
    public ReceitaUtensilio buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }
   
    public List<ReceitaUtensilio> listar() throws SQLException {
        return dao.listar();
    }
   
    public void editar(ReceitaUtensilio ru) throws SQLException {
        if (ru.getId() <= 0) {
            throw new SQLException("ID da relação Receita-Utensílio inválido.");
        }
        dao.editar(ru);
    }
   
    public void remover(int id) throws SQLException {
        dao.remover(id);
    }
   
    /**
     * Busca todos os utensílios associados a uma receita específica
     */
    public List<ReceitaUtensilio> buscarPorReceita(int idReceita) throws SQLException {
        return dao.buscarPorReceita(idReceita);
    }
   
    /**
     * Verifica se existe pelo menos uma associação Receita-Utensílio no sistema
     */
    public boolean existeAssociacoes() throws SQLException {
        return !dao.listar().isEmpty();
    }
}
