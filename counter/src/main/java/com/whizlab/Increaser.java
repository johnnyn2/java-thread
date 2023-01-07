package com.whizlab;

public class Increaser extends Thread{
    private Count count;

    public Increaser(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i=0;i<10000;i++) {
            this.count.add();
        }
    }
}
