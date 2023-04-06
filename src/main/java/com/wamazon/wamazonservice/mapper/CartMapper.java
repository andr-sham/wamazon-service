package com.wamazon.wamazonservice.mapper;

import com.wamazon.wamazonservice.dto.CartDto;
import com.wamazon.wamazonservice.entity.Cart;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class CartMapper implements EntityMapper<Cart, CartDto> {

    public abstract Cart mapToEntity(CartDto dto);

    public abstract CartDto mapToDto(Cart entity);

}
