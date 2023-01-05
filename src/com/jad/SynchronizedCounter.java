package com.jad;

public final class SynchronizedCounter implements ICounter {
    private int count = 0;


    public SynchronizedCounter() {
    }


    public int getCount() {
        return count;
    }

    private void setCount(final int count) {
        this.count = count;
    }

    @Override
    synchronized public void increment() {
        this.setCount(this.getCount() + 1);

    }

    @Override
    public String toString() {
        return "" + this.getCount();
    }
}
