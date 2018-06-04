package domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public abstract class Status implements Serializable{
    @Id
    private Integer id;

    @Column(length = 40)
    private String descricao;

    @Transient
    Pedido pedido;

    public abstract void Aceita();
    public abstract void Paga();
    public abstract void Cancela(String motivo);

    @Override
    public String toString() {
        return "Status" + descricao;
    }
    
    

}
