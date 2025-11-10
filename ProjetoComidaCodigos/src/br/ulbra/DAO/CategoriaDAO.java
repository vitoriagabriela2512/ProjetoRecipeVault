/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.DAO;

import br.ulbra.Model.Categoria;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author aluno.saolucas
 */
public class CategoriaDAO {
     // Simula uma tabela de categorias em memória
    private static List<Categoria> categorias = new ArrayList<>();
    private static AtomicInteger proximoId = new AtomicInteger(1);

    // Inicializa com algumas categorias de exemplo (opcional)
    static {
        categorias.add(new Categoria(proximoId.getAndIncrement(), "Sobremesa"));
        categorias.add(new Categoria(proximoId.getAndIncrement(), "Prato Principal"));
        categorias.add(new Categoria(proximoId.getAndIncrement(), "Lanche"));
    }

    /**
     * Cadastra uma nova categoria.
     * Atribui um novo ID automaticamente.
     */
    public void cadastrar(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("Categoria não pode ser nula.");
        }
        // Define um novo ID (simula AUTO_INCREMENT)
        categoria.setIdCategoria(proximoId.getAndIncrement());
        categorias.add(categoria);
    }

    /**
     * Retorna uma cópia da lista de todas as categorias cadastradas.
     */
    public List<Categoria> listarTodas() {
        return new ArrayList<>(categorias); // retorna cópia para evitar modificações externas
    }

    /**
     * Busca uma categoria pelo ID.
     * @return Categoria encontrada ou null se não existir.
     */
    public Categoria buscarPorId(int id) {
        for (Categoria c : categorias) {
            if (c.getIdCategoria() == id) {
                return c;
            }
        }
        return null; // não encontrada
    }
}
