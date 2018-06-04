package domain;

import entities.annotations.ActionDescriptor;
import entities.annotations.Editor;
import entities.annotations.ParameterDescriptor;
import entities.descriptor.PropertyType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@Entity
@EqualsAndHashCode(of = "id")
public class Solicitacao implements Serializable {
 
/*    
 static {
     Repositorio.save(new NovaSolicitacao());
     Repositorio.save(new AguardandoChefia());
     Repositorio.save(new AguardandoRH());
     Repositorio.save(new Aprovada());
     Repositorio.save(new Recusada());
     
 }
*/
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull(message = "Informe o funcionário da solicitação")
    @ManyToOne
    private Funcionario funcionario;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date termino;

    @Lob
    @NotEmpty
    private String motivo;

    @Lob
    private String observacao;

    @NotNull
    @ManyToOne(cascade=CascadeType.ALL)
    private Status status = new NovaSolicitacao();

    @ActionDescriptor(refreshView = true)
    public String solicitar() {
        status.setSolicitacao(this).solicitar();
        Repositorio.getInstance().add(this);
        Repositorio.getInstance().persistAll();
        return "Solicitação criada com sucesso";
    }

    @ActionDescriptor(refreshView = true)
    public void aprovar() {
        status.setSolicitacao(this).aprovar();
        Repositorio.getInstance().add(this);
        Repositorio.getInstance().persistAll();
    }

    @ActionDescriptor(confirm = true, refreshView = true)
    public void recusar() {
        status.setSolicitacao(this).recusar();
        Repositorio.getInstance().add(this);
        Repositorio.getInstance().persistAll();
    }

    @ActionDescriptor(confirm = true, refreshView = true)
    public void retornar(@Editor(propertyType = PropertyType.MEMO)
            @ParameterDescriptor(displayName = "Motivo") String motivo) {
        status.setSolicitacao(this).retornar(motivo);
        Repositorio.getInstance().add(this);
        Repositorio.getInstance().persistAll();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


}
