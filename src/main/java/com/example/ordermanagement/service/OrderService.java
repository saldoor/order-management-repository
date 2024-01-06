package com.example.ordermanagement.service;

import com.example.ordermanagement.entity.OrderEntity;
import com.example.ordermanagement.mapper.OrderMapper;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity saveOrder(Order order) {
        return orderRepository.save(OrderMapper.INSTANCE.toEntity(order));
    }

    public List<Order> getAllOrder() {
        return OrderMapper.INSTANCE.toModelList(orderRepository.findAll());
    }
}
