package com.homelearning;

public enum Product {
    Chocolate{{price = 20;}},
    Caramel{{price = 8;}},
    Vine{{price = 160;}},
    Toy{{price = 200;}},
    Phone{{price = 10_000;}};

    protected int price;

    public int getPrice() {
        return price;
    }
}
