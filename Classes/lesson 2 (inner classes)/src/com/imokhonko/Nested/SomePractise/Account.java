package com.imokhonko.Nested.SomePractise;

public class Account {

    private final Client owner;
    private final String number;

    public Account(Client owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    public Client getOwner() {
        return owner;
    }

    public String getNumber() {
        return number;
    }
}
