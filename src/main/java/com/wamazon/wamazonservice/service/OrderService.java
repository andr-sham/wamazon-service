package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.Order;
import com.wamazon.wamazonservice.exception.NotFoundException;
import com.wamazon.wamazonservice.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Order get(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Заказ не найден"));
    }
}
