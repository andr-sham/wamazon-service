package com.wamazon.wamazonservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDto extends IdentifiableDto {

    private List<ProductDto> products;

}
