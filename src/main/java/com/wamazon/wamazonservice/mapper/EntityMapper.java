package com.wamazon.wamazonservice.mapper;

import com.wamazon.wamazonservice.dto.IdentifiableDto;
import com.wamazon.wamazonservice.entity.IdentifiableEntity;

public interface EntityMapper<E extends IdentifiableEntity, D extends IdentifiableDto> {

    E mapToEntity(D dto);

    D mapToDto(E entity);
}
