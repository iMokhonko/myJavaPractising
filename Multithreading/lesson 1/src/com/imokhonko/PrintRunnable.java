package com.imokhonko;

public class PrintRunnable implements Runnable {

    private final String message;
    private final long milis;

    public PrintRunnable(String message, long milis) {
        this.message = message;
        this.milis = milis;
    }

    @Override
    public void run() {
        long currentMillis = milis;
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep (milis);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            System.out.println (" " + message + " (" + currentMillis +" ms)");
            currentMillis += milis;
        }
    }
}
