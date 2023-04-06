package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.Cart;
import com.wamazon.wamazonservice.entity.Order;
import com.wamazon.wamazonservice.exception.GeneralException;
import com.wamazon.wamazonservice.exception.NotFoundException;
import com.wamazon.wamazonservice.repository.IOrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
@AllArgsConstructor
public class OrderService implements IOrderService {

    private final IOrderRepository orderRepository;

    private final ICartService cartService;

    @Override
    public Order get(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Заказ не найден"));
    }

    @Override
    public Order createOrderFromUserCart() {
        Cart userCart = cartService.getUserCart();

        if (userCart.getProducts().isEmpty()) {
            throw new GeneralException("Невозможно создать заказ");
        }

        Order order = new Order();
        order.setCreationDate(LocalDate.now());
        order.getProducts().addAll(userCart.getProducts());

        userCart.getProducts().clear();

        return orderRepository.save(order);
    }
}
