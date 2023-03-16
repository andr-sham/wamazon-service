package com.wamazon.wamazonservice.mapper;

import com.wamazon.wamazonservice.dto.OrderDto;
import com.wamazon.wamazonservice.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class OrderMapper implements EntityMapper<Order, OrderDto> {

    public abstract Order mapToEntity(OrderDto dto);

    public abstract OrderDto mapToDto(Order entity);

}
