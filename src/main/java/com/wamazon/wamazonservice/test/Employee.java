package com.wamazon.wamazonservice.test;

/**
 * Сотрудник
 */
public class Employee extends User {

    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}