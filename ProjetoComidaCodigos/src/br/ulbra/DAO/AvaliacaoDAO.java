/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.DAO;

import br.ulbra.Model.Avaliacao;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author aluno.saolucas
 */
public class AvaliacaoDAO {
    // Armazenamento em memória (simula uma tabela no banco de dados)
    private static final List<Avaliacao> avaliacoes = new ArrayList<>();
    private static final AtomicInteger proximoId = new AtomicInteger(1);

    /**
     * Cadastra uma nova avaliação.
     * Atribui automaticamente um idAvaliacao único.
     * 
     * @param avaliacao O objeto Avaliacao a ser cadastrado
     * @throws IllegalArgumentException se a avaliação for nula,
     *         se a nota estiver fora do intervalo válido (1–5),
     *         ou se faltar usuário/receita associados.
     */
    public void cadastrar(Avaliacao avaliacao) {
        if (avaliacao == null) {
            throw new IllegalArgumentException("Avaliação não pode ser nula.");
        }

        // Validação básica da nota (assumindo escala de 1 a 5)
        if (avaliacao.getNota() < 1 || avaliacao.getNota() > 5) {
            throw new IllegalArgumentException("A nota deve estar entre 1 e 5.");
        }

        // Validação: IDs de usuário e receita devem ser válidos (não zero ou negativo)
        if (avaliacao.getUsuarioId() <= 0) {
            throw new IllegalArgumentException("ID do usuário inválido.");
        }
        if (avaliacao.getReceitaId() <= 0) {
            throw new IllegalArgumentException("ID da receita inválido.");
        }

        // Atribui novo ID único
        avaliacao.setIdAvaliacao(proximoId.getAndIncrement());
        avaliacoes.add(avaliacao);
    }
    
    
    
    
    
    
}
