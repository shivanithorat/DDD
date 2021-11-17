package com.tw.ddd_workshop.domain;

import com.tw.ddd_workshop.domain.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }
    public List<Item> getItems() {
        return items;
    }
}
