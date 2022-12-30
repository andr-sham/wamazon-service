package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.dto.Product;

import java.util.List;

public interface IProductService extends ICrudService<Product> {
    List<Product> findByName(String name);

}
