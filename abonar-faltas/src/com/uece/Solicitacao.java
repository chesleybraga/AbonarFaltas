package com.uece;

import java.util.Date;

import com.uece.status.IStatus;
import com.uece.status.NovaSolicitacaoStatus;

public class Solicitacao {

    private Funcionario funcionario;
    private Date inicio;
    private Date fim;
    private String motivo;
    private String observacao;
    private IStatus status = new NovaSolicitacaoStatus();

    public Solicitacao(Funcionario funcionario) {
	this.funcionario = funcionario;
    }

    public void solicitar() {
	status.solicitar();
    }

    public void aprovar() {
	status.aprovar();
    }

    public void recusar() {
	status.recusar();
    }

    public void retornar(String motivo) {
	status.retornar(motivo);
    }
}