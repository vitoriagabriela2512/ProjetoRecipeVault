/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.Model;

/**
 *
 * @author aluno.saolucas
 */
public class ReceitaUtensilio {
     private int idReceita;     // FK: ID da receita
    private int idUtensilio;   // FK: ID do utensílio

    // Construtor padrão
    public ReceitaUtensilio() {}

    // Construtor com parâmetros
    public ReceitaUtensilio(int idReceita, int idUtensilio) {
        this.idReceita = idReceita;
        this.idUtensilio = idUtensilio;
    }

    // Getter e Setter para idReceita
    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    // Getter e Setter para idUtensilio
    public int getIdUtensilio() {
        return idUtensilio;
    }

    public void setIdUtensilio(int idUtensilio) {
        this.idUtensilio = idUtensilio;
    }

    // Método equals e hashCode (útil para evitar duplicatas em listas ou sets)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ReceitaUtensilio that = (ReceitaUtensilio) obj;
        return idReceita == that.idReceita && idUtensilio == that.idUtensilio;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(idReceita, idUtensilio);
    }

    // toString opcional (útil para debug)
    @Override
    public String toString() {
        return "ReceitaUtensilio{" +
                "receita=" + idReceita +
                ", utensilio=" + idUtensilio +
                '}';
    }
}
