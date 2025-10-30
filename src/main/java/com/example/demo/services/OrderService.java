package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Order;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.ItemRepository;
import com.example.demo.repositories.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ClientRepository client_repository;
    private final ItemRepository item_repository;
    private final OrderRepository order_repository;

    public List<Order> get_all()
    {
        return order_repository
            .findAll()
            .stream()
            .collect(Collectors.toList());
    }

    public Optional<Order> get(Long _id)
    {
        return order_repository.findById(_id);
    }

    public String add(Order _order)
    {
        if (
            client_repository.findById(_order.getId_client()).isPresent() &&
            item_repository.findById(_order.getId_item()).isPresent()
        ) 
        {
            order_repository.save(_order);
            return "order saved";
        }
        return "error: invalid client or item id";
    }

    public void update(Order _order)
    {
        order_repository.save(_order);
    }

    public void delete(Long _id)
    {
        order_repository.deleteById(_id);
    }
}
