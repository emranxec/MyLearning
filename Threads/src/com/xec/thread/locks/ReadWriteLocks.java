package com.xec.thread.locks;

import com.xec.thread.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLocks {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReadWriteLock bufferLock=new ReentrantReadWriteLock();

        AtomicInteger atomicInteger=new AtomicInteger();


        buffer.add("start point");
        ExecutorService ex= Executors.newFixedThreadPool(5);
        ReentrantReader reentrantReader = new ReentrantReader(buffer, ThreadColor.ANSI_GREEN,bufferLock);
       /* MyConsumer1 consumer2 = new MyConsumer1(buffer, ThreadColor.ANSI_CYAN,bufferLock);
        MyProducer1 producer = new MyProducer1(buffer, ThreadColor.ANSI_YELLOW,bufferLock);
        MyConsumer1 consumer1 = new MyConsumer1(buffer, ThreadColor.ANSI_PURPLE,bufferLock);*/

       /* new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();*/
      /*  ex.execute(producer);
        ex.execute(consumer1);
        ex.execute(consumer2);*/
        ex.execute(reentrantReader);

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

