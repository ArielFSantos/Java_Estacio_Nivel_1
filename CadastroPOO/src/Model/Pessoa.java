package model;

import java.io.Serializable;

public class Pessoa implements Serializable {
    int id;
    String nome;


    public Pessoa() {}


    public Pessoa(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }


    public void exibir() {
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
    }
}
