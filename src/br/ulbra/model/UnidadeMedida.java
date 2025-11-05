package br.ulbra.model;

public class UnidadeMedida {
private int idUnidade;
public String nome;
public String abreviacao;
public String tipo;

    public UnidadeMedida() {
    }

    public UnidadeMedida(int idUnidade, String nome, String abreviacao, String tipo) {
        this.idUnidade = idUnidade;
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.tipo = tipo;
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "UnidadeMedida{" + "idUnidade=" + idUnidade + ", nome=" + nome + ", abreviacao=" + abreviacao + ", tipo=" + tipo + '}';
    }

  

   
}

