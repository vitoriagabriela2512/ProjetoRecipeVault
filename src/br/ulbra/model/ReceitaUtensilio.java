
package br.ulbra.model;


public class ReceitaUtensilio {
        private int id;              // PK
    private int idReceita;       // FK
    private int idUtensilio;     // FK
    private String uso;          // ex: "Misturar", "Assar", "Cortar"
    private int quantidade;      // ex: 1 (usado uma vez), 2 (duas colheres, etc.)

    // Construtor padrão
    public ReceitaUtensilio() {}

    // Construtor com parâmetros
    public ReceitaUtensilio(int id, int idReceita, int idUtensilio, String uso, int quantidade) {
        this.id = id;
        this.idReceita = idReceita;
        this.idUtensilio = idUtensilio;
        this.uso = uso;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public int getIdUtensilio() {
        return idUtensilio;
    }

    public void setIdUtensilio(int idUtensilio) {
        this.idUtensilio = idUtensilio;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ReceitaUtensilio{" + "id=" + id + ", idReceita=" + idReceita + ", idUtensilio=" + idUtensilio + ", uso=" + uso + ", quantidade=" + quantidade + '}';
    }

 
   
   
 
}
