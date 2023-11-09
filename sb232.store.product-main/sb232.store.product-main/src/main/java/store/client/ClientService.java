package store.client;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> list() {
        return StreamSupport.stream(clientRepository.findAll().spliterator(), false)
            .collect(Collectors.toList())
            .stream().map(ClientModel::to).toList();
    }

    public Client find(String id) {
        return clientRepository.findById(id).orElse(null).to();
    }

    public void delete(String id) {
        clientRepository.deleteById(id);
    }

    public Client create(Client in) throws RuntimeException {
        if (in.password() == null)
            throw new RuntimeException("Password is mandatory");
        in.password(in.password().trim());
        if (in.password().length() < 5)
            throw new RuntimeException ("Password is shorter than 5 characters");
        try {
        // Transformando o password em hash password
            final String hash = calculateHash(in.password());
            in.hashpassword(hash);
            in.password(null);
            return clientRepository.save(new ClientModel(in)).to();
        } 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Client update(Client in) {
        ClientModel aux = new ClientModel(in);
        aux.setId(in.id());
        return clientRepository.save(aux).to();
    }


    private String calculateHash(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte [] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
        byte [] encoded = Base64.getEncoder().encode(hash);
        return new String(encoded);
    }

}
