package domain;

public class StatusPago extends Status {

    @Override
    public void Aceita() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Paga() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void Cancela(String motivo) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}