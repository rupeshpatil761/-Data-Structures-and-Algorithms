package com.dsa.practice.threading.callable;

import java.util.Random;
import java.util.concurrent.*;

/**
 *  Callable without returning value
 */
public class CallableApp3 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        //anonymous call of Callable
        Future<?> future = executor.submit(new Callable<Void>() {

            @Override
            //return value is Integer
            public Void call() throws TimeoutException {
                Random random = new Random();
                int duration = random.nextInt(4000);
                if (duration > 2000) {
                    throw new TimeoutException ("Sleeping for too long.");
                }

                System.out.println("Starting ...");
                try {
                    Thread.sleep(duration);
                } catch (InterruptedException ignored) {}
                System.out.println("Finished.");
                return null;
            }
        });

        executor.shutdown();
        //executor.awaitTermination(1, TimeUnit.DAYS);  // Not required here but good practice to have it
        try {
            //get returned value from call()
            System.out.println("Result is: " + future.get());

        } catch (InterruptedException ignored) {
        } catch (ExecutionException e) {
            TimeoutException ex = (TimeoutException) e.getCause();
            System.out.println(ex.getMessage());
        }
    }

}
