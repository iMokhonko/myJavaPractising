package com.imokhonko;

public class Consumer implements Runnable {

    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            store.get();
        } catch (InterruptedException e) {
            System.out.println (this.getClass ().getName () + " interrupted");
        }
    }
}
