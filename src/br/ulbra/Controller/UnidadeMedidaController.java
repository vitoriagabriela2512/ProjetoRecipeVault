package br.ulbra.Controller;

import br.ulbra.DAO.UnidadeMedidaDAO;
import br.ulbra.model.UnidadeMedida;
import java.sql.SQLException;
import java.util.List;

/**
 * Controller para operações com unidades de medida
 * @author qijef
 */
public class UnidadeMedidaController {
    private UnidadeMedidaDAO dao = new UnidadeMedidaDAO();
   
    public void adicionar(UnidadeMedida um) throws SQLException {
        if (um.getNome() == null || um.getNome().trim().isEmpty()) {
            throw new SQLException("O nome da unidade de medida é obrigatório.");
        }
        // Opcional: verificar duplicidade por nome ou abreviação
        dao.adicionar(um);
    }
   
    public UnidadeMedida buscar(int id) throws SQLException {
        return dao.buscarPorId(id);
    }
   
    public List<UnidadeMedida> listar() throws SQLException {
        return dao.listar();
    }
   
    public void editar(UnidadeMedida um) throws SQLException {
        if (um.getIdUnidade() <= 0) {
            throw new SQLException("ID da unidade de medida inválido.");
        }
        if (um.getNome() == null || um.getNome().trim().isEmpty()) {
            throw new SQLException("O nome da unidade de medida é obrigatório.");
        }
        dao.editar(um);
    }
   
    public void remover(int id) throws SQLException {
        dao.remover(id);
    }
   
    /**
     * Busca unidades de medida por tipo (ex: "peso", "volume", "unidade")
     */
    public List<UnidadeMedida> buscarPorTipo(String tipo) throws SQLException {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new SQLException("Tipo de unidade de medida não pode ser vazio.");
        }
        return dao.buscarPorTipo(tipo.trim());
    }
   
    /**
     * Verifica se existe pelo menos uma unidade de medida cadastrada
     */
    public boolean existeUnidadesMedida() throws SQLException {
        return !dao.listar().isEmpty();
    }
}
