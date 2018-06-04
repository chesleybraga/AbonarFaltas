package domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.validator.constraints.br.CPF;

@Entity
public class Vendedor implements Serializable{

    @Id @GeneratedValue
    private Integer id;
    
    @Column(length = 60, nullable = false)
    private String nome;

    @CPF
    @Column(length = 11, nullable = false, unique = true)
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
