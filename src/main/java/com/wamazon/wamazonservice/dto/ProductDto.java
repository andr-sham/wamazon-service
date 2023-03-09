package com.wamazon.wamazonservice.dto;


import com.wamazon.wamazonservice.dto.valiation.Create;
import com.wamazon.wamazonservice.dto.valiation.Update;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Сущность товара
 */
@Getter
@Setter
public class ProductDto extends IdentifiableDto {

    /**
     * Название
     */
    @NotNull(message = "Название товара обязательно для заполнения", groups = {Create.class, Update.class})
    private String name;

    /**
     * Описание
     */
    private String description;

    /**
     * Цена
     */
    @Min(value = 100, message = "Цена должна быть не меньше 100.00 р.", groups = {Create.class, Update.class})
    private BigDecimal price;
}
