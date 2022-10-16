package com.xec.thread;


public class printOddEven {
    int counter = 1;
    static int n;


    public void printOdd() {
        synchronized (this) {
            while (counter < n) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(ThreadColor.ANSI_RED + "Odd : " +counter + "");
                counter++;
                notify();
            }

        }
    }

    public void printEven() {
        synchronized (this) {
            while (counter < n) {
                while (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(ThreadColor.ANSI_GREEN + "Even : " + counter + " ");
                counter++;
                notify();
            }

        }
    }



    public static void main(String[] args) {

        n=10;
        printOddEven printOddEven = new printOddEven();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                printOddEven.printEven();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                printOddEven.printOdd();
            }
        });

        t1.start();
        t2.start();

    }
}
