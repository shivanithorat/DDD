package com.tw.ddd_workshop.domain.price;

import java.util.Currency;
import java.util.HashMap;

public class Discount {
    private static HashMap<String, Price> competitorPrices = new HashMap();
    private Double discountPercentage;

    public Discount(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    static {
        competitorPrices.put("IPad", new Price(Currency.getInstance("USD"), 500.0));
        competitorPrices.put("GM Cricket bat", new Price(Currency.getInstance("USD"), 100.0));
    }

    public Price getDiscountedPrice(String productName) {
        if (competitorPrices.containsKey(productName)) {
            Price price = competitorPrices.get(productName);
            double discountedPrice = price.getAmount() * (100 - discountPercentage) / 100;
            return new Price(price.getCurrency(), discountedPrice);
        }
        return null;

    }
}
