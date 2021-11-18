package com.tw.ddd_workshop.domain.event;

public class ProductRemovedEvent implements DomainEvent{
    private String productName;

    public ProductRemovedEvent(String productName) {
        this.productName = productName;
    }

    @Override
    public String getProductName() {
        return productName;
    }
}
