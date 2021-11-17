package com.tw.ddd_workshop.domain;

import com.tw.ddd_workshop.domain.items.Item;
import com.tw.ddd_workshop.domain.items.Pen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.tw.ddd_workshop.domain.items.IPad;

import java.util.List;

class CartTest {

    @Test
    public void testItemAdded() {
        Cart cart = new Cart();
        cart.addItem(new IPad("IPad"));
        List<Item> items = cart.getItems();
        Assertions.assertEquals(1, items.size());
        Assertions.assertEquals("IPad",items.get(0).getName());
        Assertions.assertEquals("Tablet",items.get(0).getType());
    }

    @Test
    public void testPenAdded() {
        Cart cart = new Cart();
        cart.addItem(new Pen("Hero ink Pen"));
        List<Item> items = cart.getItems();
        Assertions.assertEquals(1, items.size());
        Assertions.assertEquals("Hero ink Pen",items.get(0).getName());
        Assertions.assertEquals("Stationary",items.get(0).getType());
    }

    @Test
    public void testPenAndIPadAdded() {
        Cart cart = new Cart();
        cart.addItem(new Pen("Hero ink Pen"));
        cart.addItem(new IPad("IPad"));
        List<Item> items = cart.getItems();
        Assertions.assertEquals(2, items.size());
        Assertions.assertEquals("Hero ink Pen",items.get(0).getName());
        Assertions.assertEquals("IPad",items.get(1).getName());
    }
}