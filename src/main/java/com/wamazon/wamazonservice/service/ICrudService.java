package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.VersionedEntity;

public interface ICrudService<T extends VersionedEntity> {

    T save(T entityToSave);

    T get(Long id);

    void delete(Long id);
}
