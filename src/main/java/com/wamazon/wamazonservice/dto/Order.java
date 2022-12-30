package com.wamazon.wamazonservice.dto;

import java.util.List;

public class Order extends LongIdDto {

    private List<Product> products;

    public List<Product> getGoods() {
        return products;
    }

    public void setGoods(List<Product> products) {
        this.products = products;
    }
}
