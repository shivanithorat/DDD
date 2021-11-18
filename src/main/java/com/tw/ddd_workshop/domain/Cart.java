package com.tw.ddd_workshop.domain;

import com.tw.ddd_workshop.domain.event.DomainEvent;
import com.tw.ddd_workshop.domain.event.ProductAddedEvent;
import com.tw.ddd_workshop.domain.event.ProductRemovedEvent;
import com.tw.ddd_workshop.domain.items.Item;
import com.tw.ddd_workshop.domain.items.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Cart {
    private List<Item> items = new ArrayList<>();

    private List<DomainEvent> events = new ArrayList<>();
    private Boolean isCheckedOut = false;

    public void addItem(Item item) {
        ProductAddedEvent productAddedEvent = new ProductAddedEvent(item.getProduct().getName());
        apply(productAddedEvent, item);
    }

    public List<Item> getItems() {
        return items.stream()
                .filter(cartItem -> cartItem.isInCart())
                .collect(Collectors.toList());
    }

    public void removeItem(Item item) {
        ProductRemovedEvent productRemovedEvent = new ProductRemovedEvent(item.getProduct().getName());
        apply(productRemovedEvent, item);
    }

    public void remove(String itemName) {

        for (Item item : items) {
            if (item.getProduct().getName().equals(itemName))
                item.setInCart(false);
        }
    }

    public Set<String> getDeletedItems() {
        Set<String> collect = events.stream().filter(events -> events instanceof ProductRemovedEvent)
                .map(events -> events.getProductName()).collect(Collectors.toSet());
        return collect;
    }

    public Boolean getCheckedOut() {
        return isCheckedOut;
    }

    private void apply(DomainEvent domainEvent, Item item) {
        if (domainEvent instanceof ProductAddedEvent) {
            items.add(item);
        } else {
            remove(item.getProduct().getName());
        }
        events.add(domainEvent);
    }

    public Order checkout() {
        ArrayList<Product> products = new ArrayList<>();
        for (Item item: items) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            while (quantity > 0) {
                products.add(product);
                quantity--;
            }
        }
        isCheckedOut = true;
        return new Order(products);
    }
    //    public Order checkout_1() {
    //        List<ArrayList<Product>> collect = items.stream().map(item -> {
    //            ArrayList<Product> products = new ArrayList<>();
    //            Product product = item.getProduct();
    //            int quantity = item.getQuantity();
    //            while (quantity > 0) {
    //                products.add(product);
    //                quantity--;
    //            }
    //            return products;
    //        }).collect(Collectors.toList());
    //        isCheckedOut = true;
    //        return new Order(collect);
    //    }
}
