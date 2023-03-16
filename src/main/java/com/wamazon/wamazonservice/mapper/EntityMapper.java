package com.wamazon.wamazonservice.mapper;

import com.wamazon.wamazonservice.dto.VersionedDto;
import com.wamazon.wamazonservice.entity.VersionedEntity;

public interface EntityMapper<E extends VersionedEntity, D extends VersionedDto> {

    E mapToEntity(D dto);

    D mapToDto(E entity);
}
