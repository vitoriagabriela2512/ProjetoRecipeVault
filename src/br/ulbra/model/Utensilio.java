package br.ulbra.model;


public class Utensilio {
    private int idUtensilio;     
    private String nome;

    public Utensilio() {
    }

    public Utensilio(int idUtensilio, String nome) {
        this.idUtensilio = idUtensilio;
        this.nome = nome;
    }

    public int getIdUtensilio() {
        return idUtensilio;
    }

    public void setIdUtensilio(int idUtensilio) {
        this.idUtensilio = idUtensilio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Utensilio{" + "idUtensilio=" + idUtensilio + ", nome=" + nome + '}';
    }
   
    
   
}


