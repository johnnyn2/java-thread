package com.whizlab;

public class Count {
    private long count = 0;

    // use synchonized keyword so that only one thread can access this function at a time
    // since Increaser1 and Increaser2 access the shared object Count add() method
    // if the threads access at the same time, the value of count will be updated based on the old value at the same time
    // this problme is called race condition
    public synchronized void add() {
        this.count++;
    }

    public long getCount() {
        return this.count;
    }
}
