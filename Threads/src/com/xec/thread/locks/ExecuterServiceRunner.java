package com.xec.thread.locks;

import com.xec.thread.ThreadColor;

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

        ReentrantProducer producer = new ReentrantProducer(buffer, ThreadColor.ANSI_YELLOW,bufferLock);
        ReentrantProducer producer1 = new ReentrantProducer(buffer, ThreadColor.ANSI_BLUE,bufferLock);
        ReentrantProducer producer2 = new ReentrantProducer(buffer, ThreadColor.ANSI_GREEN,bufferLock);
        ReentrantProducer producer3 = new ReentrantProducer(buffer, ThreadColor.ANSI_CYAN,bufferLock);

        ReentrantConsumer consumer1 = new ReentrantConsumer(buffer, ThreadColor.ANSI_PURPLE,bufferLock);
        ReentrantConsumer consumer2 = new ReentrantConsumer(buffer, ThreadColor.ANSI_RED,bufferLock);
        ReentrantConsumer consumer3 = new ReentrantConsumer(buffer, ThreadColor.ANSI_BLACK,bufferLock);
        ReentrantConsumer consumer4 = new ReentrantConsumer(buffer, ThreadColor.ANSI_WHITE,bufferLock);

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
