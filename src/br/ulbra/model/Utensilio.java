
package br.ulbra.model;


public class Utensilio {
    private int idUtensilio;     
    private String nome;
    private String materiais;     
    private boolean eletrico;     

    public Utensilio(int idUtensilio, String nome, String materiais, boolean eletrico) {
        this.idUtensilio = idUtensilio;
        this.nome = nome;
        this.materiais = materiais;
        this.eletrico = eletrico;
    }

    public Utensilio() {
    }

    public int getIdUtensilio() {
        return idUtensilio;
    }

    public String getNome() {
        return nome;
    }

    public String getMateriais() {
        return materiais;
    }

    public boolean isEletrico() {
        return eletrico;
    }

    public void setIdUtensilio(int idUtensilio) {
        this.idUtensilio = idUtensilio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMateriais(String materiais) {
        this.materiais = materiais;
    }

    public void setEletrico(boolean eletrico) {
        this.eletrico = eletrico;
    }

    @Override
    public String toString() {
        return "Utensilio{" + "idUtensilio=" + idUtensilio + ", nome=" + nome + ", materiais=" + materiais + ", eletrico=" + eletrico + '}';
    }

    
}
