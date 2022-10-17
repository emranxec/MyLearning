package com.xec.java.exception;

import java.util.*;
import java.util.stream.Collectors;

public class Exceptions {
    public static void main(String[] args) {

       /* List<String> myList=new ArrayList<>();
        try{
            String s=null;
            s.length();
        }catch (NullPointerException e){
            throw e;
        }*/


    //list,0,1,2,3,4,5,6,7,8,9
       // System.out.println(reverseMeBuddy("qwertyujikjhgfdcvbnmjhgvnjgfvbnmkjgfvbnmkjhgvnmjhgvbnmjhgv mjhvsjdfsdfjnsdjkfnjksdfnkjsdnfkjsdjfnsdkjfnskjdfnkjsfnkjsdklfnblksdbflksbdlkfj"));
       // System.out.println(reverseMeBuddyInBetterWay("qwertyujikjhgfdcvbnmjhgvnjgfvbnmkjgfvbnmkjhgvnmjhgvbnmjhgv mjhvsjdfsdfjnsdjkfnjksdfnkjsdnfkjsdjfnsdkjfnskjdfnkjsfnkjsdklfnblksdbflksbdlkfj"));
        System.out.println(maxTimesRepeated("VIPs are statically allocated in parameter files.\n" +
                "\n" +
                "The downside to this method is it is very easy to accidentally re-use an existing hostname and this will break the existing server when it attempts to domain join; it is also easy to fragment the address space when redeploying groups of servers with changing numbers of servers in the group since the space needs to be contiguous. c1`\n" +
                "\n" +
                "To make allocating new NPE JBOSS IP addresses easy in a /24 subnet allocate IPs in these ranges: "));
    }

//String : Imran
    static String reverseMeBuddy(String original){
        char[] myArray= original.toCharArray();
        for(int i=0,j=original.length()-1;i<j;j--,i++){
            System.out.println("calling these many times");
            char temp=myArray[i];
            myArray[i]=myArray[j];
            myArray[j]=temp;
        }
    return String.valueOf(myArray);
    }

    static String reverseMeBuddyInBetterWay(String original){
        char[] myArray= original.toCharArray();
        String empty = "";
       for(int i=0;i<original.length();i++){
           System.out.println("calling these many times in better way");
           empty=myArray[i]+empty;
       }
       return empty;
    }

    static String reverseMeBuddyusingBuilder(String original){
       return String.valueOf(new StringBuilder(original).reverse());
    }

    static ArrayList maxTimesRepeated(String s){
        String[] allElements= s.split(" ");
        Map<String,Integer> myMap=new HashMap();

        for(String s2:allElements){
            if(myMap.containsKey(s2)){
               myMap.put(s2,myMap.get(s2)+1);
            }else{
                myMap.put(s2,1);
            }
        }




       ArrayList list= (ArrayList) myMap.entrySet()
               .stream()
               .sorted(Exceptions::compare).limit(5)
                .collect(Collectors.toList());
        return list;
    }

    private static int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> v) {
        return v.getValue().compareTo(a.getValue());
    }

    static void fibbonacci(int total){
        //0
    }
}
