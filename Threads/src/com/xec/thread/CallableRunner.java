package com.xec.thread;

import java.util.concurrent.*;

class CallableTask implements Callable<String>{

    private String name;

    public CallableTask(String name){
        this.name=name;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        if(name.equals("imran")){
            Thread.sleep(100000);
        }
        return "Hello " + name;
    }


}

public class CallableRunner {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newFixedThreadPool(1);

        Future<String> stringFuture = executorService.submit(new CallableTask("Imran"));
        System.out.println("\n new CallableTask(\"Imran\") completed");
        String welcome=stringFuture.get();
        System.out.println(welcome);
        System.out.println("\n main completed");
    }
}
