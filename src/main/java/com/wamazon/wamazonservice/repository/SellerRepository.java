package com.wamazon.wamazonservice.repository;

import com.wamazon.wamazonservice.dto.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SellerRepository extends UserRepository<Seller> {

    private ProductRepository productRepository;

    @Autowired
    public SellerRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Seller findSellerByOrganizationName(String organizationName) {
        for (Seller user : database) {
            if (user.getOrganizationName().equalsIgnoreCase(organizationName)) {
                return user;
            }
        }

        return null;
    }
}
