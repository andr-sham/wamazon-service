package com.wamazon.wamazonservice.dto;

public enum UserType {

    SUPPORT(10),
    ADMINISTRATOR(9),
    SELLER(5),
    SELLER_MANAGER(3),
    CLIENT(1);

    UserType(int level) {
        this.level = level;
    }

    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
