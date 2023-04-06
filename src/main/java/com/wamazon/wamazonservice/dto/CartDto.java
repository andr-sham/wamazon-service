package com.wamazon.wamazonservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CartDto extends VersionedDto {

    private List<ProductDto> products = new ArrayList<>();

    private BigDecimal totalCost;

    private Integer rublesPerDollar;

    public BigDecimal getTotalCost() {
        return products.stream().map(ProductDto::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
