/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;

/**
 *
 * @author aluno.saolucas
 */
public class ReceitaIngrediente {
    private int idReceitaIngrediente;  // PK (opcional em relacionamentos, mas você pediu)
    private int receitaId;             // FK: ID da receita
    private int ingredienteId;         // FK: ID do ingrediente
    private double quantidade;         // ex: 250.0, 1.5, 3.0
    private int unidadeMedidaId;       // FK: ID da unidade de medida (ex: 1 = "g", 2 = "ml")

    // Construtor padrão
    public ReceitaIngrediente() {}

    // Construtor com parâmetros
    public ReceitaIngrediente(int idReceitaIngrediente, int receitaId, int ingredienteId, 
                              double quantidade, int unidadeMedidaId) {
        this.idReceitaIngrediente = idReceitaIngrediente;
        this.receitaId = receitaId;
        this.ingredienteId = ingredienteId;
        this.quantidade = quantidade;
        this.unidadeMedidaId = unidadeMedidaId;
    }

    // Getter e Setter para idReceitaIngrediente
    public int getIdReceitaIngrediente() {
        return idReceitaIngrediente;
    }

    public void setIdReceitaIngrediente(int idReceitaIngrediente) {
        this.idReceitaIngrediente = idReceitaIngrediente;
    }

    // Getter e Setter para receitaId
    public int getReceitaId() {
        return receitaId;
    }

    public void setReceitaId(int receitaId) {
        this.receitaId = receitaId;
    }

    // Getter e Setter para ingredienteId
    public int getIngredienteId() {
        return ingredienteId;
    }

    public void setIngredienteId(int ingredienteId) {
        this.ingredienteId = ingredienteId;
    }

    // Getter e Setter para quantidade
    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    // Getter e Setter para unidadeMedidaId
    public int getUnidadeMedidaId() {
        return unidadeMedidaId;
    }

    public void setUnidadeMedidaId(int unidadeMedidaId) {
        this.unidadeMedidaId = unidadeMedidaId;
    }

    // Método toString() útil para exibição (ex: ao listar ingredientes de uma receita)
    @Override
    public String toString() {
        return quantidade + " (unid. " + unidadeMedidaId + ") do ingrediente " + ingredienteId;
        // Mais tarde, você pode substituir os IDs por nomes usando DAOs
    }

}
