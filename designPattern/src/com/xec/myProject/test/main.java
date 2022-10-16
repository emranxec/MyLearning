package com.xec.myProject.test;

interface hasexo{
    abstract  int getNumber();
}

abstract class insect implements hasexo{
    abstract int getnumn();
}

abstract class Beetle extends insect{
 /*   int getNumber(int i){
          return i;
      }*/
 static {

 }

    static {

    }

    abstract int getnumn();


    public int getNumber(){
        return 0;
    }

}

public class main {

    public static void main(String[] args) {
        Beetle beetle= new Beetle() {
            @Override
            int getnumn() {
                return 0;
            }
        };
        System.out.println(beetle.getNumber());
    }
}
