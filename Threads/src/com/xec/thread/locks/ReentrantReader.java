package com.xec.thread.locks;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;

import static com.xec.thread.locks.rentrant.EOF;

public class ReentrantReader implements Runnable {

    private List<String> buffer;
    private String color;
    private ReadWriteLock bufferLock;

    public ReentrantReader(List<String> buffer, String color, ReadWriteLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock=bufferLock;
    }

    public void run() {
        int counter=0;
        while (true) {
            if (bufferLock.readLock().tryLock()) { //Acquires the lock only if it is not held by another thread at the time of invocation
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "I am just a reader & the buffer is :" +buffer);
                    counter=0;
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000));
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "READER :: nothing to read");
                        break;
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    bufferLock.readLock().unlock();
                }

            }else{
                counter++;
            }
        }
    }
}
