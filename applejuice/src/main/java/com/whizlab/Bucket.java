package com.whizlab;

public class Bucket {
    private int appleCount = 0;

    // wait() can only be called in synchronized method. Otherwise, exception will occur
    public synchronized void getApple() {
        // Spin lock: a condition checked in a while loop. The thread that is awaked spins until its
        // condition is met, never violating any constraints of our application,
        // even when a spurious wakeup occurs
        while(appleCount <= 0) {
            try {
                // if the apple count <=0, suspend the thread
                System.out.println("----Not enough apples! Waiting!----");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Apple removed, remaining - " + --appleCount);
        notifyAll();
    }

    // wait() can only be called in synchronized method. Otherwise, exception will occur
    public synchronized void addApple() {
        // Spin lock: a condition checked in a while loop. The thread that is awaked spins until its
        // condition is met, never violating any constraints of our application,
        // even when a spurious wakeup occurs
        while(appleCount >= 20) {
            try {
                // if the apple count >= 20, suspend the thread
                System.out.println("----Too much apples! Waiting!----");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Apple added, remaining - " + ++appleCount);
        notifyAll();
    }
}
