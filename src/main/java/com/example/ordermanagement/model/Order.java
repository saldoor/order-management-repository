package com.example.ordermanagement.model;

import lombok.*;

import java.util.UUID;


public class Order {
    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    private UUID orderId;
    private String orderName;

}