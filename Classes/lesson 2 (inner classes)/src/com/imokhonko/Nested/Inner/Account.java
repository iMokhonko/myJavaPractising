package com.imokhonko.Nested.Inner;

public class Account {

    private final String number;
    private final Human Owner;
    private long amount;

    public Account(String number, Human owner) {
        this.number = number;
        Owner = owner;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getAmount() {
        return amount;
    }

    public String getNumber() {
        return number;
    }

    public Human getOwner() {
        return Owner;
    }

    private boolean putMoney(final long amount) {
        if(amount > 0) {
            this.amount += amount;
            return true;
        }
        return false;
    }

    private boolean withDrawMoney(final long amount) {
        if(amount <= getAmount () && amount > 0) {
            this.amount -= amount;
            return true;
        }
        return false;
    }

    class Card {

        private final String cardNumber;
        private final Human owner;
        private long amount;

        public Card(String cardNumber, Human owner) {
            this.cardNumber = cardNumber;
            this.owner = owner;
        }

        public long getAmount() {
            return amount;
        }

        public void setAmount(long amount) {
            this.amount = amount;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public Human getOwner() {
            return owner;
        }

        public long putMoney(final long amount) {
            if(Account.this.putMoney(amount)) {
                this.amount += amount;
                return amount;
            }
            return 0;
        }

        public long withDrawMoney(final long amount) {
            if(amount <= getAmount () && Account.this.withDrawMoney(amount)) {
                this.amount -= amount;
                return amount;
            }
            return 0;
        }

    }

}
