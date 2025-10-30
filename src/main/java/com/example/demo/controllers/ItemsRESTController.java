package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Item;
import com.example.demo.services.ItemService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemsRESTController {

    private final ItemService items_service;

    @GetMapping("/all")
    public List<Item> get_all()
    {
        return items_service.get_all();
    }

    @GetMapping("/get/{_id}")
    public Optional<Item> get_by_id(@PathVariable Long _id)
    {
        return items_service.get(_id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Item _item)
    {
        items_service.add(_item);
    }

    @PutMapping("/update")
    public void update(@RequestBody Item _item)
    {
        Optional<Item> item = items_service.get(_item.getId_item());

        if (item.isEmpty()) {
            items_service.update(_item);
        }
    }

    @DeleteMapping("/delete/{_id}")
    public void delete(@PathVariable Long _id)
    {
        items_service.delete(_id);
    }
}
