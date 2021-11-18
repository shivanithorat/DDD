package com.tw.ddd_workshop.domain.event;

public class ProductAddedEvent implements DomainEvent {
    private String productName;

    public ProductAddedEvent(String productName) {
        this.productName = productName;
    }

    @Override
    public String getProductName() {
        return productName;
    }
}
