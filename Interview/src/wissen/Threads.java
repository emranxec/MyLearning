package wissen;

public class Threads {
    public static void main(String[] args) {
        Thread threads1=new Thread(new Thread1());
        threads1.start();
        Thread threads2=new Thread(new Thread1());
        threads2.start();
    }
}

class Thread1 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<=10;i++) {
            Print p=new Print();
            if(i%2==1){
                p.printOdd(i);
            }else{
                p.printEven(i);
            }
        }
    }
}

class Print{
    boolean issOdd =false;
    synchronized void printEven(int even){
        while(!issOdd){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("even is" + even);
        issOdd =false;
        notifyAll();
    }

    synchronized void printOdd(int odd){
        while(issOdd){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("odd is" + odd);
        issOdd =true;
        notifyAll();
    }


}


