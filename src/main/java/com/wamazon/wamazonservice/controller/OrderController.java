package com.wamazon.wamazonservice.controller;

import com.wamazon.wamazonservice.dto.OrderDto;
import com.wamazon.wamazonservice.mapper.OrderMapper;
import com.wamazon.wamazonservice.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @GetMapping("/{id}")
    public OrderDto get(@PathVariable Long id) {
        return orderMapper.mapToDto(orderService.get(id));
    }
}
