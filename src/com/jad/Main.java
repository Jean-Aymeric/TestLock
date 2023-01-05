package com.jad;


public class Main {

    public static void main(String[] args) {
        final ICounter[] counters = new ICounter[3];
        counters[0] = new ProxySemaphoreCounter();
        counters[2] = new SynchronizedCounter();
        counters[1] = new ProxyLockCounter();

        for (int i = 0; i < 1000; i++) {
            final int finalI = i%100;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(100 - finalI);
                        for(ICounter counter : counters) {
                            Thread subThread = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    counter.increment();
                                }
                            });
                            subThread.start();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(ICounter counter : counters) {
            System.out.println(counter);
        }
    }
}
