package store.client;

// import java.util.Date;

public record ClientIn(
    String id,
    String name,
    String cpf,
    String email,
    //Date birthday,
    String password
) {    
}
