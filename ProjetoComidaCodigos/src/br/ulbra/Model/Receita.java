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
public class Receita {
   private int id;
    private String titulo;
    private int tempoPreparo; // em minutos
    private int porcao;      // quantidade de porções
    private int usuarioId;   // ID do usuário que criou a receita
    private String categoria; // ex: Salgado, Doce, Vegetariana, etc.

    // Construtor vazio
    public Receita() {
    }

    // Construtor com parâmetros
    public Receita(int id, String titulo, int tempoPreparo, int porcao, int usuarioId, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.tempoPreparo = tempoPreparo;
        this.porcao = porcao;
        this.usuarioId = usuarioId;
        this.categoria = categoria;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public int getPorcao() {
        return porcao;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Método toString (opcional, mas útil para debug)
    @Override
    public String toString() {
        return "Receita{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", tempoPreparo=" + tempoPreparo +
                ", porcao=" + porcao +
                ", usuarioId=" + usuarioId +
                ", categoria='" + categoria + '\'' +
                '}';
    }

    public int getIdReceita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdReceita(int andIncrement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
