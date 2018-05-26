package com.uece;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.uece.status.*;

public class Solicitacao implements Serializable {

    private Funcionario funcionario;
    private Date inicio;
    private Date termino;
    private String motivo;
    private String observacao;
    private Status status = new NovaSolicitacao();

    public void setStatus(Status status) {
        this.status = status;
    }

    public Solicitacao(Funcionario funcionario) {

        this.funcionario = funcionario;
    }

    public void solicitar() {

        status.setSolicitacao(this).solicitar();
        Repositorio.getInstance().add(this).persistAll();
    }

    public void aprovar() {

        status.setSolicitacao(this).aprovar();
        Repositorio.getInstance().add(this).persistAll();
    }

    public void recusar() {

        status.setSolicitacao(this).recusar();
        Repositorio.getInstance().add(this).persistAll();
    }

    public void retornar(String motivo) {

        status.setSolicitacao(this).retornar(motivo);
        Repositorio.getInstance().add(this).persistAll();
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitacao that = (Solicitacao) o;
        return Objects.equals(funcionario, that.funcionario) &&
                Objects.equals(inicio, that.inicio) &&
                Objects.equals(motivo, that.motivo);
    }

    @Override
    public int hashCode() {

        return Objects.hash(funcionario, inicio, motivo);
    }


}
