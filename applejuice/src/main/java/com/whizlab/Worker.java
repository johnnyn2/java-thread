package com.whizlab;

/*
*   Add apple
* */
public class Worker implements Runnable{
    private Bucket bucket;

    public Worker(Bucket bucket) {
        this.bucket = bucket;
    }
    @Override
    public void run() {
        while(true) {
            bucket.addApple();
        }
    }
}
