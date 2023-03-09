package com.wamazon.wamazonservice.service;

import com.wamazon.wamazonservice.entity.IdentifiableEntity;
import com.wamazon.wamazonservice.exception.NotFoundException;
import com.wamazon.wamazonservice.repository.IBaseRepository;

public abstract class CrudService<T extends IdentifiableEntity> implements ICrudService<T> {

    public abstract IBaseRepository<T> getRepository();

    protected abstract boolean validate(T entity);

    @Override
    public T save(T entityToSave) {
        if (entityToSave.getId() != null) {
            throw new RuntimeException("Ошибка сохранения");
        }

        validate(entityToSave);
        return getRepository().save(entityToSave);
    }

    @Override
    public T get(Long id) {
        return getRepository().findById(id).orElseThrow(() -> new NotFoundException("Объект с id не найден"));
    }

    @Override
    public T update(T entityToUpdate) {
        if (entityToUpdate.getId() == null) {
            throw new RuntimeException("Ошибка обновления");
        }

        validate(entityToUpdate);
        return getRepository().save(entityToUpdate);
    }

    @Override
    public void delete(Long id) {
        getRepository().deleteById(id);
    }
}
