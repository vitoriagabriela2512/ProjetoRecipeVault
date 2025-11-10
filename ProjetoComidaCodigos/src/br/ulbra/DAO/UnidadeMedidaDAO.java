/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.DAO;

import br.ulbra.Model.UnidadeMedida;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno.saolucas
 */
public class UnidadeMedidaDAO {
    // Lista estática com unidades de medida pré-cadastradas (simula banco de dados)
    private static final List<UnidadeMedida> unidades = new ArrayList<>();

    // Inicialização estática com dados comuns
    static {
        unidades.add(new UnidadeMedida(1, "g", "gramas"));
        unidades.add(new UnidadeMedida(2, "kg", "quilogramas"));
        unidades.add(new UnidadeMedida(3, "ml", "mililitros"));
        unidades.add(new UnidadeMedida(4, "L", "litros"));
        unidades.add(new UnidadeMedida(5, "xíc", "xícara de chá"));
        unidades.add(new UnidadeMedida(6, "col (sopa)", "colher de sopa"));
        unidades.add(new UnidadeMedida(7, "col (chá)", "colher de chá"));
        unidades.add(new UnidadeMedida(8, "a gosto", "a gosto"));
        unidades.add(new UnidadeMedida(9, "unidade", "unidade"));
    }

    /**
     * Retorna uma cópia da lista de todas as unidades de medida cadastradas.
     * 
     * @return Lista de UnidadeMedida (nunca nula)
     */
    public List<UnidadeMedida> listarTodas() {
        return new ArrayList<>(unidades); // retorna cópia para evitar modificações externas
    }

    /**
     * Busca uma unidade de medida pelo ID.
     * 
     * @param id ID da unidade de medida
     * @return UnidadeMedida encontrada ou null se não existir
     */
    public UnidadeMedida buscarPorId(int id) {
        for (UnidadeMedida u : unidades) {
            if (u.getIdUnidadeMedida() == id) {
                return u;
            }
        }
        return null; // não encontrada
    }
    
    
}
