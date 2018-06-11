package domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PedidoItens implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne(optional = false)
    private Pedido pedido;
    
    @ManyToOne(optional = false)
    private Produto produto;

    private int quantidade;

    @Column(precision = 4)
    private double preco;

    @Column(precision = 4)
    private double total;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return this.pedido;
    }

    public void setPedido(Pedido value) {
        this.pedido = value;
    }
    
    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto value) {
        this.produto = value;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int value) {
        this.quantidade = value;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double value) {
        this.preco = value;
    }

    public double getTotal() {
        if (this.quantidade > 0) {
            this.total = this.quantidade * this.preco;
        }
        
        return this.total;
    }
    
    public void setTotal(double value) {
        this.total = value;
    }
}