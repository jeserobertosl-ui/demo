package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Client;
import com.example.demo.services.ClientService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientRESTController{

    private final ClientService service;

    @GetMapping("/all")
    public List<Client> get_all()
    {
        return service.get_all();
    }

    @GetMapping("/get/{_id}")
    public Optional<Client> get_by_id(@PathVariable Long _id)
    {
        return service.get(_id);
    }

    @PostMapping("/add")
    public String add(@RequestBody Client _client)
    {
        return service.add(_client);
    }

    @PutMapping("/update")
    public void update(@RequestBody Client _client)
    {
        Optional<Client> client = service.get(_client.getId_client());

        if (client.isPresent()) {
            service.add(_client);
        }
    }

    @DeleteMapping("/delete/{_id}")
    public void delete(@PathVariable Long _id)
    {
        service.delete(_id);
    }
}
