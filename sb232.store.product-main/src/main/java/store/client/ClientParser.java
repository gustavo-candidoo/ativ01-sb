package store.client;

public final class ClientParser {

    public static Client to(ClientIn in) {
        return Client.builder()
            .name(in.name())
            .cpf(in.cpf())
            .email(in.email())
            .password(in.password())
            .build();
    }

    public static ClientOut to(Client o) {
        return new ClientOut(o.id(), o.name(), o.cpf(), o.email());
    }
    
}
