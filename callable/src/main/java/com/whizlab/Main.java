package com.whizlab;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> callableTask = () -> {
          Thread.sleep(2000);
          return new Random().nextInt(100);
        };
        Future<Integer> result = executor.submit(callableTask);
        while(!result.isDone()) {
            // get return value from Future result may be blocking the main thread if the task has no
            // yet completed since result.get() will wait for the return value. So it should perform
            // other tasks before calling the .get() method when the task is not completed
            System.out.println("Task is not ready, doing other stuff!");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            System.out.println("We got the value " + result.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
    }
}