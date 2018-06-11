package domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    @Column(length = 40)
    private String nome;

    @CPF
    @Column(length = 11)
    private String cpf;

    @Override
    public String toString() {
        return nome + " cpf=" + cpf;
    }
}