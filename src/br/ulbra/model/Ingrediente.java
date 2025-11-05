
package br.ulbra.model;

public class Ingrediente {
   private int idIngrediente;
    private String produtos;
    private String nomes;
    private double quantidade;
    private int unidadeMedida; // FK
    private String informacoesNutricio;
    private int idReceita;     // FK

    public Ingrediente(int idIngrediente, String produtos, String nomes, double quantidade, int unidadeMedida, String informacoesNutricio, int idReceita) {
        this.idIngrediente = idIngrediente;
        this.produtos = produtos;
        this.nomes = nomes;
        this.quantidade = quantidade;
        this.unidadeMedida = unidadeMedida;
        this.informacoesNutricio = informacoesNutricio;
        this.idReceita = idReceita;
    }

    public Ingrediente() {
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public String getNomes() {
        return nomes;
    }

    public void setNomes(String nomes) {
        this.nomes = nomes;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public int getUnidadeMedida() {
        return unidadeMedida;
    }

    public void setUnidadeMedida(int unidadeMedida) {
        this.unidadeMedida = unidadeMedida;
    }

    public String getInformacoesNutricio() {
        return informacoesNutricio;
    }

    public void setInformacoesNutricio(String informacoesNutricio) {
        this.informacoesNutricio = informacoesNutricio;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "idIngrediente=" + idIngrediente + ", produtos=" + produtos + ", nomes=" + nomes + ", quantidade=" + quantidade + ", unidadeMedida=" + unidadeMedida + ", informacoesNutricio=" + informacoesNutricio + ", idReceita=" + idReceita + '}';
    }
    
    

   
   
    
    
}
