package store.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
// import java.util.Date; 

@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
@Accessors(chain = true, fluent = true)
public class Client {

    private String id;
    private String name;
    private String cpf;
    private String email;
    // private Date birthday;
    private String password;
    private String hashpassword;
    
}
