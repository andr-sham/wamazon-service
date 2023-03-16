package com.wamazon.wamazonservice.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class VersionedEntity extends IdentifiableEntity {

    @Version
    private Long version;

}
