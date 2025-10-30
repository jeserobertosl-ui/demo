package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Client;
import com.example.demo.repositories.ClientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService{

    private final ClientRepository client_repository;
    
    public List<Client> get_all()
    {
        return client_repository
            .findAll()
            .stream()
            .collect(Collectors.toList());
    }

    public Optional<Client> get(Long _id)
    {
        return client_repository.findById(_id);
    }

    public void add(Client _client)
    {
        client_repository.save(_client);
    }

    public void update(Client _client)
    {
        client_repository.save(_client);
    }

    public void delete(Long _id)
    {
        client_repository.deleteById(_id);
    }
}
