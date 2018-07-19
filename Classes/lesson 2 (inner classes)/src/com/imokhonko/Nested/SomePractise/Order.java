package com.imokhonko.Nested.SomePractise;

import java.util.ArrayList;
import java.util.List;

public class Order {

    List<Good> goodItems = new ArrayList<>();
    private final Client client;
    private long summaryPrice;
    private boolean isConfirmed;

    public Order(List<Good> goodItems, Client client) {
        this.goodItems = goodItems;
        this.client = client;
        setSummaryPrice();
    }

    public void setSummaryPrice() {
        for (Good goodItem : goodItems) {
            this.summaryPrice += goodItem.getPrice ();
        }
    }

    public boolean payOrder(Card card) {
        if(card.withDrawMoney (getSummaryPrice ())) {
            this.isConfirmed = true;
            return true;
        }
        return false;
    }

    public List<Good> getGoodItems() {
        return goodItems;
    }

    public long getSummaryPrice() {
        return summaryPrice;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }
}
