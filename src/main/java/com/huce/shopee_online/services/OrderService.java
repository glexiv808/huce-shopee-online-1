package com.huce.shopee_online.services;

import com.huce.shopee_online.entities.CustomerOrder;
import com.huce.shopee_online.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<CustomerOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public CustomerOrder getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public CustomerOrder saveOrder(CustomerOrder customerOrder) {
        return orderRepository.save(customerOrder);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

