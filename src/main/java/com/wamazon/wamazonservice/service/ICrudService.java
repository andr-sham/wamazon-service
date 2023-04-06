package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.dto.ProductFilter;
import com.wamazon.wamazonservice.entity.VersionedEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICrudService<T extends VersionedEntity> {

    T save(T entityToSave);

    T get(Long id);

    void delete(Long id);

    Page<T> findPage(ProductFilter productFilter, Pageable pageable);
}
