package poo;

import entities.annotations.EntityDescriptor;

@EntityDescriptor(hidden = true)
public class AguardandoRH extends Status {

    public AguardandoRH() {
        this.setId(3);
        this.setDescricao("AguardandoRH");
        Repositorio.save(this);
    }
    
    AguardandoRH(Solicitacao solicitacao) {
        this();
        this.solicitacao = solicitacao;
    }
    
    @Override
    public void solicitar() {
	throw new IllegalStateException("Solicitação não pode ser retornada.");
    }

    @Override
    public void aprovar() {
        solicitacao.setStatus(new Aprovada());
    }

    @Override
    public void recusar() {
        solicitacao.setStatus(new Recusada());
    }

    @Override
    public void retornar(String motivo) {
        if (motivo == null) {
            throw new IllegalArgumentException("Motivo inválido");
        }
        solicitacao.setMotivo(motivo);
        solicitacao.setStatus(new AguardandoChefia());
    }

    @Override
    public void pagar() {
        solicitacao.setStatus(new Aprovada());
    }
}
