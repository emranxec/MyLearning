package com.xec.single.src.Com.xec.OS;

public interface OS {
    String getSpecs();
    default void setSpecs(String specsUpdate){
        System.out.println("we cannot update specs!! sorry");
    }
}