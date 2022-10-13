package com.xec.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.xec.thread.Main.EOF;

public class Main {
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

class MyProducer implements  Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer() {
    }

    public MyProducer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5"};

        for(String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting....");

        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        int counter=0;
        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }
                System.out.println(color + "counter :" +counter);
                counter=0;
                if (buffer.peek().equals(EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    try {
                        System.out.println(color + "Removed " + buffer.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
