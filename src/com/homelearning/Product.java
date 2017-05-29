package com.homelearning;

public enum Product {
    CHOCOLATE {{price = 20;}},
    CARAMEL {{price = 8;}},
    VINE {{price = 160;}},
    TOY {{price = 200;}},
    PHONE {{price = 10_000;}};

    protected int price;

    public int getPrice() {
        return price;
    }
}
