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
public class Ingrediente {
   private int Id_Ingrediente;  // PK
    private String Nome;
    private String Descricao;

    // Construtor padrão
    public Ingrediente() {}

    // Construtor com parâmetros (opcional, mas útil)
    public Ingrediente(int Id_Ingrediente, String Nome, String Descricao) {
        this.Id_Ingrediente = Id_Ingrediente;
        this.Nome = Nome;
        this.Descricao = Descricao;
    }

    // Getter e Setter para Id_Ingrediente
    public int getIdIngrediente() {
        return Id_Ingrediente;
    }

    public void setIdIngrediente(int Id_Ingrediente) {
        this.Id_Ingrediente = Id_Ingrediente;
    }

    // Getter e Setter para Nome
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    // Getter e Setter para Descricao
    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    // Método toString() para exibição (ex: em listas ou combos)
    @Override
    public String toString() {
        return Nome; // exibe apenas o nome quando convertido para String
    }  
    
    
}
