package com.wamazon.wamazonservice.test;

/**
 * Продавец
 */
public class Seller extends User {

    private String email;

    private String inn;

    private String businessEntity;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getBusinessEntity() {
        return businessEntity;
    }

    public void setBusinessEntity(String businessEntity) {
        this.businessEntity = businessEntity;
    }
}
