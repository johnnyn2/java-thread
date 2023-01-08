package org.whizlab;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        System.out.println("Starting count is: " + count.getCount());
        Thread increaser1 = new Thread(new Increaser(count));
        Thread increaser2 = new Thread(new Increaser(count));
        increaser1.start();
        increaser2.start();
        increaser1.join();
        increaser2.join();
        System.out.println("Ending count is: " + count.getCount());
    }
}