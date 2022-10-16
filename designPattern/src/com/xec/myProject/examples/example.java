package com.xec.myProject.examples;

import java.io.IOException;

public class example {
    public static void main(String[] args) throws IOException {
        Thread.currentThread().getPriority();
        System.out.println(Thread.currentThread().getPriority());
        Runtime runtime=Runtime.getRuntime();
        myThread myThread=new myThread();
        Thread thread=new Thread(myThread);
        thread.start();
        System.out.println(runtime.exec("notepad"));
    }
}

class myThread implements Runnable{


    @Override
    public void run() {
        System.out.println("Sridharan is smart");
    }
}
