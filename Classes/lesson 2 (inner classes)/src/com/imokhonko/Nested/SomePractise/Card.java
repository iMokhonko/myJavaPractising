package com.imokhonko.Nested.SomePractise;

public class Card {

    private final Account account;
    private final String number;
    private final CardTypes cardType;
    private long amount;

    public Card(Account account, String number, CardTypes cardType) {
        this.account = account;
        this.number = number;
        this.cardType = cardType;
    }

    public Account getAccount() {
        return account;
    }

    public long getAmount() {
        return amount;
    }

    public String getNumber() {
        return number;
    }

    public CardTypes getCardType() {
        return cardType;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public boolean withDrawMoney(final long amount) {
        if(amount <= getAmount () && amount > 0) {
            this.amount -= amount;
            return true;
        }
        return false;
    }

    public boolean putMoney(final long amount) {
        if(amount > 0) {
            this.amount += amount;
            return true;
        }
        return false;
    }

    public enum CardTypes {

        UNIVERSAL,
        UNIVERSAL_GOLD,
        JUNIOR,
        PAYMENTS,
        VIP,
        INTERNET,
        SOCIAL,
        PENSION;

    }

}
