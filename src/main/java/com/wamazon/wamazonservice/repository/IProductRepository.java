package com.wamazon.wamazonservice.repository;

import com.wamazon.wamazonservice.entity.Product;

import java.util.List;

public interface IProductRepository extends IBaseRepository<Product> {

    List<Product> findByName(String name);
}
