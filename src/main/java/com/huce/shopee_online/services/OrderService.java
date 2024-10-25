package com.huce.shopee_online.services;


import com.huce.shopee_online.database.SequenceGeneratorService;
import com.huce.shopee_online.entities.Order;
import com.huce.shopee_online.repositories.OrderRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;


    public Order insert(Order newOrder){
        Long id = sequenceGeneratorService
                .generateSequence(Order.SEQUENCE_NAME);
        newOrder.setId(id);
        return orderRepository.insert(newOrder);

    }

    public Order update(Order modifiedOrder){
        return orderRepository.save(modifiedOrder);
    }
}
