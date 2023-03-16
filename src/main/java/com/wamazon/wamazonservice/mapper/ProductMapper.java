package com.wamazon.wamazonservice.mapper;

import com.wamazon.wamazonservice.dto.ProductDto;
import com.wamazon.wamazonservice.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProductMapper implements EntityMapper<Product, ProductDto> {

    public abstract Product mapToEntity(ProductDto dto);

    public abstract ProductDto mapToDto(Product entity);

}
