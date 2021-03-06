package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientDAO {

    private final ClientRepository repo;

    public ClientEntity create(String name) {
        ClientEntity client = new ClientEntity();
        client.setName(name);
        return repo.save(client);
    }

    public boolean update(Integer id, String name) {
        ClientEntity client = repo.findById(id).get();
        if (client == null) {
            return false;
        } else {
            client.setName(name);
            repo.save(client);
            return true;
        }
    }
}
