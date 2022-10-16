package com.xec.thread.locks;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

import static com.xec.thread.locks.rentrant.EOF;

class ReentrantConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public ReentrantConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        int counter = 0;
        while (true) {
            if (bufferLock.tryLock()) { //Acquires the lock only if it is not held by another thread at the time of invocation
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "counter :" + counter);
                    counter = 0;
                    Random random = new Random();
                    Thread.sleep(random.nextInt(1000));
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    bufferLock.unlock();
                }

            } else {
                counter++;
            }
        }
    }
}
