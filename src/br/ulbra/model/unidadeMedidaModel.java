
package br.ulbra.model;

public class unidadeMedidaModel {
private int idUnidade;
public String nome;
public String abreviaçao;
public String tipo;
public String fatorConversao;

    public unidadeMedidaModel(int idUnidade, String nome, String abreviaçao, String tipo, String fatorConversao) {
        this.idUnidade = idUnidade;
        this.nome = nome;
        this.abreviaçao = abreviaçao;
        this.tipo = tipo;
        this.fatorConversao = fatorConversao;
    }

    public unidadeMedidaModel() {
    }

    public int getIdUnidade() {
        return idUnidade;
    }

    public String getNome() {
        return nome;
    }

    public String getAbreviaçao() {
        return abreviaçao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFatorConversao() {
        return fatorConversao;
    }

    public void setIdUnidade(int idUnidade) {
        this.idUnidade = idUnidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAbreviaçao(String abreviaçao) {
        this.abreviaçao = abreviaçao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFatorConversao(String fatorConversao) {
        this.fatorConversao = fatorConversao;
    }

    @Override
    public String toString() {
        return "unidadeMedidaModel{" + "idUnidade=" + idUnidade + ", nome=" + nome + ", abrevia\u00e7ao=" + abreviaçao + ", tipo=" + tipo + ", fatorConversao=" + fatorConversao + '}';
    }



}
