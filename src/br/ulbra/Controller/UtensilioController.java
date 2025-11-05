package br.ulbra.Controller;

import br.ulbra.DAO.UtensilioDAO;
import br.ulbra.model.Utensilio;
import java.sql.SQLException;
import java.util.List;


public class UtensilioController {
    private UtensilioDAO dao = new UtensilioDAO();
   
    public void adicionar(Utensilio u) throws SQLException {
        if (u.getNome() == null || u.getNome().trim().isEmpty()) {
            throw new SQLException("O nome do utensílio é obrigatório.");
        }
        dao.adicionar(u);
    }
   
    public Utensilio buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }
   
    public List<Utensilio> listar() throws SQLException {
        return dao.listar();
    }
   
    public void editar(Utensilio u) throws SQLException {
        if (u.getIdUtensilio() <= 0) {
            throw new SQLException("ID do utensílio inválido.");
        }
        if (u.getNome() == null || u.getNome().trim().isEmpty()) {
            throw new SQLException("O nome do utensílio é obrigatório.");
        }
        dao.editar(u);
    }
   
    public void remover(int id) throws SQLException {
        dao.remover(id);
    }
   
    /**
     * Busca utensílios cujo nome contenha o termo informado (busca parcial)
     */
    public List<Utensilio> buscarPorNome(String nomeParcial) throws SQLException {
        if (nomeParcial == null || nomeParcial.trim().isEmpty()) {
            return listar(); // ou lançar exceção, conforme sua regra de negócio
        }
        return dao.buscarPorNome(nomeParcial.trim());
    }
   
    /**
     * Verifica se existe pelo menos um utensílio cadastrado no sistema
     */
    public boolean existeUtensilios() throws SQLException {
        return !dao.listar().isEmpty();
    }
}

