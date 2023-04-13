package com.wamazon.wamazonservice.controller;

import com.wamazon.wamazonservice.dto.OrderDto;
import com.wamazon.wamazonservice.dto.UserDetails;
import com.wamazon.wamazonservice.mapper.OrderMapper;
import com.wamazon.wamazonservice.service.IOrderService;
import com.wamazon.wamazonservice.service.UserDetailsContextService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserDetailsContextService userDetailsContextService;

    @Autowired
    private IOrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @RolesAllowed(value = "USER")
    @GetMapping("{id}")
    public OrderDto get(@PathVariable Long id) {
        UserDetails userDetails = userDetailsContextService.getUserDetails();
        return orderMapper.mapToDto(orderService.get(id));
    }

    @PostMapping("/create")
    public OrderDto createOrderFromUserCart() {
        return orderMapper.mapToDto(orderService.createOrderFromUserCart());
    }
}
