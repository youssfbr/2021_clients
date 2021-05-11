package com.github.youssfbr.clients.rest;

import com.github.youssfbr.clients.model.entities.Client;
import com.github.youssfbr.clients.model.repositories.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository repository;

    public ClientController(final ClientRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return repository.save(client);
    }
}
