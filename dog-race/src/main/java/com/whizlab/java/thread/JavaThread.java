/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.whizlab.java.thread;

import java.util.List;

/**
 *
 * @author Johnny
 */
public class JavaThread {

    public static void main(String[] args) {
        System.out.println("-----------------------Start-----------------------");
        long start = System.currentTimeMillis();
        Thread timer = new Thread(new Timer(start));
        timer.setDaemon(true); // set the timer thread as low priority thread that run in background and will automatically be terminated if there's no more user threads alive
        timer.start(); // suspend main thread every second and print the current time spent

        List<Thread> dogs = Race.setDogsOnStartLine();
        dogs.stream().forEach(d -> d.start());

        // this block is let main thread(main method) wait all subthreads(dog threads) finish execution before printing the Finish! statement
        // without this line, Finish! statement will print immediately after printing Start statement
        dogs.stream().forEach(d -> {
            try {
                d.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("-----------------------Finish!-----------------------");
        System.out.println("The race was " + (System.currentTimeMillis() - start) / 1000 + " seconds");
    }
}
