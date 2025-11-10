/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.Controller;

import br.ulbra.DAO.IngredienteDAO;
import br.ulbra.Model.Ingrediente;
import java.util.List;

/**
 *
 * @author aluno.saolucas
 */
public class IngredienteController {
    private IngredienteDAO ingredienteDAO;

    // Construtor: inicializa o DAO
    public IngredienteController() {
        this.ingredienteDAO = new IngredienteDAO();
    }

    /**
     * Cadastra um novo ingrediente.
     * 
     * @param nome        Nome do ingrediente (obrigatório)
     * @param descricao   Descrição do ingrediente (pode ser vazia, mas não nula)
     * @throws IllegalArgumentException se o nome for inválido
     */
    public void cadastrarIngrediente(String nome, String descricao) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do ingrediente não pode ser vazio.");
        }

        Ingrediente novo = new Ingrediente();
        novo.setNome(nome.trim());
        novo.setDescricao(descricao == null ? "" : descricao.trim());

        ingredienteDAO.cadastrar(novo);
    }

    /**
     * Lista todos os ingredientes cadastrados.
     * 
     * @return Lista imutável de ingredientes (nunca nula)
     */
    public List<Ingrediente> listarTodosIngredientes() {
        return ingredienteDAO.listarTodos();
    }

    /**
     * Busca um ingrediente pelo ID.
     * 
     * @param id ID do ingrediente
     * @return Ingrediente encontrado ou null se não existir
     */
    public IngredienteDAO buscarIngredientePorId(int id) {
        return ingredienteDAO.buscarPorId(id);
    }
    
    
    
    
    
}
