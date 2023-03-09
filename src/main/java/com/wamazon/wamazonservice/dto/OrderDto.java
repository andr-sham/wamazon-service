package com.wamazon.wamazonservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class OrderDto extends IdentifiableDto {

    private LocalDate creationDate;

    private List<ProductDto> products;

}
