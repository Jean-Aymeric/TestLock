package com.jad;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProxyLockCounter implements ICounter {
    private final Counter counter = new Counter();
    final Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        lock.lock();
        this.counter.increment();
        lock.unlock();
    }

    @Override
    public String toString() {
        return this.counter.toString();
    }
}
