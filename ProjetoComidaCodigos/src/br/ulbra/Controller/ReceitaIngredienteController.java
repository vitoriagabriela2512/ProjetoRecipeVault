/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.Controller;

import br.ulbra.DAO.ReceitaIngredienteDAO;
import br.ulbra.Model.ReceitaIngrediente;
import java.util.List;

/**
 *
 * @author aluno.saolucas
 */
public class ReceitaIngredienteController {
 private ReceitaIngredienteDAO receitaIngredienteDAO;

    public ReceitaIngredienteController() {
        this.receitaIngredienteDAO = new ReceitaIngredienteDAO();
    }

    /**
     * Vincula um ingrediente a uma receita.
     */
    public void adicionarIngredienteAReceita(int receitaId, int ingredienteId, 
                                             double quantidade, int unidadeMedidaId) {
        if (receitaId <= 0) {
            throw new IllegalArgumentException("ID da receita inválido.");
        }
        if (ingredienteId <= 0) {
            throw new IllegalArgumentException("ID do ingrediente inválido.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }
        if (unidadeMedidaId <= 0) {
            throw new IllegalArgumentException("ID da unidade de medida inválido.");
        }

        ReceitaIngrediente item = new ReceitaIngrediente();
        item.setReceitaId(receitaId);
        item.setIngredienteId(ingredienteId);
        item.setQuantidade(quantidade);
        item.setUnidadeMedidaId(unidadeMedidaId);

        receitaIngredienteDAO.adicionar(item);
    }

    /**
     * Busca todos os ingredientes de uma receita específica.
     */
    public List<ReceitaIngrediente> buscarIngredientesDaReceita(int receitaId) {
        return receitaIngredienteDAO.buscarPorReceita(receitaId);
    }   
    
    
    
}
