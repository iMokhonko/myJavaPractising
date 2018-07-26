package com.imokhonko.RabbitAttack;

public class RabbitPrinter implements Runnable {

    private final long millis;

    public RabbitPrinter(long millis) {
        this.millis = millis;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1_000_000; i++) {
            try {
                Thread.sleep (millis);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            for (int j = 0; j < 5; j++) {
                String spaces = calculateSpaces (i + j);
                System.out.println (spaces + i + j);
            }
        }
    }

    public static String calculateSpaces(int k) {
        String result = "";
        for (int j = 0; j < k; j++) {
            result += " ";
        }
        return result;
    }
}
