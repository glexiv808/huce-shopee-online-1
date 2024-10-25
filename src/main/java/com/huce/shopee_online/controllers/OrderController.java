package com.huce.shopee_online.controllers;

import com.huce.shopee_online.entities.CustomerOrder;
import com.huce.shopee_online.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping
    public List<CustomerOrder> getAllOrders() {
        return customerOrderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public CustomerOrder getOrderById(@PathVariable Long id) {
        return customerOrderService.getOrderById(id);
    }

    @PostMapping
    public CustomerOrder createOrder(@RequestBody CustomerOrder customerOrder) {
        return customerOrderService.saveOrder(customerOrder);
    }

    @PutMapping("/{id}")
    public CustomerOrder updateOrder(@PathVariable Long id, @RequestBody CustomerOrder customerOrder) {
        customerOrder.setId(id);
        return customerOrderService.saveOrder(customerOrder);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        customerOrderService.deleteOrder(id);
    }
}
