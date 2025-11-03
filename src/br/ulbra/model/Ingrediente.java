
package br.ulbra.model;

public class Ingrediente {
   private int Id_Ingrediente;  // PK
    private String Nome;
    private String Descricao;

    // Construtor padrão
    public Ingrediente() {}

    // Construtor com parâmetros (opcional, mas útil)
    public Ingrediente(int Id_Ingrediente, String Nome, String Descricao) {
        this.Id_Ingrediente = Id_Ingrediente;
        this.Nome = Nome;
        this.Descricao = Descricao;
    }

    // Getter e Setter para Id_Ingrediente
    public int getIdIngrediente() {
        return Id_Ingrediente;
    }

    public void setIdIngrediente(int Id_Ingrediente) {
        this.Id_Ingrediente = Id_Ingrediente;
    }

    // Getter e Setter para Nome
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public void setDescriçao(String Descricao) {
        this.Descricao = Descricao;
    }

    // Getter e Setter para Descricao
    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "Id_Ingrediente=" + Id_Ingrediente + ", Nome=" + Nome + ", Descricao=" + Descricao + '}';
    }

   
    
    
}
