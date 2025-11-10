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
public class Utensilio {
    private int idUtensilio;      // PK
    private String nome;
    private String materiais;     // ex: "Inox, Madeira, Silicone"
    private boolean eletrico;     // true = elétrico, false = manual

    // Construtor padrão
    public Utensilio() {}

    // Construtor com parâmetros
    public Utensilio(int idUtensilio, String nome, String materiais, boolean eletrico) {
        this.idUtensilio = idUtensilio;
        this.nome = nome;
        this.materiais = materiais;
        this.eletrico = eletrico;
    }

    // Getter e Setter para idUtensilio
    public int getIdUtensilio() {
        return idUtensilio;
    }

    public void setIdUtensilio(int idUtensilio) {
        this.idUtensilio = idUtensilio;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para materiais
    public String getMateriais() {
        return materiais;
    }

    public void setMateriais(String materiais) {
        this.materiais = materiais;
    }

    // Getter e Setter para eletrico
    public boolean isEletrico() {
        return eletrico;
    }

    public void setEletrico(boolean eletrico) {
        this.eletrico = eletrico;
    }

    // Método toString() para exibição (ex: em JComboBox ou JList)
    @Override
    public String toString() {
        return nome + (eletrico ? " (Elétrico)" : " (Manual)");
    }

    public void setId(long aLong) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setTipo(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setMaterial(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getTipo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaterial() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public long getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
