package domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Data
//@EqualsAndHashCode(callSuper = false)
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
