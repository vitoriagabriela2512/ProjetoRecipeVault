package br.ulbra.DAO;

import br.ulbra.DAO.AvaliacaoDAO;
import br.ulbra.DAO.ReceitaDAO;
import br.ulbra.Model.Avaliacao;
import br.ulbra.Model.Receita;
import br.ulbra.Model.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UsuarioDAO {

    private static final List<Usuario> usuarios = new ArrayList<>();
    private static final AtomicInteger proximoId = new AtomicInteger(1);

    // === MÉTODOS DE USUÁRIO ===

    /**
     * Cadastra um novo usuário.
     */
    public void cadastrar(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser nulo.");
        }
        if (emailJaExiste(usuario.getEmail())) {
            throw new IllegalArgumentException("E-mail já cadastrado: " + usuario.getEmail());
        }
        usuario.setIdUsuario(proximoId.getAndIncrement());
        usuarios.add(usuario);
    }

    /**
     * Exclui um usuário pelo ID.
     * @return true se excluído, false se não encontrado
     */
    public boolean excluir(int idUsuario) {
        return usuarios.removeIf(u -> u.getIdUsuario() == idUsuario);
    }

    /**
     * Atualiza os dados de um usuário existente (exceto ID).
     * @return true se atualizado, false se não encontrado
     */
    public boolean alterar(Usuario usuario) {
        if (usuario == null || usuario.getIdUsuario() <= 0) {
            return false;
        }
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getIdUsuario() == usuario.getIdUsuario()) {
                // Não permite alterar o e-mail para um já existente (exceto o próprio)
                String emailAtual = usuarios.get(i).getEmail();
                if (!emailAtual.equalsIgnoreCase(usuario.getEmail()) && emailJaExiste(usuario.getEmail())) {
                    throw new IllegalArgumentException("E-mail já cadastrado por outro usuário.");
                }
                usuarios.set(i, usuario);
                return true;
            }
        }
        return false;
    }

    /**
     * Realiza login com e-mail e senha.
     * @return Usuário autenticado ou null se inválido
     */
    public Usuario fazerLogin(String email, String senha) {
        if (email == null || senha == null) return null;
        for (Usuario u : usuarios) {
            if (email.equalsIgnoreCase(u.getEmail()) && senha.equals(u.getSenha())) {
                return u;
            }
        }
        return null;
    }

    // === MÉTODOS DELEGADOS (usam outros DAOs) ===

    /**
     * Cadastra uma receita associada a este usuário.
     * ⚠️ Este método delega para ReceitaDAO.
     */
    public void cadastrarReceita(Receita receita) {
        if (receita == null || receita.getUsuarioId() <= 0) {
            throw new IllegalArgumentException("Receita inválida ou sem usuário associado.");
        }
        // Verifica se o usuário existe
        if (buscarPorId(receita.getUsuarioId()) == null) {
            throw new IllegalArgumentException("Usuário não encontrado para esta receita.");
        }
        new ReceitaDAO().cadastrar(receita);
    }

    /**
     * Registra uma avaliação de receita feita por este usuário.
     * ⚠️ Este método delega para AvaliacaoDAO.
     */
    public void avaliarReceita(Avaliacao avaliacao) {
        if (avaliacao == null || avaliacao.getUsuarioId() <= 0) {
            throw new IllegalArgumentException("Avaliação inválida ou sem usuário.");
        }
        // Verifica se o usuário existe
        if (buscarPorId(avaliacao.getUsuarioId()) == null) {
            throw new IllegalArgumentException("Usuário não encontrado.");
        }
        new AvaliacaoDAO().cadastrar(avaliacao);
    }

    // === MÉTODOS AUXILIARES ===

    private boolean emailJaExiste(String email) {
        if (email == null || email.trim().isEmpty()) return false;
        for (Usuario u : usuarios) {
            if (email.equalsIgnoreCase(u.getEmail())) {
                return true;
            }
        }
        return false;
    }

    // Usado internamente por alterar() e métodos delegados
    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getIdUsuario() == id) {
                return u;
            }
        }
        return null;
    }

    // Retorna todos os usuários (útil para debug ou admin)
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }
}