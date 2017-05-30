package com.homelearning;

public enum Product {
    CHOCOLATE(20),
    CARAMEL(8),
    VINE(160),
    TOY(200),
    PHONE(10_000);

    private int price;

    Product(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
