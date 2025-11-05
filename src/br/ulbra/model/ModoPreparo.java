
package br.ulbra.model;

public class ModoPreparo {
   private int idModoPreparo;
    private int idReceita;
    private int numeroPasso;
    private String descricaoPasso;
    private String tempoEstimado;
    private String imagem ; 

    public ModoPreparo() {
    }

    public ModoPreparo(int idModoPreparo, int idReceita, int numeroPasso, String descricaoPasso, String tempoEstimado, String imagem) {
        this.idModoPreparo = idModoPreparo;
        this.idReceita = idReceita;
        this.numeroPasso = numeroPasso;
        this.descricaoPasso = descricaoPasso;
        this.tempoEstimado = tempoEstimado;
        this.imagem = imagem;
    }

    public int getIdModoPreparo() {
        return idModoPreparo;
    }

    public void setIdModoPreparo(int idModoPreparo) {
        this.idModoPreparo = idModoPreparo;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public int getNumeroPasso() {
        return numeroPasso;
    }

    public void setNumeroPasso(int numeroPasso) {
        this.numeroPasso = numeroPasso;
    }

    public String getDescricaoPasso() {
        return descricaoPasso;
    }

    public void setDescricaoPasso(String descricaoPasso) {
        this.descricaoPasso = descricaoPasso;
    }

    public String getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(String tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "ModoPreparo{" + "idModoPreparo=" + idModoPreparo + ", idReceita=" + idReceita + ", numeroPasso=" + numeroPasso + ", descricaoPasso=" + descricaoPasso + ", tempoEstimado=" + tempoEstimado + ", imagem=" + imagem + '}';
    }
    
    
    
}
