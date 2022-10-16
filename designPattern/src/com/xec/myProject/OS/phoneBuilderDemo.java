package com.xec.myProject.OS;

/**
 *
 *
 * Com.xec.OS.Builder shop
 */


public class phoneBuilderDemo {

    public static void main(String[] args) {
            OS myOS = OSFactory.getInstance("KIDNEY");
            Phone phone=new PhoneBuilder().setOs(myOS).setRam(213).build();
            System.out.println(phone);
    }
}


class Phone{

    private OS os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    public Phone(OS os, int ram, String processor, double screenSize, int battery) {
        super();
        this.os = os;
        this.ram = ram;
        this.processor = processor;
        this.screenSize = screenSize;
        this.battery = battery;
    }

    @Override
    public String toString() {
        return "Com.xec.OS.Phone{" +
                "os=" + os.getSpecs() +
                ", ram=" + ram +
                ", processor='" + processor + '\'' +
                ", screenSize=" + screenSize +
                ", battery=" + battery +
                '}';
    }
}

/**
 * Builder design pattern
 *
 */
class PhoneBuilder {

    private OS os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battery;

    public PhoneBuilder setOs(OS os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public PhoneBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    Phone build(){
        return new Phone(os,ram,processor,screenSize,battery);
    }
}


//private constractor
//private static instance variable
//static getInstance() method;
//synchronized :Com.xec.OS.com.xec.single check for thread dafe
//double check for lazy
//
