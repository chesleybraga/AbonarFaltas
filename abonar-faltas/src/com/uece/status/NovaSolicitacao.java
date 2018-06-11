package com.uece.status;

public class NovaSolicitacao extends Status {

    @Override
    public void solicitar() {
        solicitacao.status = new AguardandoChefia();
    }

    @Override
    public void aprovar() {
	// TODO implementar
	throw new IllegalStateException("Solicitação não pode ser aprovada.");
    }

    @Override
    public void recusar() {
	// TODO implementar
	throw new IllegalStateException("Solicitação não pode ser recusada.");
    }

    @Override
    public void retornar(String motivo) {
	// TODO implementar
	throw new IllegalStateException("Solicitação não pode ser retornada.");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}