package com.xec.thread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiCallRunner {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService= Executors.newFixedThreadPool(10);

        List<CallableTask> callableTaskList = List.of(new CallableTask("Imran"),
                new CallableTask("salman"),
                new CallableTask("heena"),
                new CallableTask("imtiaz"),
                new CallableTask("ibbu"));

       // List<Future<String>> futureList = executorService.invokeAll(callableTaskList);
        String future = executorService.invokeAny(callableTaskList);



      /*  for(int i=0;i<100;i++)
        for(Future<String> stringFuture:futureList){
            System.out.println(stringFuture.get() + " numbers :" + i);
        }*/



        System.out.println(future);

        System.out.println("\n All tasks are completed");
        executorService.shutdown();

    }
}
