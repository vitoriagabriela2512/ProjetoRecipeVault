/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.Controller;

import br.ulbra.DAO.UtensilioDAO;
import br.ulbra.Model.Utensilio;
import java.util.List;

/**
 *
 * @author aluno.saolucas
 */
public class UtensilioController {
    private UtensilioDAO utensilioDAO;

    public UtensilioController() {
        this.utensilioDAO = new UtensilioDAO();
    }

    /**
     * Cadastra um novo utensílio.
     */
    public void cadastrarUtensilio(String nome, String materiais, boolean eletrico) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do utensílio não pode ser vazio.");
        }

        Utensilio novo = new Utensilio();
        novo.setNome(nome.trim());
        novo.setMateriais(materiais == null ? "" : materiais.trim());
        novo.setEletrico(eletrico);

        utensilioDAO.cadastrar(novo);
    }

    /**
     * Lista todos os utensílios.
     */
    public List<Utensilio> listarTodosUtensilios() {
        return utensilioDAO.listarTodos();
    }

    /**
     * Busca um utensílio pelo ID.
     */
    public Utensilio buscarUtensilioPorId(int id) {
        return utensilioDAO.buscarPorId(id);
    }
}
