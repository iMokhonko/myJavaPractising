package com.imokhonko.Nested.Inner;

public class Main {

    public static void main(String[] args) {

        Human vanya = new Human ("Ivan Mokhonko");
        Human lexa = new Human ("Prosto Lexa");

        Account companyAccount = new Account ("1234-5678-9101", vanya);

        Account.Card vanyaCard = companyAccount.new Card ("341293476127", vanya);
        Account.Card lexaCard = companyAccount.new Card ("341293474345", lexa);


    }

}
