package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.Product;
import com.wamazon.wamazonservice.repository.IBaseRepository;
import com.wamazon.wamazonservice.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends CrudService<Product> implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public IBaseRepository<Product> getRepository() {
        return productRepository;
    }

    public List<Product> findByName(String name) {
        return productRepository.findByNameIgnoreCase(name);
    }
}
