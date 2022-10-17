package com.xec.java.serialize;

import java.io.*;
import java.util.concurrent.ArrayBlockingQueue;

public class LetsSerialize{

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Employee employee=new Employee();
        FileOutputStream fileOutputStream=new FileOutputStream("abc.txt");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(employee);

        FileInputStream fileInputStream=new FileInputStream("abc.txt");
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
        Employee employee1= (Employee) objectInputStream.readObject();
        System.out.println(employee1.id);

        ArrayBlockingQueue arrayBlockingQueue=new ArrayBlockingQueue(10);
        arrayBlockingQueue.add(7);
        arrayBlockingQueue.add(2);
        arrayBlockingQueue.add(3);
        arrayBlockingQueue.add(4);
        arrayBlockingQueue.add(5);
        System.out.println( arrayBlockingQueue.peek());
        System.out.println( arrayBlockingQueue.poll());
        System.out.println( arrayBlockingQueue.peek());






    }
}

class Employee implements Serializable {
    static String id="123";
    String name="imran";
    String phone="9096919090";
    transient
    String password="123";

    Employee(){
    }


    //Setters and Getters

    private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException
    {
        name = aInputStream.readUTF();
        phone = aInputStream.readUTF();

        aInputStream.defaultReadObject();

        // make defensive copy of the mutable Date field
        if(phone.equals("9096919090")){
            System.out.println("tring");
        }

    }

    private void writeObject(ObjectOutputStream aOutputStream) throws IOException
    {
        aOutputStream.writeUTF(name);
        aOutputStream.writeUTF(phone);
        aOutputStream.defaultWriteObject();
    }

    private  static  final  long SerialVersionUID=1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
