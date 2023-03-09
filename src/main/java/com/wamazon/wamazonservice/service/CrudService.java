package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.IdentifiableEntity;
import com.wamazon.wamazonservice.exception.NotFoundException;
import com.wamazon.wamazonservice.repository.IBaseRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class CrudService<T extends IdentifiableEntity> implements ICrudService<T> {

    public abstract IBaseRepository<T> getRepository();

    @Override
    public T save(T entityToSave) {
        T savedEntity = getRepository().save(entityToSave);

        return savedEntity;
    }

    @Override
    public T get(Long id) {
        return getRepository().findById(id).orElseThrow(() -> new NotFoundException("Объект с id не найден"));
    }

    @Override
    public void delete(Long id) {
        getRepository().deleteById(id);
    }
}
