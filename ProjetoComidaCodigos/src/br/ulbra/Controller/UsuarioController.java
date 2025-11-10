/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.Controller;

import br.ulbra.DAO.UsuarioDAO;
import br.ulbra.Model.Avaliacao;
import br.ulbra.Model.Receita;
import br.ulbra.Model.Usuario;

/**
 *
 * @author aluno.saolucas
 */
public class UsuarioController {
    private final UsuarioDAO usuarioDAO;

    public UsuarioController() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void cadastrarUsuario(String nome, String email, String senha, String tipo) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome é obrigatório.");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("E-mail é obrigatório.");
        }
        if (senha == null || senha.trim().isEmpty()) {
            throw new IllegalArgumentException("Senha é obrigatória.");
        }

        Usuario u = new Usuario();
        u.setNome(nome.trim());
        u.setEmail(email.trim());
        u.setSenha(senha); // ⚠️ Em produção: use hash!
        u.setTipo(tipo == null ? "comum" : tipo.trim());

        usuarioDAO.cadastrar(u);
    }

    public Usuario fazerLogin(String email, String senha) {
        return usuarioDAO.fazerLogin(email, senha);
    }

    // Métodos delegados (conforme solicitado no UsuarioDAO)
    public void cadastrarReceita(Receita receita) {
        usuarioDAO.cadastrarReceita(receita);
    }

    public void avaliarReceita(Avaliacao avaliacao) {
        usuarioDAO.avaliarReceita(avaliacao);
    }

    // ⚠️ Você não pediu explicitamente: excluir, alterar — mas estão no DAO.
    // Se quiser, posso adicionar aqui também
}
