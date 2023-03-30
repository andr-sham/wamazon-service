package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.Order;
import com.wamazon.wamazonservice.entity.Product;
import com.wamazon.wamazonservice.exception.NotFoundException;
import com.wamazon.wamazonservice.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public Order get(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Заказ не найден"));
        List<Product> products = order.getProducts();
        Product product = products.get(0);
        product.setName("!!!!!!!!!!!!");
        return order;
    }
}
