package com.chrisbry.order.service.service;

import com.chrisbry.order.service.entity.Order;
import com.chrisbry.order.service.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        log.info("Inside getAllOrders of OrderService");
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        log.info("Inside createOrder of OrderService");
        return orderRepository.save(order);
    }


    public Order findByOrderId(Long orderId) {
        log.info("Inside findOrderById of OrderService");
        return orderRepository.findByOrderId(orderId);
    }
}
