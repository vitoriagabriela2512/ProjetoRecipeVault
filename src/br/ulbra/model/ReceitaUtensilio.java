
package br.ulbra.model;


public class ReceitaUtensilio {
      private int id;
    private int idReceita;
    private int idUtensilio;

    public ReceitaUtensilio() {
    }

    public ReceitaUtensilio(int id, int idReceita, int idUtensilio) {
        this.id = id;
        this.idReceita = idReceita;
        this.idUtensilio = idUtensilio;
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

    @Override
    public String toString() {
        return "ReceitaUtensilio{" + "id=" + id + ", idReceita=" + idReceita + ", idUtensilio=" + idUtensilio + '}';
    }
 
 
}
