package com.tw.ddd_workshop.domain.price;

import java.util.Currency;
import java.util.Objects;

public class Price {
    private Currency currency;
    private Double amount;

    public Price(Currency currency, Double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "" + amount + " " + currency.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Objects.equals(currency, price.currency) && Objects.equals(amount, price.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }
}
