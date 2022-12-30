package com.wamazon.wamazonservice.dto;

/**
 * Продавец
 */
public class Seller extends User {

    private String inn;

    private String organizationName;

    private String address;


    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
