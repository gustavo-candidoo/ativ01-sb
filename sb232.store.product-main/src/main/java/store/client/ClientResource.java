package store.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class ClientResource {

    @Autowired
    private ClientService clientService;

    @GetMapping("/client")
    public List<ClientOut> list() {
        return clientService.list().stream().map(ClientParser::to).toList();
    }

    @GetMapping("/client/{id}")
    public ClientOut get(@PathVariable(required = true) String id) {
        Client found = clientService.find(id);
        return found == null ? null : ClientParser.to(found);
    }

    @DeleteMapping("/client/{id}")
    public void delete(@PathVariable(required = true) String id) {
        clientService.delete(id);
    }

    @PostMapping("/client")
    public void create(@RequestBody ClientIn in) {
        clientService.create(ClientParser.to(in));

    }

    @PutMapping("/client/{id}")
    public void update(@PathVariable(required = true) String id, @RequestBody ClientIn in) {
        Client old = clientService.find(id);
        Client novo = ClientParser.to(in);
        if (old != null) {

            old.name(novo.name())
                    .cpf(novo.cpf())
                    .email(novo.email())
                    .password(novo.password());

            clientService.update(old);
        } else {
            ResponseEntity.notFound().build();
        }


}}


