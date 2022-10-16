package com.xec.thread.locks;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public ReentrantProducer() {
    }

    public ReentrantProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5", "11", "22", "33", "44", "55"};

        for (String num : nums) {
            bufferLock.lock();
            try {
                System.out.println(color + "Adding..." + num);
                buffer.add(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            } finally {
                bufferLock.unlock();
            }
        }

        System.out.println(color + "Adding EOF and exiting....");

        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }


    }
}
