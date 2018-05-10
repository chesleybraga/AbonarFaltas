package com.uece;

public class Main {

    public static void main(String[] args) {
	Funcionario lula = new Funcionario("Luiz Inácio Lula da Silva");

	Solicitacao solicitacao = new Solicitacao(lula);
	// solicitacao.solicitar();
	// solicitacao.aprovar();
	// solicitacao.recusar();
	// solicitacao.retornar("Não entregou atestado");
    }
}