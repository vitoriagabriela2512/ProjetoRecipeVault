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
public class Categoria {
      private int id_Categoria;  // PK
    private String nome;

    // Construtor padrão (necessário para muitas frameworks e boas práticas)
    public Categoria() {}

    // Construtor com parâmetros (opcional, mas útil)
    public Categoria(int id_Categoria, String nome) {
        this.id_Categoria = id_Categoria;
        this.nome = nome;
    }

    // Getter e Setter para id_Categoria
    public int getIdCategoria() {
        return id_Categoria;
    }

    public void setIdCategoria(int id_Categoria) {
        this.id_Categoria = id_Categoria;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método toString() útil para exibição (ex: em JComboBox)
    @Override
    public String toString() {
        return nome; // mostra só o nome quando o objeto for convertido para String
    }
    
    
}
