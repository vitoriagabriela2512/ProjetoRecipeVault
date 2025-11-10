/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ulbra.DAO;

import br.ulbra.Model.Utensilio;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author aluno.saolucas
 */
public class UtensilioDAO {
      private static final List<Utensilio> utensilios = new ArrayList<>();
    private static final AtomicInteger proximoId = new AtomicInteger(1);

    // Cadastra um novo utensílio
    public void cadastrar(Utensilio utensilio) {
        if (utensilio == null) {
            throw new IllegalArgumentException("Utensílio não pode ser nulo.");
        }
        utensilio.setIdUtensilio(proximoId.getAndIncrement());
        utensilios.add(utensilio);
    }

    // Retorna uma cópia da lista de todos os utensílios
    public List<Utensilio> listarTodos() {
        return new ArrayList<>(utensilios);
    }

    // Busca um utensílio pelo ID
    public Utensilio buscarPorId(int id) {
        for (Utensilio u : utensilios) {
            if (u.getIdUtensilio() == id) {
                return u;
            }
        }
        return null; // não encontrado
    }

    // Exclui um utensílio pelo ID (opcional, mas recomendado)
    public boolean excluir(int id) {
        return utensilios.removeIf(u -> u.getIdUtensilio() == id);
    } }