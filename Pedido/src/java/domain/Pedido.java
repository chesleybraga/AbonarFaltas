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
public class Pedido implements Serializable{

    @Id @GeneratedValue
    private Integer id;
    
    @Column(nullable = false, unique = true)
    private Integer numero;

    @Column(precision = 4)
    private double valor;

    private Status status;

    @OneToMany(mappedBy = "pedido")
    private List<PedidoItens> pedidoItens = new ArrayList<PedidoItens>();

    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    
    @ManyToOne(optional = false)
    private Cliente cliente;

    @ManyToOne(optional = false)
    private Vendedor vendedor;

    int getNumero() {

        return this.numero;
    }

    void setNumero(int value) {

        this.numero = value;
    }

    double getValor() {

        return this.valor;
    }

    void setValor(double value) {

        this.valor = value;
    }

    public void cadastrar() {
    }

    Status getStatus() {

        return this.status;
    }

    void setStatus(Status value) {

        this.status = value;
    }

    Date getDataVenda() {

        return this.dataVenda;
    }

    void setDataVenda(Date value) {

        this.dataVenda = value;
    }

    Cliente getCliente() {

        return this.cliente;
    }

    void setCliente(Cliente value) {

        this.cliente = value;
    }

    Vendedor getVendedor() {

        return this.vendedor;
    }

    void setVendedor(Vendedor value) {

        this.vendedor = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return numero + " - " + cliente.getNome();
    }
    
    

}
