package br.ulbra.Controller;

import br.ulbra.DAO.AvaliacaoDAO;
import br.ulbra.model.Avaliacao;
import java.sql.SQLException;
import java.util.List;


public class AvaliacaoController {
    private AvaliacaoDAO dao = new AvaliacaoDAO();
   
    public void adicionar(Avaliacao a) throws SQLException {
        // Aqui você pode adicionar validações extras se desejar
        // Ex: verificar se usuário ou receita existem, ou se já avaliou antes
        dao.adicionar(a);
    }
   
    public Avaliacao buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }
   
    public List<Avaliacao> listar() throws SQLException {
        return dao.listar();
    }
   
    public void editar(Avaliacao a) throws SQLException {
        dao.editar(a);
    }
   
    public void remover(int id) throws SQLException {
        dao.remover(id);
    }
   
    /**
     * Busca todas as avaliações associadas a uma receita específica
     */
    public List<Avaliacao> buscarPorReceita(int idReceita) throws SQLException {
        return dao.buscarPorReceita(idReceita);
    }

    /**
     * Calcula a média das notas de uma receita com base nas avaliações
     */
    public double calcularMediaReceita(int idReceita) throws SQLException {
        return dao.calcularMediaReceita(idReceita);
    }
   
    /**
     * Verifica se existe pelo menos uma avaliação no sistema
     */
    public boolean existeAvaliacoes() throws SQLException {
        return !dao.listar().isEmpty();
    }
}
