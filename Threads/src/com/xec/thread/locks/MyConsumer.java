package com.xec.thread.locks;

import java.util.concurrent.ArrayBlockingQueue;

import static com.xec.thread.locks.ArrayBlockingQueueExample.EOF;

class MyConsumer implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        int counter = 0;
        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }
                System.out.println(color + "counter :" + counter);
                counter = 0;
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
