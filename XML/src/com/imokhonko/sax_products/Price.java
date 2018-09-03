package com.imokhonko.sax_products;

public class Price {

    private final float amount;
    private final String currency;

    public Price(float amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Price{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
