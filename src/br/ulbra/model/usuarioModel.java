package br.ulbra.model;

public class usuarioModel {
private int idUsuario;
public String nome;
public String senha;
private String email;
public String tipo;

    public usuarioModel(int id, String nome, String senha, String email, String tipo) {
        this.idUsuario = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.tipo = tipo;
    }

    public usuarioModel() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setIdUsuario(int id) {
        this.idUsuario = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "usuarioModel{" + "idUsuario=" + idUsuario + ", nome=" + nome + ", senha=" + senha + ", email=" + email + ", tipo=" + tipo + '}';
    }

    public boolean isAtivo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
   


}
