package com.xec.java.exception;


class SwingException extends Exception{}
class CloseException extends Exception{}
 class Door implements AutoCloseable{
    @Override
    public void close() throws CloseException{
        System.out.println("The door is closed!!!");
        throw new CloseException();
    }

     public void swing() throws SwingException{
         System.out.println("The door is swinging!!!");
         throw new SwingException();
     }
}

public class TryWithResourcesExample{
    public static void main(String[] args) {

        try(Door door=new Door()){
            door.swing();
            throw new RuntimeException("some exception in Door");
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getSuppressed()[0]);
        }
    }
}
