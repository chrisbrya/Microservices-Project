package com.chrisbry.order.service.controller;

import com.chrisbry.order.service.entity.Order;
import com.chrisbry.order.service.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders() {
        log.info("Inside getAllOrders of OrderController");
        return orderService.getAllOrders();
    }

    @PostMapping("/")
    public Order createOrder(@RequestBody Order order){
        log.info("Inside createOrder of OrderController");
        return orderService.createOrder(order);
    }

    @GetMapping("/{id}")
    public Order findByOrderId(@PathVariable("id") Long orderId) {
        log.info("Inside findByOrderId of OrderController");
        return orderService.findByOrderId(orderId);
    }
}
