package com.wamazon.wamazonservice.repository;

import com.wamazon.wamazonservice.entity.Cart;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICartRepository extends IBaseRepository<Cart> {

    Optional<Cart> findByUserId(Long id);
}
