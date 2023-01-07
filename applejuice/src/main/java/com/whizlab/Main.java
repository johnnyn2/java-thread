package com.whizlab;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bucket bucket = new Bucket();
        Thread worker = new Thread(new Worker(bucket));
        Thread machine = new Thread(new Machine(bucket));
        worker.start();
        machine.start();
        Thread.sleep(1000);
        System.exit(0);
    }
}