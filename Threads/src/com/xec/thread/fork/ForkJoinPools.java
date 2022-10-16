package com.xec.thread.fork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPools {

    public static void main(String[] args) {

      //  Fibonacci fibonacci=new Fibonacci(5);
       // System.out.println("the fibonacci of is :" +fibonacci.compute());
        int noOfCore = Runtime.getRuntime().availableProcessors();
        System.out.println("Total Number of available cores in the system processor is: " + noOfCore);

        ForkJoinPool Pool = ForkJoinPool.commonPool();
        System.out.println("The size of the Common Pool was: " + Pool.getPoolSize());

        System.out.println("Total number of active threads before invoking: " + Pool.getActiveThreadCount());

        NewTaskService newTaskService=new NewTaskService(100000);

        Pool.invoke(newTaskService);
        System.out.println("Total number of active threads after invoking: " + Pool.getActiveThreadCount());

        System.out.println("The size of the Common Pool is: " + Pool.getPoolSize());



    }
}


class NewTaskService extends RecursiveAction{

    private int range = 0;

    public NewTaskService(int range) { this.range = range; }
    @Override
    protected void compute() {
        List<NewTaskService>  subTasksList = new ArrayList<>();
        subTasksList.addAll(genSubTask());
        int size = subTasksList.size();

        for(int i=0;i<size;i++){
            subTasksList.get(i).fork();
        }
    }

    private List<NewTaskService> genSubTask() {
        List<NewTaskService> subTasksList = new ArrayList<>();
        NewTaskService subTaskA = new NewTaskService(this.range / 5);
        NewTaskService subtaskB = new NewTaskService(this.range / 5);
        NewTaskService subtaskC = new NewTaskService(this.range / 5);
        NewTaskService subtaskD = new NewTaskService(this.range / 5);
        NewTaskService subtaskE = new NewTaskService(this.range / 5);
        subTasksList.add(subTaskA);
        subTasksList.add(subtaskB);
        subTasksList.add(subtaskC);
        subTasksList.add(subtaskD);
        subTasksList.add(subtaskE);

        return subTasksList;
    }
}