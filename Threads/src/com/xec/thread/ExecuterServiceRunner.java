package com.xec.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ExecuterServiceRunner {

    public static void main(String[] args) {

       // ExecutorService executorService= Executors.newSingleThreadExecutor();
          ExecutorService executorService= Executors.newFixedThreadPool(2);

        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock=new ReentrantLock(true);

        MyProducer1 producer = new MyProducer1(buffer, ThreadColor.ANSI_YELLOW,bufferLock);
        MyProducer1 producer1 = new MyProducer1(buffer, ThreadColor.ANSI_BLUE,bufferLock);
        MyProducer1 producer2 = new MyProducer1(buffer, ThreadColor.ANSI_GREEN,bufferLock);
        MyProducer1 producer3 = new MyProducer1(buffer, ThreadColor.ANSI_CYAN,bufferLock);

        MyConsumer1 consumer1 = new MyConsumer1(buffer, ThreadColor.ANSI_PURPLE,bufferLock);
        MyConsumer1 consumer2 = new MyConsumer1(buffer, ThreadColor.ANSI_RED,bufferLock);
        MyConsumer1 consumer3 = new MyConsumer1(buffer, ThreadColor.ANSI_BLACK,bufferLock);
        MyConsumer1 consumer4 = new MyConsumer1(buffer, ThreadColor.ANSI_WHITE,bufferLock);

        executorService.execute(producer);
        executorService.execute(producer1);
        executorService.execute(producer2);
        executorService.execute(producer3);

        executorService.execute(consumer1);
        executorService.execute(consumer2);
        executorService.execute(consumer3);
        executorService.execute(consumer4);

        executorService.shutdown();
    }
}
