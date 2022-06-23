package com.example.ordermanagement.controller;

import com.example.ordermanagement.entity.OrderEntity;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/order")
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/save")
    public OrderEntity saveOrder(@RequestBody Order order) {

        return orderService.saveOrder(order);
    }

    @GetMapping("/getAllOrder")
    public List<OrderEntity> getAllOrder() {
        return orderService.getAllOrder();
    }
}
