package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.Cart;

public interface ICartService {
    void addProductToCart(Long productId);

    Cart getUserCart();
}
