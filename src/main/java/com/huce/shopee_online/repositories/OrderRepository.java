package com.huce.shopee_online.repositories;

import com.huce.shopee_online.entities.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Long>
{



}
