package company;

import java.io.*;
import java.util.concurrent.*;

class Main {

     public static int sum(long...numbers){
         int sum=0;
         for(long num:numbers) {
             sum += num;
         }
             assert(sum<30);




     return sum;
     }



    public synchronized static void main(String[] args) throws InterruptedException, ExecutionException, IOException, ClassNotFoundException {

        System.out.println("the sum is " +sum(1,2,3,4,5,6,7,8));

    /*    ExecutorService newScheduledThreadPool= Executors.newScheduledThreadPool(10);

        Future future=newScheduledThreadPool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "future is here";
            }
        });*/

        class Animal{
            void bark(){
                System.out.println("bark");
            }
        }
        Animal animal=new Animal();
        animal.bark();
        IamChild iamSuper = new IamChild();


        String myStringToWrite = "please sync & encrypt me";

        System.out.println(iamSuper instanceof IamSuper);

      /*  User user=new User();


        FileOutputStream fileOutputStream=new FileOutputStream("user.text");
        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(bufferedOutputStream);
        objectOutputStream.writeObject(user);
        objectOutputStream.flush();
        objectOutputStream.close();

        User userNew =new User();
        FileInputStream fileInputStream=new FileInputStream("user.text");
        BufferedInputStream bufferedInputStream=new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream=new ObjectInputStream(bufferedInputStream);
        userNew= (User) objectInputStream.readObject();
        System.out.println("Name is " + userNew.getName());
        System.out.println("UserName is " + userNew.getUserName());
        System.out.println("password is " + userNew.getPassword());


        SinleList SinleList=new SinleList();
        SinleList.addNode(1);
        SinleList.addNode(2);
        SinleList.addNode(3);
        SinleList.addNode(4);

        SinleList.display();

        Integer nine=9;//auto-boxing
        Integer nine1=Integer.valueOf("9");//auto-boxing
        nine++;

        //auto-boxing
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            list.add(i);
    }*/





       /* System.out.println(future.get());

        Future callme=newScheduledThreadPool.submit(new Callme());
        System.out.println(callme.get());


        xecThread xecThread=new xecThread();
        Thread thread=new Thread(xecThread);
        //thread.notify();
        thread.setDaemon(true);
        thread.interrupt();
        System.out.println("is thread interrupted :" + thread.isInterrupted());
        System.out.println(thread.isDaemon());

       MynewThread mynewThread=new MynewThread();
       mynewThread.start();
        logoff logoff=new logoff();
        Runtime.getRuntime().addShutdownHook(new logoff());

        ExecutorService executorService= Executors.newScheduledThreadPool(10);
        ExecutorService executorService1= Executors.newSingleThreadExecutor();
        ExecutorService executorService2= Executors.newFixedThreadPool(5);
        executorService.execute(thread);
        executorService.shutdown();
        executorService1.execute(thread);
        executorService1.shutdown();
        executorService2.execute(thread);
        executorService2.shutdown();

        ThreadGroup threadGroup=new ThreadGroup("groupAll");






        String string1="ABC";
        String string2="ABC";
        String string3 =new String("ABCD");
        String s6="D";
        String s5= new String("ABCD");
        String s7=string2+s6;
        String s8=string2+"D";
        String s9="ABC" + "D";
        String s4= string3.intern();

        System.out.println(string1==s4); //
        String sachin="sachin";
        System.out.println(50+30+sachin+40+40);

        System.out.println(string1==string2+s6); //
        System.out.println(string1.equals(string2)+s6); //
        System.out.println(string1==string3.intern()); //
        System.out.println(string1==s7); //
        System.out.println(string1==s8); //
        System.out.println(string1==s9); //
        System.out.println(string1==s4); //
        System.out.println(string1==s5.intern()); //

        Bike b=new Apache();
        b.setSpeed(200);
        System.out.println("speed is "+b.speed);



        Map map=Collections.synchronizedMap(new HashMap<>());
        map.values();

       String s="ABC";
       String s1="ABC";

        System.out.println(s.compareTo(s1));

        Set<weekdays> set=EnumSet.of(weekdays.monday);
        System.out.println(set.size());
*/


        // System.out.println("The String is " + string1.equals(string2));


        //todo Sri true,true
        //todo kopal true,true


        // write your code here
       /* int[] original = {1, 3, 4};
        System.out.println(findElement(original));*/

      /*  TestExample obj = new TestExample();

        //call the default method
        obj.defaultMethod();*/

  /*      String s1 = "abc";
        String s2 = "abc";
        System.out.println("s1 == s2 is:" + s1 == s2);*/

      /*  String[] abc= {"1","2","3","4","5","6","7","8","9","10","11","12","13"};

        Stream.iterate(2,count->count+1)
                .filter(a-> a%2==0)
                .forEach(System.out::println);*/

 /*       int[]Array1={1,2,3};
        int min=0;
        int counter=0;
        min=Array1[0];
        for(int i=1;i<Array1.length;i++){
            counter+=Array1[i]-min;
        }
        System.out.println(counter);*/


    }




