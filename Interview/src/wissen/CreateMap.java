package wissen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class CreateMap {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("goa", 1);
        hashMap.put("karnataka", 2);

        userDefinedMap userDefinedMap = new userDefinedMap();
        userDefinedMap.put("imran", 1);
        userDefinedMap.putAll(hashMap);
        userDefinedMap.putIfAbsent("imran", 2);
        userDefinedMap.putIfAbsent("salman", 0);

        System.out.println(userDefinedMap.getCounter());

/*
        new Thread(() -> System.out.println("New thread created")).start();

        int a = 5;

        // lambda expression to define the calculate method
        Square s = (int x) -> x * x;
        String firstN = "imran";
        String secondN = "khan";
        FindSomerandomName findSomerandomName = (String first, String concat) -> first = first.concat(concat);
        FindSomerandomName.danceAgain();
        findSomerandomName.dance();
        String ans1 = findSomerandomName.find(firstN, secondN);
        System.out.println(ans1);
*/





        List<String> names = Arrays.asList(
                "Geek", "GeeksQuiz", "g1", "QA", "Geek2");

        // declare the predicate type as string and use
        // lambda expression to create object
        Predicate<String> p = (s) -> s.startsWith("G");

        // Iterate through the list
        for (String st : names) {
            // call the test method
            if (p.test(st))
                System.out.println(st);
        }

/*
    Design a new implementation of the Map interface which will also keep a count of all the calls
        to add a key value pair in the Map. It should count the calls to put, putAll and putIfAbsent methods.
    The implementation should also be able to provide all the features of any Map implementation that user wants.
        (e.g. HashMap, TreeMap etc)
*/


    }
}

    class userDefinedMap<K, V> {
        HashMap hashMap = new HashMap();
        HashMap counter = new HashMap();

        Map getCounter() {
            return counter;
        }

        userDefinedMap() {
            counter.put("put", 0);
            counter.put("putAll", 0);
            counter.put("putIfAbsent", 0);
        }

        Object put(K key, V value) {
            int count = (int) counter.get("put");
            counter.put("put", count + 1);
            return hashMap.put(key, value);
        }

        void putAll(Map map) {
            int count = (int) counter.get("putAll");
            counter.put("putAll", count + 1);
            hashMap.putAll(map);
        }

        public Object putIfAbsent(K key, V value) {
            int count = (int) counter.get("putIfAbsent");
            counter.put("putIfAbsent", count + 1);
            return hashMap.putIfAbsent(key, value);
        }
    }

    @FunctionalInterface
    interface Square {
        int calculate(int x);
    }

    @FunctionalInterface
    interface FindSomerandomName {
        String find(String firstName, String concat);

        static void danceAgain() {
            System.out.println("dancing");
        }

        default void dance() {
            FindSomerandomName.danceAgain();
            System.out.println("dancing again");
        }
    }

