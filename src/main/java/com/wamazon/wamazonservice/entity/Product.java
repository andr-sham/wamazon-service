package com.wamazon.wamazonservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Product extends VersionedEntity {

    /**
     * Название
     */
    @Column(nullable = false, updatable = false)
    private String name;

    /**
     * Описание
     */
    private String description;

    /**
     * Цена
     */
    private BigDecimal price;
}
