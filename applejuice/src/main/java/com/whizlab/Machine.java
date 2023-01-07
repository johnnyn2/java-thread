package com.whizlab;
/*
*   Make apple juice
* */
public class Machine implements Runnable{
    private Bucket bucket;
    public Machine(Bucket bucket) {
        this.bucket = bucket;
    }
    @Override
    public void run() {
        while(true) {
            bucket.getApple();
        }
    }
}
