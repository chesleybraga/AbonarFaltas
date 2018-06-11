package poo;

import entities.annotations.ActionDescriptor;
import entities.annotations.Editor;
import entities.annotations.ParameterDescriptor;
import entities.annotations.View;
import entities.annotations.Views;
import entities.descriptor.PropertyType;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@Entity
@EqualsAndHashCode(of = "id")
@Views({
    @View(name = "SolicitaAbono",
            title = "Solicita Abono",
            members = "[#funcionario;#inicio;#termino;#motivo;#tipoEvento;status;solicita()]",
            namedQuery = "Select new poo.Solicitacao()"),
    @View(name = "AutorizaAbono",
            title = "Autoriza Abono",
            members = "[funcionario:2;inicio,termino;#motivo,observacao;tipoEvento;[aprova(),recusa()]]",
            namedQuery = "Select ot from Solicitacao ot"),
    @View(name = "AutorizaPagamentoAbono",
            title = "Autoriza Pagamento Abono",
            members = "[funcionario;inicio;termino;motivo;tipoEvento;paga();retorna();recusa()]",
            namedQuery = "Select ot from Solicitacao ot"),
    @View(name = "Abonos",
            title = "Lista Abonos",
            filters = "funcionario",
            members = "[funcionario;inicio;termino;motivo;tipoEvento;paga();aprova();recusa();paga();retorna()]")
})

public class Solicitacao implements Serializable {

    public enum TipoEvento {
        Aservico, AtestadoMedico, Licenca, ProblemaPonto, Outros
    }

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
    @ManyToOne(cascade = CascadeType.ALL)
    private Status status = new NovaSolicitacao();

    @Version
    private Timestamp versao;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private TipoEvento tipoEvento;

    public Solicitacao() {
        
    }

    @ActionDescriptor(refreshView = true)
    public String solicita() {
        if (tipoEvento == TipoEvento.AtestadoMedico) {
            status.setSolicitacao(this).aprovar();
        } else if (tipoEvento == TipoEvento.ProblemaPonto) {
            status.setSolicitacao(this).aprovar();
        } else {
            status.setSolicitacao(this).solicitar();
        }
        
        Repositorio.getInstance().add(this);
        Repositorio.getInstance().persistAll();
        
        return "Solicitação criada com sucesso";
    }

    @ActionDescriptor(refreshView = true)
    public void aprova() {
        status.setSolicitacao(this).aprovar();
        Repositorio.getInstance().add(this);
        Repositorio.getInstance().persistAll();
    }

    @ActionDescriptor(confirm = true, refreshView = true)
    public void recusa() {
        status.setSolicitacao(this).recusar();
        Repositorio.getInstance().add(this);
        Repositorio.getInstance().persistAll();
    }

    @ActionDescriptor(confirm = true, refreshView = true)
    public void retorna(@Editor(propertyType = PropertyType.MEMO)
            @ParameterDescriptor(displayName = "Motivo") String motivo) {
        status.setSolicitacao(this).retornar(motivo);
        Repositorio.getInstance().add(this);
        Repositorio.getInstance().persistAll();
    }

    @ActionDescriptor(refreshView = true)
    public void paga() {
        status.setSolicitacao(this).pagar();
        Repositorio.getInstance().add(this);
        Repositorio.getInstance().persistAll();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getVersao() {
        return versao;
    }

    public void setVersao(Timestamp versao) {
        this.versao = versao;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }
}