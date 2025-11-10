/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.Controller;

import br.ulbra.DAO.CategoriaDAO;
import br.ulbra.Model.Categoria;
import java.util.List;

/**
 *
 * @author aluno.saolucas
 */
public class CategoriaController {
     private CategoriaDAO categoriaDAO;

    // Construtor: inicializa o DAO
    public CategoriaController() {
        this.categoriaDAO = new CategoriaDAO();
    }

    /**
     * Registra uma nova categoria.
     * 
     * @param nome Nome da categoria (não pode ser vazio ou nulo)
     * @throws IllegalArgumentException se o nome for inválido
     */
    public void cadastrarCategoria(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da categoria não pode ser vazio.");
        }

        Categoria novaCategoria = new Categoria();
        novaCategoria.setNome(nome.trim());
        categoriaDAO.cadastrar(novaCategoria);
    }

    /**
     * Lista todas as categorias cadastradas.
     * 
     * @return Lista imutável de categorias
     */
    public List<Categoria> listarTodasCategorias() {
        return categoriaDAO.listarTodas();
    }

    /**
     * Busca uma categoria pelo ID.
     * 
     * @param id ID da categoria
     * @return Categoria encontrada ou null se não existir
     */
    public Categoria buscarCategoriaPorId(int id) {
        return categoriaDAO.buscarPorId(id);
    }
    
    
}
