package com.wamazon.wamazonservice.controller;

import com.wamazon.wamazonservice.dto.IdentifiableDto;
import com.wamazon.wamazonservice.dto.valiation.Create;
import com.wamazon.wamazonservice.dto.valiation.Update;
import com.wamazon.wamazonservice.entity.IdentifiableEntity;
import com.wamazon.wamazonservice.mapper.EntityMapper;
import com.wamazon.wamazonservice.service.ICrudService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Универсальные CRUD контроллер, позволяющий совершать CRUD операции с сущностями
 */
public abstract class CrudController<E extends IdentifiableEntity, D extends IdentifiableDto> {

    public abstract ICrudService<E> getService();

    public abstract EntityMapper<E, D> getMapper();

    @GetMapping("/{id}")
    public D get(@PathVariable Long id) {
        E entity = getService().get(id);
        return getMapper().mapToDto(entity);
    }

    @PostMapping
    public D save(@RequestBody @Validated(Create.class) D dtoToSave) {
        E entity = getMapper().mapToEntity(dtoToSave);
        entity = getService().save(entity);
        return getMapper().mapToDto(entity);
    }

    @PutMapping
    public D update(@RequestBody @Validated(Update.class) D dtoToUpdate) {
        E entity = getMapper().mapToEntity(dtoToUpdate);
        entity = getService().save(entity);
        return getMapper().mapToDto(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        getService().delete(id);
    }
}
