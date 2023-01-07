package com.whizlab.java.thread;

import java.util.Random;

public class Dog implements Runnable{

    @Override
    public void run() {
        for (int m=10; m<=100; m+=10) {
            try {
                Thread.sleep(new Random().nextInt(500)); // suspend the Dog thread randomly after running for 10 meters
                System.out.println(Thread.currentThread().getName() + " runned " + m + " meters!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Thread.currentThread().getName() + " FINISHED!");
    }
}
