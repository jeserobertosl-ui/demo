package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.services.OrderService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderRESTController {

    private final OrderService order_service;

    @GetMapping("/all")
    public List<Order> get_all()
    {
        return order_service.get_all();
    }

    @GetMapping("/get/{_id}")
    public Optional<Order> get_by_id(@PathVariable Long _id)
    {
        return order_service.get(_id);
    }

    @PostMapping("/add")
    public String add(@RequestBody Order _order)
    {
        return order_service.add(_order);
    }

    @PutMapping("/update")
    public void update(@RequestBody Order _order)
    {
        Optional<Order> order = order_service.get(_order.getId_order());

        if (order.isEmpty()) {
            order_service.update(_order);
        }
    }

    @DeleteMapping("/delete/{_id}")
    public void delete(@PathVariable Long _id)
    {
        order_service.delete(_id);
    }
}
