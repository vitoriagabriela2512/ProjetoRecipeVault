/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model;


public class ReceitaIngrediente {
    private int id;
    private int idReceita;
    private int idIngrediente;
    private double quantidade;
    private int unidadeMedida;
    private String observacao;

    public ReceitaIngrediente() {
    }

    public ReceitaIngrediente(int id, int idReceita, int idIngrediente, double quantidade, int unidadeMedida, String observacao) {
        this.id = id;
        this.idReceita = idReceita;
        this.idIngrediente = idIngrediente;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public int getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(int unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "ReceitaIngrediente{" + "id=" + id + ", idReceita=" + idReceita + ", idIngrediente=" + idIngrediente + ", quantidade=" + quantidade + ", unidadeMedida=" + unidadeMedida + ", observacao=" + observacao + '}';
    }

    

}
