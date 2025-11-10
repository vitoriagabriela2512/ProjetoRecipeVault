/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.DAO;

import br.ulbra.Model.Receita;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author aluno.saolucas
 */
public class ReceitaDAO {
  private static final List<Receita> receitas = new ArrayList<>();
    private static final AtomicInteger proximoId = new AtomicInteger(1);

    // Método para cadastrar uma nova receita
    public void cadastrar(Receita receita) {
        if (receita == null) {
            throw new IllegalArgumentException("Receita não pode ser nula.");
        }
        receita.setIdReceita(proximoId.getAndIncrement());
        receitas.add(receita);
    }

    // Busca uma receita pelo ID
    public Receita buscarPorId(int id) {
        for (Receita r : receitas) {
            if (r.getIdReceita() == id) {
                return r;
            }
        }
        return null; // não encontrada
    }

    // Busca todas as receitas de um usuário específico
    public List<Receita> buscarPorUsuario(int usuarioId) {
        List<Receita> resultado = new ArrayList<>();
        for (Receita r : receitas) {
            if (r.getUsuarioId() == usuarioId) {
                resultado.add(r);
            }
        }
        return resultado;
    }
    
}
