package com.whizlab.java.thread;

public class Timer implements Runnable{
    private long startTime;

    public Timer(long startTime) {
        this.startTime = startTime;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                System.out.println((System.currentTimeMillis() - startTime) / 1000 + " seconds has passed!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
