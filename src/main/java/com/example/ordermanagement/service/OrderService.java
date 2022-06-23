package com.example.ordermanagement.service;

import com.example.ordermanagement.entity.OrderEntity;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.OrderRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderEntity saveOrder(Order order) {

        OrderEntity orderEntity = OrderEntity.builder()
                .orderName(order.getOrderName())
                .build();
        return orderRepository.save(orderEntity);
    }

    public List<OrderEntity> getAllOrder() {
        return orderRepository.findAll();
    }
}
