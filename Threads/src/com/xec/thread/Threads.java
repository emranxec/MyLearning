package com.xec.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Threads {

    public static void main(String[] args) throws Exception {

        //create 2 threads one will print event & other one print even



      Thread t1=new Thread(()->{for(int i=1;i<=10;i++) System.out.println(i);});
      Thread t2=new Thread(()->{for(int i=1;i<=10;i++) System.out.println(i);});

        t1.start();
        t1.join();
        t2.start();
        t2.join();

        /*ThreadGroup threadGroup=new ThreadGroup("newGroup");

        MyThread1 odd=new MyThread1(threadGroup,"MyThread1");
        odd.start();

        MyThread2 even=new MyThread2();
        even.start();
*/
/*        //thread cycle overhead and resource thrashing
        ExecutorService e= Executors.newScheduledThreadPool(10);
        e.execute(myThread2);

        System.out.println("total count is ");


        List<Thread> t=new ArrayList<>();
        t.add(myThread1);

        Callable callable= (Callable) new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("hello");
                return this;
            }
        }.call();


        AtomicInteger atomicInteger=new AtomicInteger();

        System.out.println(atomicInteger.incrementAndGet());
        System.out.println(atomicInteger.incrementAndGet());*/


    }

}



class MyThread1 extends Thread{

    MyThread1(ThreadGroup threadGroup,String name){
        super(threadGroup,name);
    }
    @Override
    public synchronized void run() {
        ThreadGroup threadGroup=getThreadGroup();
        for(int i=1;i<10;i+=2){
            System.out.println(i);
        }
       // System.out.println(threadGroup.getName() + " of group and thread running " + getName());
    }
}

class MyThread2 extends Thread{

    @Override
    public synchronized void run() {
        for(int i=2;i<=10;i+=2){
            System.out.println(i);
        }
       // System.out.println( MyThread2.class + " is running");
    }
}