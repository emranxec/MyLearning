package com.xec.thread.locks;

import com.xec.thread.ThreadColor;

import java.util.Random;
import java.util.concurrent.*;

import static com.xec.thread.locks.ArrayBlockingQueueExample.EOF;

public class ArrayBlockingQueueExample {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        buffer.add("start point");
        ExecutorService ex= Executors.newFixedThreadPool(5);
       // ExecutorService ex= new ThreadPoolExecutor(5,10,3000,TimeUnit.MICROSECONDS,new ArrayBlockingQueue<>(128));
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_CYAN);

        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE);

       /* new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();*/
        ex.execute(producer);
        ex.execute(consumer1);
        ex.execute(consumer2);

        Future<MyProducer> result=ex.submit(() -> {
            System.out.println("running callable");
            return new MyProducer();
        });

        try {
            System.out.println("future :" + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ex.shutdown();
    }
}

