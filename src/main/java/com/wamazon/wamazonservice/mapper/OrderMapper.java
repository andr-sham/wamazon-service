package com.wamazon.wamazonservice.mapper;

import com.wamazon.wamazonservice.dto.OrderDto;
import com.wamazon.wamazonservice.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper implements EntityMapper<Order, OrderDto> {

    @Autowired
    ProductMapper productMapper;

    @Override
    public Order mapToEntity(OrderDto dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setCreationDate(dto.getCreationDate());
        order.setProducts(dto.getProducts().stream().map(productMapper::mapToEntity).collect(Collectors.toList()));
        return order;
    }

    @Override
    public OrderDto mapToDto(Order entity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(entity.getId());
        orderDto.setCreationDate(entity.getCreationDate());
        orderDto.setProducts(entity.getProducts().stream().map(productMapper::mapToDto).collect(Collectors.toList()));
        return orderDto;
    }
}
