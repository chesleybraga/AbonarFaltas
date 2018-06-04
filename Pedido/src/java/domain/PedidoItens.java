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

    Produto getProduto() {
        return this.produto;
    }

    void setProduto(Produto value) {
        this.produto = value;
    }

    int getQuantidade() {
        return this.quantidade;
    }

    void setQuantidade(int value) {
        this.quantidade = value;
    }

    double getPreco() {
        return this.preco;
    }

    void setPreco(double value) {
        this.preco = value;
    }

    double getTotal() {
        if (this.quantidade > 0) {
            this.total = this.quantidade * this.preco;
        } else {
            this.total = 0;
        }
        return this.total;
    }

}
