package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.Product;
import com.wamazon.wamazonservice.repository.IBaseRepository;
import com.wamazon.wamazonservice.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends CrudService<Product> implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    @Value("${min.password.length}")
    private Integer minPasswordLength;

    @Override
    public IBaseRepository<Product> getRepository() {
        return productRepository;
    }

    @Override
    protected boolean validate(Product product) {
        if (product.getName() == null) {
            return false;
        }

        return false;
    }

    public int calculateCost(int a, int b) {
        return a + b + 1;
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

}
