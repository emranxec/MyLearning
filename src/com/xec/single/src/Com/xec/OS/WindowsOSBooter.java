package com.xec.single.src.Com.xec.OS;

public class WindowsOSBooter {
    public OS bootIt(String type){
        if(type==null){
            return null;
        }
        OS myOS = OSFactory.getInstance(type);
        System.out.println("loading....");
        System.out.println("loading....");
        System.out.println("loading....");
        System.out.println(myOS.getSpecs());
        System.out.println("Running....");
        return myOS;
    }
}
