package store.client;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
// import java.util.Date;

@Entity
@Table(name = "client")
@NoArgsConstructor
public class ClientModel {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

    /* @Column(name = "birthday")
    private Date birthday; */

    @Column(name = "hashpassword")
    private String hashpassword;

    public ClientModel(Client o) {
        this.id = o.id();
        this.name = o.name();
        this.cpf = o.cpf();
        this.email = o.email();
        this.hashpassword = o.hashpassword();
    }

    public Client to() {
        return Client.builder()
            .id(this.id)
            .name(this.name)
            .cpf(this.cpf)
            .email(this.email)
            .hashpassword(this.hashpassword)
            .build();
    }

    public void setId(String id2) {
    }

}
