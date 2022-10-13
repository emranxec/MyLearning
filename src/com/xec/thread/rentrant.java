package com.xec.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import static com.xec.thread.rentrant.EOF;

public class rentrant {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock=new ReentrantLock(true);

        AtomicInteger atomicInteger=new AtomicInteger();


        buffer.add("start point");
        ExecutorService ex= Executors.newFixedThreadPool(5);
        MyConsumer1 consumer2 = new MyConsumer1(buffer, ThreadColor.ANSI_CYAN,bufferLock);

        MyProducer1 producer = new MyProducer1(buffer, ThreadColor.ANSI_YELLOW,bufferLock);
        MyConsumer1 consumer1 = new MyConsumer1(buffer, ThreadColor.ANSI_PURPLE,bufferLock);

       /* new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();*/
        ex.execute(producer);
        ex.execute(consumer1);
        ex.execute(consumer2);

        Future<MyProducer> result=ex.submit(new Callable<>(){
            @Override
            public MyProducer call() throws Exception {
                System.out.println("running callable");
                return new MyProducer();
            }
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

class MyProducer1 implements  Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer1() {
    }

    public MyProducer1(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock=bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5"};

        for(String num: nums) {
            bufferLock.lock();
            try {
                System.out.println(color + "Adding..." + num);

                buffer.add(num);


                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e) {
                System.out.println("Producer was interrupted");
            }finally {
                bufferLock.unlock();
            }
        }

        System.out.println(color + "Adding EOF and exiting....");

        bufferLock.lock();
        try{
            buffer.add("EOF");
        }finally {
            bufferLock.unlock();
        }



    }
}

class MyConsumer1 implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer1(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock=bufferLock;
    }

    public void run() {
        int counter=0;
        while (true) {
            if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "counter :" +counter);
                    counter=0;
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }

            }else{
                counter++;
            }
        }
    }
}
