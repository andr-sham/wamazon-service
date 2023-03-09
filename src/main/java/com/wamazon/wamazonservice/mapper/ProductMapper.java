package com.wamazon.wamazonservice.mapper;

import com.wamazon.wamazonservice.dto.ProductDto;
import com.wamazon.wamazonservice.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements EntityMapper<Product, ProductDto> {

    @Override
    public Product mapToEntity(ProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
        return product;
    }

    @Override
    public ProductDto mapToDto(Product entity) {
        ProductDto productDto = new ProductDto();
        productDto.setId(entity.getId());
        productDto.setName(entity.getName());
        productDto.setPrice(entity.getPrice());
        productDto.setDescription(entity.getDescription());
        return productDto;
    }
}
