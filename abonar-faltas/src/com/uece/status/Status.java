package com.uece.status;

import com.uece.Solicitacao;

public abstract class Status {

    Solicitacao solicitacao;

    public Status setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
        return this;
    }

    public abstract void solicitar();

    public abstract void aprovar();

    public abstract void recusar();

    public abstract void retornar(String motivo);
}
