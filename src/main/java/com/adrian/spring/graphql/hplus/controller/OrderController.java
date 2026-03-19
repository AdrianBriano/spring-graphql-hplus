package com.adrian.spring.graphql.hplus.controller;

import com.adrian.spring.graphql.hplus.data.Order;
import com.adrian.spring.graphql.hplus.data.OrderRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    private final OrderRepository ordersRepository;

    public OrderController(OrderRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @QueryMapping
    public Iterable<Order> orders() {
        return ordersRepository.findAll();
    }
}
