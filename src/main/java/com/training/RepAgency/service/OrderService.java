package com.training.RepAgency.service;

import com.training.RepAgency.entity.Order;
import com.training.RepAgency.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> getById(String id) {
        return orderRepository.findById(id);
    }

    @Transactional
    public int updateOrderSetPaid(Long paid, String orderId) {
        return orderRepository.updateOrderSetPaid(paid, orderId);
    }

    public Long getPaidById(String orderId) {
        return orderRepository.findPaidById(orderId);
    }

}

