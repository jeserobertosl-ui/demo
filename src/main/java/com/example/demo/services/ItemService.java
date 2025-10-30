package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Item;
import com.example.demo.repositories.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository item_repository;

    public List<Item> get_all()
    {
        return item_repository
            .findAll()
            .stream()
            .collect(Collectors.toList());
    }

    public Optional<Item> get(Long _id)
    {
        return item_repository.findById(_id);
    }

    public void add(Item _item)
    {
        item_repository.save(_item);
    }

    public void update(Item _item)
    {
        item_repository.save(_item);
    }

    public void delete(Long _id)
    {
        item_repository.deleteById(_id);
    }
}
