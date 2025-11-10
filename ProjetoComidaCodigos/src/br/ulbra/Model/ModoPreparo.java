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
public class ModoPreparo {
     private int idModoPreparo;   // PK
    private String descricao;    // ex: "Misture os ingredientes secos"
    private int ordem;           // posição do passo (1, 2, 3...)
    private int receitaId;       // FK: ID da receita à qual este passo pertence

    // Construtor padrão
    public ModoPreparo() {}

    // Construtor com parâmetros
    public ModoPreparo(int idModoPreparo, String descricao, int ordem, int receitaId) {
        this.idModoPreparo = idModoPreparo;
        this.descricao = descricao;
        this.ordem = ordem;
        this.receitaId = receitaId;
    }

    // Getter e Setter para idModoPreparo
    public int getIdModoPreparo() {
        return idModoPreparo;
    }

    public void setIdModoPreparo(int idModoPreparo) {
        this.idModoPreparo = idModoPreparo;
    }

    // Getter e Setter para descricao
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Getter e Setter para ordem
    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    // Getter e Setter para receitaId
    public int getReceitaId() {
        return receitaId;
    }

    public void setReceitaId(int receitaId) {
        this.receitaId = receitaId;
    }

    // Método toString() útil para exibição (ex: em listas numeradas)
    @Override
    public String toString() {
        return ordem + ". " + descricao;
    }

    public long getIdReceita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setId(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdReceita(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
