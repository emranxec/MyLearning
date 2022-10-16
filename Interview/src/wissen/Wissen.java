package wissen;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Wissen {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,24,-1,8,-3,0));
        List<Integer> clonedList = new ArrayList<>(numbers);
        for (Integer i: clonedList){
            if(i<0)
                numbers.remove(i);
        }
        System.out.println(numbers);

        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>(Arrays.asList(1,24,-1,8,-3,0));
        for (Integer i: copyOnWriteArrayList){
            if(i<1)
                copyOnWriteArrayList.remove(i);
        }
        System.out.println(copyOnWriteArrayList);

       /* Iterator iterator=copyOnWriteArrayList.iterator();
        while(iterator.hasNext()){
            if((int) iterator.next()<2){
                iterator.remove();
            }
        }
        System.out.println(copyOnWriteArrayList);*/


        List <String> names = new ArrayList <>();

        // Adding elements to the object of List class

        // Custom input entries
        names.add("Java");
        names.add("C++");
        names.add("Phython");
        names.add("JavaScript");

        List < String > first2Names = names.subList(0,1);

        System.out.println(names + " , " + first2Names);

        // Now we add another string to
        // get ConcurrentModificationException
        names.add("SQL");

        // This line throws an exception
//        System.out.println(names + " , " + first2Names);


        List<String> myList = new CopyOnWriteArrayList<>();

        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        Iterator<String> it = myList.iterator();
     /*   while (it.hasNext()) {
            String value = it.next();
            System.out.println("List Value:" + value);
            if (value.equals("3")){}
                myList.remove(value);
        }*/

        while (it.hasNext()) {
            String value = it.next();
            System.out.println("List Value:" + value);
            if (value.equals("3")) {
                myList.remove("4");
                myList.add("6");
                myList.add("7");
            }
        }

        Map<String, String> myMap = new ConcurrentHashMap<>();
        myMap.put("1", "1");
        myMap.put("2", "2");
        myMap.put("3", "3");

        Iterator<String> it1 = myMap.keySet().iterator();
        while (it1.hasNext()) {
            String key = it1.next();
            System.out.println("Map Value:" + myMap.get(key));
            if (key.equals("2")) {
                myMap.put("1", "4");
                myMap.put("3", "4");
                 myMap.put("4", "4");
            }
        }

    }

    }


