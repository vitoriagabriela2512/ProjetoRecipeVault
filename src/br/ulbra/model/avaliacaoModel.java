
package br.ulbra.model;

public class avaliacaoModel {
private int id;
private int idReceita;
private int idUsuario;
public int nota;
public String comentario;
public int data;

    public avaliacaoModel(int id, int idReceita, int idUsuario, int nota, String comentario, int data) {
        this.id = id;
        this.idReceita = idReceita;
        this.idUsuario = idUsuario;
        this.nota = nota;
        this.comentario = comentario;
        this.data = data;
    }

    public avaliacaoModel() {
    }

    public int getId() {
        return id;
    }

    public int getIdReceita() {
        return idReceita;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getNota() {
        return nota;
    }

    public String getComentario() {
        return comentario;
    }

    public int getData() {
        return data;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "avaliacaoModel{" + "id=" + id + ", idReceita=" + idReceita + ", idUsuario=" + idUsuario + ", nota=" + nota + ", comentario=" + comentario + ", data=" + data + '}';
    }



}
