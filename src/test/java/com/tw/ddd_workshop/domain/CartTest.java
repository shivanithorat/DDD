package com.tw.ddd_workshop.domain;

import com.tw.ddd_workshop.domain.items.*;
import com.tw.ddd_workshop.domain.price.Discount;
import com.tw.ddd_workshop.domain.price.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Currency;
import java.util.List;

class CartTest {

    @Test
    public void testItemAdded() {
        Cart cart = new Cart();
        Item item = new Item(new Product("IPad"), 1);
        cart.addItem(item);
        List<Item> items = cart.getItems();
        Assertions.assertEquals(1, items.size());
        Assertions.assertEquals("IPad", items.get(0).getProduct().getName());
        Assertions.assertEquals(1, items.get(0).getQuantity());
    }

    @Test
    public void testPenAdded() {
        Cart cart = new Cart();
        Item item = new Item(new Product("Hero ink Pen"), 1);
        cart.addItem(item);
        List<Item> items = cart.getItems();
        Assertions.assertEquals(1, items.size());
        Assertions.assertEquals("Hero ink Pen", items.get(0).getProduct().getName());
        Assertions.assertEquals(1, items.get(0).getQuantity());
    }

    @Test
    public void testPenAndIPadAdded() {
        Cart cart = new Cart();
        Item item = new Item(new Product("Hero ink Pen"), 1);
        Item item2 = new Item(new Product("IPad"), 1);
        cart.addItem(item);
        cart.addItem(item2);
        List<Item> items = cart.getItems();
        Assertions.assertEquals(2, items.size());
        Assertions.assertEquals("Hero ink Pen", items.get(0).getProduct().getName());
        Assertions.assertEquals("IPad", items.get(1).getProduct().getName());
        Assertions.assertEquals(1, items.get(0).getQuantity());
        Assertions.assertEquals(1, items.get(1).getQuantity());
    }

    @Test
    public void testPenAndIPadRemoved() {
        Cart cart = new Cart();
        Item item = new Item(new Product("Hero ink Pen"), 1);
        Item item2 = new Item(new Product("IPad"), 1);
        cart.addItem(item);
        cart.addItem(item2);
        Assertions.assertEquals(2, cart.getItems().size());

        cart.removeItem(item2);
        Assertions.assertEquals(1, cart.getItems().size());
        Assertions.assertEquals(1, cart.getDeletedItems().size());
    }

    @Test
    public void testAddTwoGmBats() {
        Cart cart = new Cart();
        Item item = new Item(new Product("GM Cricket bat"), 2);
        cart.addItem(item);
        List<Item> items = cart.getItems();
        Assertions.assertEquals(1, items.size());
        Assertions.assertEquals("GM Cricket bat", items.get(0).getProduct().getName());
        Assertions.assertEquals(2, items.get(0).getQuantity());
    }

    @Test
    public void noTwoCartsShouldBeEqual() {
        Cart cart1 = new Cart();

        Cart cart2 = new Cart();
        Item item1 = new Item(new Product("IPad"), 2);
        Item item2 = new Item(new Product("IPad"), 2);

        cart1.addItem(item1);
        cart2.addItem(item2);
        Assertions.assertNotEquals(cart1, cart2);

    }

    @Test
    public void testItemAddedWithPrice() {
        Cart cart = new Cart();
        Item item = new Item(new Product("IPad", new Price(Currency.getInstance("USD"), 300.0)), 1);
        cart.addItem(item);
        List<Item> items = cart.getItems();
        Assertions.assertEquals(1, items.size());
        Assertions.assertEquals("IPad", items.get(0).getProduct().getName());
        Assertions.assertEquals(1, items.get(0).getQuantity());
        Assertions.assertEquals("300.0 USD", items.get(0).getProduct().getPrice().toString());
    }

    @Test
    public void testItemAddedWithDiscountedPrice() {
        Cart cart = new Cart();
        Discount discount = new Discount(10.0);
        Item item = new Item(new Product("IPad", discount.getDiscountedPrice("IPad")), 1);
        cart.addItem(item);
        List<Item> items = cart.getItems();
        Assertions.assertEquals(1, items.size());
        Assertions.assertEquals("IPad", items.get(0).getProduct().getName());
        Assertions.assertEquals(1, items.get(0).getQuantity());
        Assertions.assertEquals("450.0 USD", items.get(0).getProduct().getPrice().toString());
    }

    @Test
    public void twoPricesShouldBeEqual() {
        Price usd = new Price(Currency.getInstance("USD"), 100.0);
        Price usd2 = new Price(Currency.getInstance("USD"), 100.0);
        Assertions.assertEquals(usd,usd2);
    }

    @Test
    public void checkoutOrders() {

        Cart cart1 = new Cart();
        Discount discount = new Discount(10.0);
        Item item1 = new Item(new Product("IPad", discount.getDiscountedPrice("IPad")), 2);
        cart1.addItem(item1);
        Order checkout = cart1.checkout();
        Assertions.assertEquals(2, checkout.getProducts().size());
        Assertions.assertTrue(cart1.getCheckedOut());

    }

}










