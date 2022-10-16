package com.xec.myProject;

interface Tablets{
    void OS();
    void camera();
    void speaker();
    default void Network(){
        System.out.println("Sim card support required");
    }
}

public class AndroidTab implements Tablets{
    @Override
    public void OS() {
        System.out.println("Anroid");
    }

    @Override
    public void camera() {
        System.out.println("12MP");
    }

    @Override
    public void speaker() {
        System.out.println("speaks");
    }

    public void Network() {
        System.out.println("new Simcard Added");
    }


}

class Ipad implements Tablets{


    @Override
    public void OS() {
        System.out.println("IOS");

    }

    @Override
    public void camera() {
        System.out.println("5mp");

    }

    @Override
    public void speaker() {
        System.out.println("good One");

    }
}
