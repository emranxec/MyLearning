package com.xec.single.src.Com.xec.OS;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class single {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, CloneNotSupportedException {

        SingletonReal singletonReal = SingletonReal.getInstance();

        //todo broken by reflection
        Class<?> singletonClass = Class.forName("Com.xec.OS.SingletonReal");
        Constructor<SingletonReal> singletonRealConstructor = (Constructor<SingletonReal>) singletonClass.getDeclaredConstructor();
        singletonRealConstructor.setAccessible(true);
        SingletonReal singletonReflection = singletonRealConstructor.newInstance();

        System.out.println("singletonReal for 1 is " + singletonReal.hashCode());
        System.out.println("singletonReflection for 1 is " + singletonReflection.hashCode());

        //todo broken by Serilization
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("singletonBreak.ser"));
        objectOutputStream.writeObject(SingletonReal.getInstance());
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("singletonBreak.ser"));
        SingletonReal singletonSerial = (SingletonReal) objectInputStream.readObject();

        System.out.println("singletonReal for 1 is " + singletonReal.hashCode());
        System.out.println("singletonSerial for 1 is " + singletonSerial.hashCode());

        //todo broken by clonable

        SingletonReal singletonClone = (SingletonReal) singletonReal.clone();

        System.out.println("singletonReal for 1 is " + singletonReal.hashCode());
        System.out.println("singletonClone for 1 is " + singletonClone.hashCode());


        //todo best way
        Singleton myCar = Singleton.INSTANCE;
        myCar.i = 5;
        myCar.getI();
        System.out.println("hascode for 1 is " + myCar.hashCode());

        Singleton myCar1 = Singleton.INSTANCE;
        myCar1.i = 6;
        myCar.getI();
        System.out.println("hascode for 2 is " + myCar1.hashCode());


    }

}


class SingletonReal implements Serializable, Cloneable {
    static SingletonReal singletonReal; //eager if defined

    private SingletonReal() throws IllegalAccessException {

        // todo stop reflaction breaking of singleton
        if(singletonReal!=null) {
            throw new IllegalAccessException("object not created by Reflaction");
        }
        System.out.println("created");
    }

    // todo stop deserialization breaking of singleton
    protected Object readResolve(){
        return singletonReal;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // todo stop cloning breaking of singleton
        throw new CloneNotSupportedException();
    }

    static SingletonReal getInstance() throws IllegalAccessException {
        if (singletonReal == null) {

            synchronized (SingletonReal.class) {//best way
                if (singletonReal == null) {
                    singletonReal = new SingletonReal(); // lazy
                }
            }
        }
        return singletonReal;
    }

}

enum Singleton{
    INSTANCE;
    int i;
    public void getI(){
        System.out.println(i);
    }
}




//how to break the singleton
//create a singleton
//create a running springboot application
