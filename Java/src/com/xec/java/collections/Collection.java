package com.xec.java.collections;

import java.util.*;
import java.util.stream.Collectors;


public class Collection {
    //Sort hashmap on basis of value.\
    public static void main(String[] args) {
        //sortByValue();
      //  findTriplet();
        HashMap map=new HashMap();
       // HashSet e= (HashSet) map.entrySet();
       // TreeMap treeMap=new TreeMap((Map) map.entrySet());

        Set<week> weekSet=EnumSet.of(week.MONDAY,week.TUESDAY,week.WEDNESDAY);
        Set<week> weekSet1=EnumSet.allOf(week.class);
        System.out.println(weekSet);
        System.out.println(weekSet1);
    }



    private static void findTriplet() {
        FindTriplet triplet = new FindTriplet();
        int A[] = { 0, 0, 0, 0, 0, 0 };
        int sum = 0;
        int arr_size = A.length;

        triplet.find3Numbers(A, arr_size, sum);
    }

    private static void sortByValue() {
        //Sort hashmap on basis of value.\
        Map<Integer,Integer> beforeSort=new HashMap();
        beforeSort.put(1,6);
        beforeSort.put(2,4);
        beforeSort.put(3,3);
        beforeSort.put(4,2);
        beforeSort.put(5,0);
        sortByValue(beforeSort);
    }

    private static void sortByValue(Map<Integer, Integer> beforeSort) {
        Map<Integer,Integer> afterSort= beforeSort.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e2, LinkedHashMap::new));
        System.out.println(afterSort);
    }
}

enum week{
    MONDAY,TUESDAY,WEDNESDAY
}

class FindTriplet {

    public void find3Numbers(int[] a, int arr_size, int sum) {

       /* int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        int arr_size = A.length;*/

        //{ 1, 4, 45, 6, 10, 8 }
        //{ 1, 4, 6, 10, 8 }
        //{ 10, 8, 6, 4,1}
        Arrays.sort(a);
        int finalSum=0;
        int count=0;
        int[] finalArray = new int[3];
        for(int i=arr_size-1;i>=0;i--){
           if(finalSum==sum){
                if(count<3){
                    finalSum-=a[i+1];
                    count--;
                }
               if(finalSum==sum) {
                   System.out.println(finalArray[0]+","+finalArray[1]+","+finalArray[2]);
                   return;
               }
            }
            if(finalSum+a[i]>sum){
                continue;
            }
            finalSum+=a[i];
            finalArray[count]=a[i];
            count++;
        }
        if(finalSum!=sum){
            System.out.println("no match found");
        }else{
            System.out.println(finalArray[0]+","+finalArray[1]+","+finalArray[2]);
        }
    }



}


// Java Program to Demonstrate Different Return Types
// if Return Type in Overridden method is Sub-type

// Class 1
class A {
}

// Class 2
class B extends A {
}

// Class 3
// Helper class (Base class)
class Base {

    Base(){
        System.out.println("const base");
    }
    // Method of this class of class1 return type
    Base fun(A a)
    {
        // Display message only
        System.out.println("Base fun()");

        return this;
    }

}

// Class 4
// Helper class extending above class
class Derived extends Base {

    Derived(){
        System.out.println("const Derived");
    }
    // Method of this class of class1 return type
    Derived fun(B b)
    {
        // Display message only
        System.out.println("Derived fun()");

        return this;
    }
}

// Class 5
// Main class
class GFG {

    // Main driver method
    public static void main(String[] args)
    {

        // Creating object of class3 type
        Base base = new Base();

        // Calling method fun() over this object
        // inside main() method
        base.fun(new A());
        base.fun(new B());

        System.out.println("--------");

        // Creating object of class4 type
        Derived derived = new Derived();

        // Again calling method fun() over this object
        // inside main() method
        derived.fun(new A());
        derived.fun(new B());


        System.out.println("--------");


        Base base1 = new Derived();
        base1.fun(new A());
        base1.fun(new B());

    }
}
