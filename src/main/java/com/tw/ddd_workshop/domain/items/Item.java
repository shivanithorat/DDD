package com.tw.ddd_workshop.domain.items;

public class Item {
    private Product product;
    private int quantity;
    private boolean inCart;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.inCart = true;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public Item setInCart(boolean inCart) {
        this.inCart = inCart;
        return this;
    }

    public boolean isInCart() {
        return inCart;
    }
}
