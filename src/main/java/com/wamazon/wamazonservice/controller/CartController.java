package com.wamazon.wamazonservice.controller;

import com.wamazon.wamazonservice.dto.CartDto;
import com.wamazon.wamazonservice.mapper.CartMapper;
import com.wamazon.wamazonservice.service.DollarConverterService;
import com.wamazon.wamazonservice.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;

    @Autowired
    private CartMapper cartMapper;


    @Autowired
    private DollarConverterService dollarConverterService;

    @GetMapping
    public CartDto getUserCart() {
        CartDto userCart = cartMapper.mapToDto(cartService.getUserCart());

        userCart.setRublesPerDollar(dollarConverterService.getRublesByDollar());

        return userCart;
    }

    @PutMapping("/add-product/{productId}")
    public void addProductToCart(@PathVariable Long productId) {
        cartService.addProductToCart(productId);
    }
}
