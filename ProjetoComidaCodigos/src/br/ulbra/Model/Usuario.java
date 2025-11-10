/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.Model;

/**
 *
 * @author aluno.saolucas
 */
public class Usuario {
    
    private int idUsuario;      // PK
    private String nome;
    private String senha;
    private String tipo;        // ex: "admin", "usuario", ou códigos como "1", "2"
    private String email;

    // Construtor padrão (obrigatório para boas práticas e frameworks)
    public Usuario() {}

    // Construtor com parâmetros (opcional, mas útil)
    public Usuario(int idUsuario, String nome, String senha, String tipo, String email) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
        this.email = email;
    }

    // Getter e Setter para idUsuario
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Getter e Setter para nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter para senha
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Getter e Setter para tipo
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Getter e Setter para email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método toString() útil para depuração ou exibição simples
    @Override
    public String toString() {
        return "Usuário{" +
                "id=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    
    
    
}
}
