
package br.ulbra.DAO;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDAO<T> {
    void adicionar(T obj) throws SQLException;

    T buscarPorId(int id) throws SQLException;

    List<T> listar() throws SQLException;

    void editar(T obj) throws SQLException;

    void remover(int id) throws SQLException;

 
}
