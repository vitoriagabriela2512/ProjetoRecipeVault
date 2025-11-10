/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.Model;

import java.time.LocalDate;

/**
 *
 * @author aluno.saolucas
 */
public class Avaliacao {
     private int idAvaliacao;      // PK
    private int nota;             // ex: 1 a 5
    private String comentario;
    private int usuarioId;        // FK
    private int receitaId;        // FK
    private LocalDate data;       // data da avaliação

    // Construtor padrão
    public Avaliacao() {}

    // Construtor com parâmetros (opcional)
    public Avaliacao(int idAvaliacao, int nota, String comentario, 
                     int usuarioId, int receitaId, LocalDate data) {
        this.idAvaliacao = idAvaliacao;
        this.nota = nota;
        this.comentario = comentario;
        this.usuarioId = usuarioId;
        this.receitaId = receitaId;
        this.data = data;
    }

    // Getter e Setter para idAvaliacao
    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    // Getter e Setter para nota
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        if (nota < 1 || nota > 5) {
            throw new IllegalArgumentException("A nota deve estar entre 1 e 5.");
        }
        this.nota = nota;
    }

    // Getter e Setter para comentario
    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    // Getter e Setter para usuarioId
    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    // Getter e Setter para receitaId
    public int getReceitaId() {
        return receitaId;
    }

    public void setReceitaId(int receitaId) {
        this.receitaId = receitaId;
    }

    // Getter e Setter para data
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    // Método toString() útil para depuração
    @Override
    public String toString() {
        return "Avaliação{" +
                "id=" + idAvaliacao +
                ", nota=" + nota +
                ", comentário='" + comentario + '\'' +
                ", usuário=" + usuarioId +
                ", receita=" + receitaId +
                ", data=" + (data != null ? data.toString() : "n/a") +
                '}';
    }
    
    
}
