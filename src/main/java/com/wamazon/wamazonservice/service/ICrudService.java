package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.IdentifiableEntity;

public interface ICrudService<T extends IdentifiableEntity> {

    T save(T entityToSave);

    T get(Long id);

    T update(T entityToUpdate);

    void delete(Long id);
}