     private static boolean hitTestPoint(int xx, int yy) {
        return true;
     }

     //1,12
    private static int findElement(int[] original) {
        int sum = 0;//sum of 99
        int counter=0;
        for (int i = 0; i < original.length / 2; i++) {
            sum = sum + original[i] + original[original.length - i];
            counter++;
        }
        int min=1;
        int max=12;
        return sum;
    }
}

class invalidVehicleException extends Exception{

     invalidVehicleException(String s){
         super(s);
     }
}

interface Engine{
     public static final int Id = 0;
     public abstract boolean isNewEngine();
     void printEngineNumber();
     public void setSpeed(Integer speed);
}
     abstract class Bike{
      Integer speed=90;

         public abstract void setSpeed(Integer speed);

         Integer getSpeed() throws invalidVehicleException {
             throw new invalidVehicleException("invalid");
         }
     }

abstract class Vehicle{
    Integer price=90000;

    public abstract void setPrice(Integer speed);

    Integer getPrice() {
        return 500;
    }
}

interface Vehicles{
    Integer price=90000;
     static Integer weight =90000;

    public abstract void setPrice(Integer speed);

    public default void updatePrice(Integer price) {
        price=100000;
    }

    Integer getPrice();
}

 abstract class Honda extends Bike implements Engine,Vehicles{
     static final Integer speed;
     final Integer price;

     static {
         speed=10; //static final
     }
     Honda(){
         //System.out.println("as");
         super();//should be first statement
         price=1;// final
     }
    public void setSpeed(Integer speed) {
       // this.speed = speed;
      //  this.price=Vehicles.price;
    }

    Integer getSpeed(Honda H){
        return speed;
    }

     @Override
     public boolean isNewEngine() {
         //this.getSpeed();
         this.getSpeed(this);
         return false;
     }

     @Override
    public void printEngineNumber() {
        System.out.println("123");
    }

     @Override
     public void setPrice(Integer speed) {

     }

     @Override
     public Integer getPrice() {
         return null;
     }
 }

 class HondaNew extends Honda{
 }

class Apache extends Bike implements Engine,Vehicles{
    Integer speed=150;

    @Override
    public boolean isNewEngine() {
        System.out.println("ok");
        return super.speed>1;
    }

    @Override
    public void printEngineNumber() {

    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    Integer getSpeed() throws NullPointerException{
        return speed;
    }

    @Override
    public void setPrice(Integer speed) {

    }

    @Override
    public Integer getPrice() {
        return null;
    }
}

interface Interface_One{
    //defaultMethod
    default void defaultMethod(){
        System.out.println("Interface_One::defaultMethod");
    }

}
//Interface_Two
interface Interface_Two{
    //defaultMethod
    default void defaultMethod(){
        System.out.println("Interface_Two::defaultMethod");
    }
}
class TestExample implements Interface_One, Interface_Two{

    public void disp(String str){
        System.out.println("String is: "+str);
    }


    @Override
    public void defaultMethod() {

    }
}

enum weekdays{
     sunday,monday
}

class xecThread implements Runnable{
    @Override
    public void run() {
        System.out.println("runnable");
    }
}

class MynewThread extends Thread{

    @Override
    public synchronized void run() {
        synchronized(this){
            System.out.println("extends");
        }

    }


}


class logoff extends Thread{

    @Override
    public void run() {
        System.out.println("Sorry!! time to logg off");
    }


}

class Callme implements Callable{

    @Override
    public Object call() throws Exception {
        return "Call me please";
    }
}

class User implements Serializable{

     static String myName="Imran";

    transient
     String name = "Admin";

    transient
     String userName = "Admin";

     transient
     String password = "Admin123";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

class SinleList{

    public node head = null;
    public node tail = null;

     class node<E> {
         int element;
         node<E> next;

         node(int element, node<E> next) {
             this.element = element;
             this.next = next;
         }
     }



    void addNode(int element){

        node newNode=new node(element,null);
        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next=newNode;
            tail=newNode;

        }
    }

    public void display(){
        node current=head;

        if(head==null){
            System.out.println("list is empty");
            return;
        }
        System.out.println("com.xec.single linked list");

        while (current!=null){
            System.out.println(current.element + " ");
            current=current.next;
        }
        System.out.println();
    }




}

class IamSuper {
    int price;
    String desc;

    IamSuper(){
        System.out.println("Super Mama");
    }
    IamSuper(int price,String desc){
        this.price=price;
        this.desc=desc;
    }
}

class IamChild extends IamSuper{
    int price;
    String desc;

    IamChild(){
        System.out.println("I am kid");
    }

    IamChild(int price,String desc){
        this.price=price;
        this.desc=desc;
    }
}