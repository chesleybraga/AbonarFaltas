package com.uece.status;

public class AguardandoRH implements IStatus {
    
    @Override
    public void solicitar() {
	// TODO implementar
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void aprovar() {
	// TODO implementar
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void recusar() {
	// TODO implementar
	throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void retornar(String motivo) {
	if (motivo == null) || motivo.isEmpty() {
        throw new IllegalArgumentException("Motivo inválido");
    }
        solicitacao.setMotivo(motivo);
	    solicitacao status = new AguardandoChefia()
    }
}
