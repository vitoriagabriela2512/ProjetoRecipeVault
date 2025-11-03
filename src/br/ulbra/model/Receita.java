package br.ulbra.model;


public class Receita {
   private int id;
    private String titulo;
    private int tempoPreparo; // em minutos
    private int porcao;      // quantidade de porções
    private int usuarioId;   // ID do usuário que criou a receita
    private String categoria; // ex: Salgado, Doce, Vegetariana, etc.

    // Construtor vazio
    public Receita() {
    }

    // Construtor com parâmetros
    public Receita(int id, String titulo, int tempoPreparo, int porcao, int usuarioId, String categoria) {
        this.id = id;
        this.titulo = titulo;
        this.tempoPreparo = tempoPreparo;
        this.porcao = porcao;
        this.usuarioId = usuarioId;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public int getPorcao() {
        return porcao;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public void setPorcao(int porcao) {
        this.porcao = porcao;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Receita{" + "id=" + id + ", titulo=" + titulo + ", tempoPreparo=" + tempoPreparo + ", porcao=" + porcao + ", usuarioId=" + usuarioId + ", categoria=" + categoria + '}';
    }
    
}
