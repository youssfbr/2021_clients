package com.github.youssfbr.clients.rest;

import com.github.youssfbr.clients.model.entities.Client;
import com.github.youssfbr.clients.model.repositories.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository repository;

    public ClientController(final ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@Valid @RequestBody Client client) {
        return repository.save(client);
    }

    @PutMapping("{id}")
    public Client update(@PathVariable long id, @Valid @RequestBody Client updateClient) {
        return repository
                .findById(id)
                .map(client -> {
                    client.setName(updateClient.getName());
                    client.setCpf(updateClient.getCpf());
                    return repository.save(updateClient);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository
               .findById(id)
                .map( client -> {
                    repository.delete(client);
                    return Void.TYPE;
                })
               .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
