package com.imokhonko.RabbitAttack;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread rabbitPrinter = new Thread (new RabbitPrinter (250));
        rabbitPrinter.start ();
        rabbitPrinter.join ();

    }


}
