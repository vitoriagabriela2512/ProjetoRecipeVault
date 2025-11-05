package br.ulbra.Controller;

import br.ulbra.DAO.ReceitaDAO;
import br.ulbra.model.Receita;
import java.sql.SQLException;
import java.util.List;


public class ReceitaController {
    private ReceitaDAO dao = new ReceitaDAO();
   
    public void adicionar(Receita r) throws SQLException {
        if (r.getNome() == null || r.getNome().trim().isEmpty()) {
            throw new SQLException("O nome da receita é obrigatório.");
        }
        // Verifica se já existe uma receita com o mesmo nome (case-insensitive e ignorando espaços)
        if (dao.existePorNome(r.getNome().trim())) {
            throw new SQLException("Já existe uma receita com esse nome!");
        }
        dao.adicionar(r);
    }
   
    public Receita buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }
   
    public List<Receita> listar() throws SQLException {
        return dao.listar();
    }
   
    public void editar(Receita r) throws SQLException {
        if (r.getNome() == null || r.getNome().trim().isEmpty()) {
            throw new SQLException("O nome da receita é obrigatório.");
        }
        dao.editar(r);
    }
   
    public void remover(int id) throws SQLException {
        dao.remover(id);
    }
   
    public List<Receita> buscarPorNome(String nomeParcial) throws SQLException {
        if (nomeParcial == null || nomeParcial.trim().isEmpty()) {
            return listar(); // ou retornar lista vazia, conforme sua regra
        }
        return dao.buscarPorNome(nomeParcial.trim());
    }
   
    public boolean existeReceitas() throws SQLException {
        return !dao.listar().isEmpty();
    }
}
