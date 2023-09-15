package model;

import java.io.Serializable;

public class PessoaJuridica extends Pessoa implements Serializable {
    private static int proximoId = 1; 
    private String cnpj;


    public PessoaJuridica(String nome, String cnpj) {
        this.id = proximoId++;
        this.nome = nome;
        this.cnpj = cnpj;
    }
    
    @Override
    public void exibir() {
        super.exibir();
        System.out.println("CNPJ: " + cnpj);
    }

    public void setId(int idAlterar) {
           this.id = idAlterar;
    } 
    
    int getId() {
        return id;
    }   
}
