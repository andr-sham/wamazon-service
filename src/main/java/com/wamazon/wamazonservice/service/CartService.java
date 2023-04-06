package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.dto.UserDetails;
import com.wamazon.wamazonservice.entity.Cart;
import com.wamazon.wamazonservice.entity.Product;
import com.wamazon.wamazonservice.exception.NotFoundException;
import com.wamazon.wamazonservice.repository.ICartRepository;
import com.wamazon.wamazonservice.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartService implements ICartService {

    @Autowired
    private ICartRepository cartRepository;

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IUserDetailsContextService userDetailsContextService;

    @Autowired
    private DollarConverterService dollarConverterService;

    @Override
    public void addProductToCart(Long productId) {
        Product product =
                productRepository.findById(productId).orElseThrow(() -> new NotFoundException("Продукт не найден"));
        UserDetails userDetails = userDetailsContextService.getUserDetails();

        Cart userCart = cartRepository.findByUserId(userDetails.getId()).orElse(new Cart(userDetails.getId()));
        List<Product> productsInCart = userCart.getProducts();
        productsInCart.add(product);
        cartRepository.save(userCart);
    }

    @Override
    public Cart getUserCart() {
        UserDetails userDetails = userDetailsContextService.getUserDetails();
        Cart cart = cartRepository.findByUserId(userDetails.getId()).orElse(new Cart());

        Integer rublesByDollar = dollarConverterService.getRublesByDollar();


        return cart;
    }
}
