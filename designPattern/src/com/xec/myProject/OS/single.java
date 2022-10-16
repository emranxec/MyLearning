package com.xec.myProject.OS;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


public class single {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, IOException, CloneNotSupportedException {

        SingletonReal singletonReal = SingletonReal.getInstance();

        //todo broken by reflection

        //if uncomment reflection exception :: IllegalAccessException :: object not created by Reflaction

          Class<?> singletonClass = Class.forName("com.xec.myProject.OS.SingletonReal");
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

   /*     //todo broken by clonable
          // if uncomment clone not supportedd exception

        SingletonReal singletonClone = (SingletonReal) singletonReal.clone();

        System.out.println("singletonReal for 1 is " + singletonReal.hashCode());
        System.out.println("singletonClone for 1 is " + singletonClone.hashCode());*/


        //todo best way
        SingletonUsingEnum myCar = SingletonUsingEnum.INSTANCE;
        myCar.i = 5;
        myCar.getI();
        System.out.println("hashcode for enam 1 is " + myCar.hashCode());

        SingletonUsingEnum myCar1 = SingletonUsingEnum.INSTANCE;
        myCar1.i = 6;
        myCar.getI();
        System.out.println("hashcode for enam 2 is " + myCar1.hashCode());


    }

}

/**
 * singleton design pattern
 * one instance per JVM
 * default to unit test
 * Spring bean - default
 *
 *
 * private constructor
 * static variable & method
 */
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

        System.out.println("stop deserialization breaking of singleton");
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

enum SingletonUsingEnum {
    INSTANCE;
    int i;
    public void getI(){
        System.out.println(i);
    }
}




//how to break the singleton
//create a singleton
//create a running springboot application
