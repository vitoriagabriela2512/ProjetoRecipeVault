/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.DAO;

import br.ulbra.Model.Ingrediente;
import java.util.List;

/**
 *
 * @author aluno.saolucas
 */
public class IngredienteDAO {
     // Atributos solicitados
    private int idIngrediente;
    private String nome;

    // Construtores
    public IngredienteDAO() {}

    public IngredienteDAO(int idIngrediente, String nome) {
        this.idIngrediente = idIngrediente;
        this.nome = nome;
    }

    // Getters e Setters
    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Métodos DAO solicitados
    public void cadastrar(IngredienteDAO ingrediente) {
        // Aqui você normalmente salvaria no banco de dados
        // Como é um exemplo simples, vamos apenas atribuir os valores
        this.idIngrediente = ingrediente.getIdIngrediente();
        this.nome = ingrediente.getNome();
        System.out.println("Ingrediente cadastrado: " + this.nome);
    }

    public IngredienteDAO buscarPorId(int id) {
        // Simulação: se o id for igual ao deste objeto, retorna ele
        if (this.idIngrediente == id) {
            return this;
        }
        return null; // ou lançar exceção, dependendo do caso
    }

    public IngredienteDAO buscarPorNome(String nome) {
        // Simulação: comparação simples (case-sensitive)
        if (this.nome != null && this.nome.equals(nome)) {
            return this;
        }
        return null;
    }

    public List<Ingrediente> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void cadastrar(Ingrediente novo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
