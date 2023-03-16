package com.wamazon.wamazonservice.dto;

public abstract class VersionedDto extends IdentifiableDto {

    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
