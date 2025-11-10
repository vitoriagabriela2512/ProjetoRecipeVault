/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.DAO;

import br.ulbra.Model.ReceitaIngrediente;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author aluno.saolucas
 */
public class ReceitaIngredienteDAO {
    // Armazenamento em memória (simula tabela de relacionamento)
    private static final List<ReceitaIngrediente> itens = new ArrayList<>();
    private static final AtomicInteger proximoId = new AtomicInteger(1);

    /**
     * Adiciona um ingrediente a uma receita.
     * Atribui automaticamente um idReceitaIngrediente único.
     * 
     * @param item Objeto ReceitaIngrediente a ser adicionado
     * @throws IllegalArgumentException se o item for nulo ou IDs forem inválidos
     */
    public void adicionar(ReceitaIngrediente item) {
        if (item == null) {
            throw new IllegalArgumentException("Item de receita não pode ser nulo.");
        }

        // Validação básica dos IDs obrigatórios
        if (item.getReceitaId() <= 0) {
            throw new IllegalArgumentException("ID da receita inválido.");
        }
        if (item.getIngredienteId() <= 0) {
            throw new IllegalArgumentException("ID do ingrediente inválido.");
        }
        if (item.getUnidadeMedidaId() <= 0) {
            throw new IllegalArgumentException("ID da unidade de medida inválido.");
        }
        if (item.getQuantidade() <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero.");
        }

        // Atribui novo ID único
        item.setIdReceitaIngrediente(proximoId.getAndIncrement());
        itens.add(item);
    }

    /**
     * Busca todos os ingredientes associados a uma receita específica.
     * 
     * @param receitaId ID da receita
     * @return Lista de ReceitaIngrediente (pode ser vazia)
     */
    public List<ReceitaIngrediente> buscarPorReceita(int receitaId) {
        List<ReceitaIngrediente> resultado = new ArrayList<>();
        for (ReceitaIngrediente item : itens) {
            if (item.getReceitaId() == receitaId) {
                resultado.add(item);
            }
        }
        return resultado;
    }
    
    
    
    
}
