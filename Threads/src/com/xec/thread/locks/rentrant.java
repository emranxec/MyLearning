package com.xec.thread.locks;

import com.xec.thread.ThreadColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class rentrant {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock=new ReentrantLock(true);
        ReadWriteLock readWriteLock=new ReentrantReadWriteLock();

        AtomicInteger atomicInteger=new AtomicInteger();


        buffer.add("start point");
        ExecutorService ex= Executors.newFixedThreadPool(5);
        ReentrantReader reentrantReader = new ReentrantReader(buffer, ThreadColor.ANSI_GREEN,readWriteLock);
        ReentrantReader reentrantReader1 = new ReentrantReader(buffer, ThreadColor.ANSI_BLUE,readWriteLock);
        ReentrantConsumer consumer2 = new ReentrantConsumer(buffer, ThreadColor.ANSI_CYAN,bufferLock);
        ReentrantProducer producer = new ReentrantProducer(buffer, ThreadColor.ANSI_YELLOW,bufferLock);
        ReentrantConsumer consumer1 = new ReentrantConsumer(buffer, ThreadColor.ANSI_PURPLE,bufferLock);

       /* new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();*/
        ex.execute(producer);
        ex.execute(consumer1);
        ex.execute(consumer2);
        ex.execute(reentrantReader);
        ex.execute(reentrantReader1);

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

