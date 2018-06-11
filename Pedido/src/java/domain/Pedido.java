package domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido implements Serializable {

    @Id @GeneratedValue
    private Integer id;
    
    @Column(nullable = false, unique = true)
    private Integer numero;

    @Column(precision = 4)
    private double valor;

    private Status status;

    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    
    @ManyToOne(optional = false)
    private Cliente cliente;

    @ManyToOne(optional = false)
    private Vendedor vendedor;
    
    @OneToMany(mappedBy = "pedido")
    private List<PedidoItens> pedidoItens = new ArrayList<PedidoItens>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer value) {
        this.numero = value;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double value) {
        this.valor = value;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status value) {
        this.status = value;
    }
   
    public Date getDataVenda() {
        return this.dataVenda;
    }

    public void setDataVenda(Date value) {
        this.dataVenda = value;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente value) {
        this.cliente = value;
    }

    public Vendedor getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Vendedor value) {
        this.vendedor = value;
    }
    
    public List<PedidoItens> getPedidoItens() {
        return this.pedidoItens;
    }

    public void setPedidoItens(List<PedidoItens> value) {
        this.pedidoItens = value;
    }
    
    public void cadastrar() {
        
    }

    @Override
    public String toString() {
        return numero + " - " + cliente.getNome();
    }
}