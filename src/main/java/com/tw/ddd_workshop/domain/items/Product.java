package com.tw.ddd_workshop.domain.items;

import com.tw.ddd_workshop.domain.price.Price;

public class Product  {
    private String name;
    private Price price;

    public Product(String name) {
        this.name = name;
    }

    public Product(String name, Price price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Price getPrice() {
        return price;
    }
}
