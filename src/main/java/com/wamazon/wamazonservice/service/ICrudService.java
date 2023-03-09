package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.IdentifiableEntity;

public interface ICrudService<T extends IdentifiableEntity> {

    T save(T entityToSave);

    T get(Long id);

    void delete(Long id);
}
