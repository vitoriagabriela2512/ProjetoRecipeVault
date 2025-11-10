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
public class UnidadeMedida {
        private int idUnidadeMedida;  // PK
    private String simbolo;       // ex: "g", "ml", "xíc", "colher (sopa)"
    private String descricao;     // ex: "gramas", "mililitros", "xícara de chá"

    // Construtor padrão
    public UnidadeMedida() {}

    // Construtor com parâmetros (opcional)
    public UnidadeMedida(int idUnidadeMedida, String simbolo, String descricao) {
        this.idUnidadeMedida = idUnidadeMedida;
        this.simbolo = simbolo;
        this.descricao = descricao;
    }

    // Getter e Setter para idUnidadeMedida
    public int getIdUnidadeMedida() {
        return idUnidadeMedida;
    }

    public void setIdUnidadeMedida(int idUnidadeMedida) {
        this.idUnidadeMedida = idUnidadeMedida;
    }

    // Getter e Setter para simbolo
    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    // Getter e Setter para descricao
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Método toString() útil para exibição (ex: em JComboBox)
    @Override
    public String toString() {
        return simbolo + " - " + descricao;
        // Ex: "g - gramas"
    }
    
    
}
