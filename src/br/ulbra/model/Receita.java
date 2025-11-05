package br.ulbra.model;


public class Receita {
   private int id;
    private String nome;
    private int tempoDePreparo; // em minutos
    private String modoDePreparo;
    private String categoria; // ex: Salgado, Doce, Vegetariana, etc.
    private int quantidadeIngrediente;

    public Receita() {
    }

    public Receita(int id, String nome, int tempoDePreparo, String modoDePreparo, String categoria, int quantidadeIngrediente) {
        this.id = id;
        this.nome = nome;
        this.tempoDePreparo = tempoDePreparo;
        this.modoDePreparo = modoDePreparo;
        this.categoria = categoria;
        this.quantidadeIngrediente = quantidadeIngrediente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(int tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

    public String getModoDePreparo() {
        return modoDePreparo;
    }

    public void setModoDePreparo(String modoDePreparo) {
        this.modoDePreparo = modoDePreparo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQuantidadeIngrediente() {
        return quantidadeIngrediente;
    }

    public void setQuantidadeIngrediente(int quantidadeIngrediente) {
        this.quantidadeIngrediente = quantidadeIngrediente;
    }

    @Override
    public String toString() {
        return "Receita{" + "id=" + id + ", nome=" + nome + ", tempoDePreparo=" + tempoDePreparo + ", modoDePreparo=" + modoDePreparo + ", categoria=" + categoria + ", quantidadeIngrediente=" + quantidadeIngrediente + '}';
    }

    
   
}
