package domain;

import javax.persistence.Entity;

@Entity
public class Aprovada extends Status {
    
    public Aprovada() {
        this.setId(4);
        this.setDescricao("Aprovada");
    }
    
    public Aprovada(Solicitacao solicitacao) {
        this();
        this.solicitacao = solicitacao;
    }
    
    @Override
    public void solicitar() {
	throw new IllegalStateException("Solicitação não pode ser solicitada.");
    }
    
    @Override
    public void aprovar() {
	throw new IllegalStateException("Solicitação não pode ser aprovada.");
    }
    
    @Override
    public void recusar() {
	throw new IllegalStateException("Solicitação não pode ser recusada.");
    }
    
    @Override
    public void retornar(String motivo) {
        solicitacao.setMotivo(motivo);
        solicitacao.setStatus(new AguardandoChefia());
    }
}