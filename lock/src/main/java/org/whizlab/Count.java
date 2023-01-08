package org.whizlab;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Count {
    private long count;

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    // returns the lock that is used for reading, if no threads are writing and no threads have requested
    // write access
    private Lock readLock = lock.readLock();
    // returns the lock that is used for writing, if no threads are reading or writing
    private Lock writeLock = lock.writeLock();

    // this is the same as declaring the add() method as synchronized
    // see https://github.com/johnnyn2/java-thread/blob/master/counter/src/main/java/com/whizlab/Count.java
    public void add() {
        try {
            writeLock.lock();
            this.count++;
        } finally {
            writeLock.unlock();
        }
    }

    public long getCount() {
        try {
            readLock.lock();
            return this.count;
        } finally {
            readLock.unlock();
        }
    }
}
