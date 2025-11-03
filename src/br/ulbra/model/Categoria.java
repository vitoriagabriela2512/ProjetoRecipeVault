
package br.ulbra.model;


public class Categoria {
    
  private int id;            // PK
    private String nome;
    private boolean doce;
    private boolean salgado;
    private boolean vegano;
    private boolean fitness;
    private boolean vegetariano;

    // Construtor padrão
    public Categoria() {}

    // Construtor com parâmetros (opcional)
    public Categoria(int id, String nome, boolean doce, boolean salgado,
                     boolean vegano, boolean fitness, boolean vegetariano) {
        this.id = id;
        this.nome = nome;
        this.doce = doce;
        this.salgado = salgado;
        this.vegano = vegano;
        this.fitness = fitness;
        this.vegetariano = vegetariano;
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

    public boolean isDoce() {
        return doce;
    }

    public void setDoce(boolean doce) {
        this.doce = doce;
    }

    public boolean isSalgado() {
        return salgado;
    }

    public void setSalgado(boolean salgado) {
        this.salgado = salgado;
    }

    public boolean isVegano() {
        return vegano;
    }

    public void setVegano(boolean vegano) {
        this.vegano = vegano;
    }

    public boolean isFitness() {
        return fitness;
    }

    public void setFitness(boolean fitness) {
        this.fitness = fitness;
    }

    public boolean isVegetariano() {
        return vegetariano;
    }

    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nome=" + nome + ", doce=" + doce + ", salgado=" + salgado + ", vegano=" + vegano + ", fitness=" + fitness + ", vegetariano=" + vegetariano + '}';
    }
   
   
   
   
   
   
}
