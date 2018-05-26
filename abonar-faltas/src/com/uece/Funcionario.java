package com.uece;

import java.io.Serializable;

public class Funcionario implements Serializable {

    private String nome;

    public Funcionario(String nome) {
	this.nome = nome;
    }

    public String getNome() {
	return nome;
    }
}
