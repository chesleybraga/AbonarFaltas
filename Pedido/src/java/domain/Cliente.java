package domain;

import entities.annotations.View;
import entities.annotations.Views;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
@Views(
        @View(name = "Clientes",
                title = "Clientes",
                filters = "nome;cnpj;cidade;uf",
                members = "[id;nome;cnpj;Endereco[cidade;uf]]",
                template = "@CRUD_PAGE+@FILTER"
        ))
public class Cliente implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 60, nullable = false)
    private String nome;

    @Column(length = 15, nullable = false)
    private String cnpj;

    @Column(length = 60, nullable = false)
    private String cidade;

    @Column(length = 2, nullable = false)
    private String uf;

    @Version
    private Timestamp versao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String value) {
        this.nome = value;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String value) {
        this.cnpj = value;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setCidade(String value) {
        this.cidade = value;
    }
    
    public String getUf() {
        return this.uf;
    }

    public void setUf(String value) {
        this.uf = value;
    }

    public Timestamp getVersao() {
        return versao;
    }

    public void setVersao(Timestamp versao) {
        this.versao = versao;
    }

    @Override
    public String toString() {
        return nome;
    }
}