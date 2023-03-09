package com.wamazon.wamazonservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "order")
@Getter
@Setter
public class Order extends IdentifiableEntity {

    @ManyToMany
    @JoinTable(
            name = "order_id",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_product")
    )
    private List<Product> products;
}
