package com.app.expl;
import java.util.concurrent.*;

public class Executor {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing task");
        };

        for(int i = 1; i <= 5; i++) {
            service.submit(task);
        }

        service.shutdown();
    }
}
