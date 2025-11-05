package br.ulbra.Controller;

import br.ulbra.DAO.ReceitaIngredienteDAO;
import br.ulbra.model.ReceitaIngrediente;
import java.sql.SQLException;
import java.util.List;

public class ReceitaIngredienteController {
    private ReceitaIngredienteDAO dao = new ReceitaIngredienteDAO();
   
    public void adicionar(ReceitaIngrediente ri) throws SQLException {
        // Validações básicas podem ser adicionadas aqui se necessário
        if (ri.getIdReceita() <= 0) {
            throw new SQLException("ID da receita inválido.");
        }
        if (ri.getIdIngrediente() <= 0) {
            throw new SQLException("ID do ingrediente inválido.");
        }
        dao.adicionar(ri);
    }
   
    public ReceitaIngrediente buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }
   
    public List<ReceitaIngrediente> listar() throws SQLException {
        return dao.listar();
    }
   
    public void editar(ReceitaIngrediente ri) throws SQLException {
        if (ri.getId() <= 0) {
            throw new SQLException("ID da relação Receita-Ingrediente inválido.");
        }
        dao.editar(ri);
    }
   
    public void remover(int id) throws SQLException {
        dao.remover(id);
    }
   
    /**
     * Busca todos os ingredientes associados a uma receita específica
     */
    public List<ReceitaIngrediente> buscarPorReceita(int idReceita) throws SQLException {
        return dao.buscarPorReceita(idReceita);
    }
   
    /**
     * Verifica se existe pelo menos um registro na tabela receitaIngrediente
     */
    public boolean existeRelacoes() throws SQLException {
        return !dao.listar().isEmpty();
    }
}
