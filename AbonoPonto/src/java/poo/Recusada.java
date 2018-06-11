package poo;

import entities.annotations.EntityDescriptor;

@EntityDescriptor(hidden = true)
public class Recusada extends Status {
    
    public Recusada() {
        this.setId(5);
        this.setDescricao("Recusada");
        Repositorio.save(this);
    }

    public Recusada(Solicitacao solicitacao) {
        this();
        this.solicitacao = solicitacao;
    }

    @Override
    public void solicitar() {
        throw new IllegalStateException("Esta solicitação não pode ser solicitada.");
    }
    
    @Override
    public void aprovar() {
        throw new IllegalStateException("Esta solicitação não pode ser aprovada.");
    }
    
    @Override
    public void recusar() {
        throw new IllegalStateException("Esta solicitação não pode ser recusada.");
    }
    
    @Override
    public void retornar(String motivo) {
        throw new IllegalStateException("Esta solicitação não pode ser retornada.");
    }

    @Override
    public void pagar() {
        throw new IllegalStateException("Not supported yet.");
    }
}