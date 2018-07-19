package com.imokhonko.Nested.SomePractise;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Client vanya = new Client ("Ivan Mokhonko");
        Account vanyaAccount = new Account (vanya, "1234-5678-9101-2354");
        Card vanyaCard = new Card (vanyaAccount, "98578345345", Card.CardTypes.UNIVERSAL);
        vanyaCard.putMoney (5000);

        List<Good> goods = new ArrayList<> ();

        goods.add(new Good ("Cap", 500));
        goods.add(new Good ("tshirt", 950));
        goods.add(new Good ("pants", 1500));
        goods.add(new Good ("shoes", 1500));

        Order vanyaOrder = new Order (goods, vanya);

        System.out.println (vanyaOrder.getSummaryPrice());
        vanyaOrder.payOrder (vanyaCard);
        System.out.println (vanyaCard.getAmount ());
        System.out.println (vanyaOrder.isConfirmed ());


    }

}
