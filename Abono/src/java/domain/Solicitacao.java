package domain;

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

@NamedQueries({
    @NamedQuery(
            name = "SolicitacoesAguardandoChefia",
            query = "Select s"
            + " From Solicitacao s, AguardandoChefia st"
            + " Where s.status = st")
    ,
@NamedQuery(
            name = "SolicitacoesAguardandoRH",
            query = "Select s"
            + " From Solicitacao s, AguardandoRH st"
            + " Where s.status = st")
})

@Views({
    @View(name = "RequisitaAbono",
            title = "Requisita Abono",
            members = "[#funcionario;#inicio;#termino;#motivo;NovaSolicitacao()]",
            namedQuery = "Select new poo.abono.Solicitacao()",
            roles = "LOGGED")
    ,
    @View(name = "ChefiaAutorizaAbono",
            title = "Chefia Autoriza Abono",
            members = "[funcionario:2;inicio,termino;#motivo,observacao;[aprovar(),recusar()]]",
            namedQuery = "Select so from Solicitacao so,AguardandoChefia st where so.status = st",
            roles = "Admin,Supervisor")
    ,
    @View(name = "RHAutorizaAbono",
            title = "RH Autoriza Abono",
            members = "Requisicao Abono[[funcionario;inicio;termino],motivo],Action[aprovar();retornar();recusar()]",
            namedQuery = "Select so from Solicitacao so,AguardandoRH st where so.status = st",
            roles = "Admin,RH")
    ,
    @View(name = "Solicitacoes",
            title = "Solicitacoes",
            filters = "funcionario",
            members = "[funcionario;inicio;termino;motivo;observacao;status;[solicitar(),aprovar(),recusar(),retornar()]]",
            template = "@FORM+@FILTER",
            roles = "Admin")
})

@Entity
@EqualsAndHashCode(of = "id")
public class Solicitacao implements Serializable {

    public enum TipoEvento {
        Aservico, AtestadoMedico, Licenca, ProblemaPonto, Outros
    }
       
 static {
     Repositorio.save(new NovaSolicitacao());
     Repositorio.save(new AguardandoChefia());
     Repositorio.save(new AguardandoRH());
     Repositorio.save(new Aprovada());
     Repositorio.save(new Recusada());
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
    private TipoEvento tipoEvento;

    public Solicitacao() {

    }
    
    @ActionDescriptor(refreshView = true)
    public String solicitar() {
//        if (tipoEvento.contains(AtestadoMedico) || tipoEvento.contains(ProblemaPonto)) {
//            status.setSolicitacao(this).aprovar();
//        } else {
//            status.setSolicitacao(this).solicitar();
//        }
        
//        Repositorio.getInstance().add(this);
//        Repositorio.getInstance().persistAll();
        
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