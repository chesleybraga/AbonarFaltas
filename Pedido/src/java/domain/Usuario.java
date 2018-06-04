package domain;

import entities.annotations.PropertyDescriptor;
import entities.annotations.UserRoles;
import entities.annotations.Username;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario implements Serializable {

    public enum Role {
        Admin, Vendedor, Caixa, Supervisor
    }
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @Username
    @Column(length = 30, unique = true)
    @NotEmpty(message = "Informe o nome do usuário")
    private String nomeUsuario;
    
    @Column(length = 32)
    @NotEmpty(message = "Informe a senha")
    @Type(type = "entities.security.Password")
    @PropertyDescriptor(secret = true, displayWidth = 25)
    private String senha;
    
    @UserRoles
    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<Role>();
    
    
}
