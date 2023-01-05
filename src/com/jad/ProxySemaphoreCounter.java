package com.jad;

import java.util.concurrent.Semaphore;

public class ProxySemaphoreCounter implements ICounter {
    private final Counter counter = new Counter();
    final Semaphore semaphore = new Semaphore(1);

    @Override
    public void increment() {
        try {
            semaphore.acquire(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.counter.increment();
        semaphore.release();
    }

    @Override
    public String toString() {
        return this.counter.toString();
    }
}
