package com.whizlab;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 1. ExecutorService newCachedThreadPool
        // Create a thread pool that creates new threads as needed but will reuse previously constructed ones
        // when they are available
//        ExecutorService executor = Executors.newCachedThreadPool();

        // 2. ExecutorService newFixedThreadPool
        // Creates a thread pool that reuses a fixed number of workers operating off a shared unbound queue.
        // At any point at most n Threads will be actively processing tasks. If additional tasks is submitted
        // when all threads are active, they will wait in the queue until a thread is available
//        ExecutorService executor = Executors.newFixedThreadPool(5);

        // 3. ExecutorService newSingleThreadExecutor
        // Creates a thread pool that uses a single worker thread operating off an unbounded queue. Tasks are
        // guarenteed to be executed sequentially and no more than one task will be active at any given time.
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            Thread currentThread = Thread.currentThread();
            System.out.println("Task executed from " + currentThread.getName() + " starting!");
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task executed from " + currentThread.getName() + " ending!");
        };

        // Case 1 using newCachedThreadPool: 10 threads are created and no waiting occurs so program exits immediately
        // Case 2 using newFixedThreadPool(5): 5 threads are created and 2 seconds waiting occurs so program exits after 2 seconds
        // Case 3 using newSingleThreadExecutor: 1 thread is created and 20 seconds waiting occurs so program exits after 20 seconds
        Stream.iterate(1, n -> n+1).limit(10).forEach(e -> executor.execute(task));
        System.out.println(Thread.currentThread().getName() + " is before shutdown!");
        executor.shutdown();
        System.out.println(Thread.currentThread().getName() + " is after shutdown");
    }
}