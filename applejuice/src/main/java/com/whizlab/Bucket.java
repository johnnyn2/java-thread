package com.whizlab;

public class Bucket {
    private int appleCount = 0;
    public void getApple() {
        System.out.println("Apple removed, remaining - " + --appleCount);
    }

    public void addApple() {
        System.out.println("Apple added, remaining - " + ++appleCount);
    }
}
