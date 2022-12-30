package com.wamazon.wamazonservice.dto;

public class Product extends LongIdDto {

    private String name;

    private String description;

    private Long sellerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sellerId=" + sellerId +
                '}';
    }
}
