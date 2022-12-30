package com.wamazon.wamazonservice.repository;


import com.wamazon.wamazonservice.dto.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository extends CrudRepository<Product> {
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();

        for (Product product : database) {
            String productName = product.getName();
            if (productName.contains(name)) {
                result.add(product);
            }
        }

        return result;
    }
}
