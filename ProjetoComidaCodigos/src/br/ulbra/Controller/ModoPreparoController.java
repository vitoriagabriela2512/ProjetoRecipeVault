/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.Controller;

import br.ulbra.DAO.ModoPreparoDAO;
import br.ulbra.Model.ModoPreparo;
import java.util.List;

/**
 *
 * @author aluno.saolucas
 */
public class ModoPreparoController {
    private ModoPreparoDAO modoPreparoDAO;

    public ModoPreparoController() {
        this.modoPreparoDAO = new ModoPreparoDAO();
    }

    /**
     * Adiciona um passo ao modo de preparo de uma receita.
     */
    public void adicionarPasso(int receitaId, String descricao, int ordem) {
        if (descricao == null || descricao.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição do passo não pode ser vazia.");
        }
        if (receitaId <= 0) {
            throw new IllegalArgumentException("ID da receita inválido.");
        }
        if (ordem <= 0) {
            throw new IllegalArgumentException("A ordem deve ser um número positivo.");
        }

        ModoPreparo passo = new ModoPreparo();
        passo.setReceitaId(receitaId);
        passo.setDescricao(descricao.trim());
        passo.setOrdem(ordem);

        modoPreparoDAO.adicionar(passo);
    }

    /**
     * Busca todos os passos de uma receita específica (ordenados por 'ordem').
     */
    public List<ModoPreparo> buscarPassosPorReceita(int receitaId) {
        return modoPreparoDAO.buscarPorReceita(receitaId);
    }

    /**
     * Busca um passo específico pelo ID.
     */
    public ModoPreparo buscarPassoPorId(int id) {
        return modoPreparoDAO.buscarPorId(id);
    }
    
    
    
}
