package com.xec.JavaEight.company;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsAPI {

    public static void main(String[] args) {
	// write your code here
        //iterationJava8();

        //filter=predicate ->return boolean
        //reduce=BinaryOperator->data(terminal)
        //Map=function ->stream
        //foreach=consumer->data(terminal)

        explanationToStreamMethod();




    }

    static boolean isDivisible(int integer){
        System.out.println("processing isDivisible"+ integer);
        return integer%5==0;
    }

    static int mapDouble(int integer){
        System.out.println("processing mapDouble"+ integer);
        return integer*2;
    }

    private static void explanationToStreamMethod() {
        List<Integer> integers= Arrays.asList(6,15,2,30,7);

        System.out.println(integers.stream().map(i->i*2).reduce(0,(c,e)->c+e));
        System.out.println(integers.stream().limit(1).map(i->i*2).reduce(0,Integer::sum));
        System.out.println(integers.stream().filter(integer -> integer%5==0).map(integer -> integer*2).reduce(0,(c,e)->c+e));
        System.out.println(integers.stream().findAny().orElse(0));

        Function<String,String> reverseString=new Function<String,String>() {
            @Override
            public String apply(String s) {
                return new StringBuilder(s).reverse().toString();
            }
        };

        String newString = reverseString.apply("imran");
        System.out.println("reverse is :" + newString);




        //todo stream to multiply & print sum
        //System.out.println(integers.stream().map(i->i*2).reduce(0,(c,e)->c+e));//c->carry,e->element
        //System.out.println(integers.stream().map(i->i*2).reduce(0,Integer::sum));//c->carry,e->element
      //  System.out.println(integers.stream().filter(StreamsAPI::isDivisible).map(StreamsAPI::mapDouble).reduce(0,(c, e)->c+e));

       // System.out.println("find first");
        //System.out.println(integers.stream().filter(StreamsAPI::isDivisible).map(StreamsAPI::mapDouble).findFirst().orElse(0));

        //todo explanantion


        Predicate<Integer> filterMe=new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return isDivisible(integer);
            }
        };
        Function<Integer,Integer> mappingFunction=new Function<Integer,Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return mapDouble(integer);
            }
        };
        BinaryOperator<Integer> reduceFunction =new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer c, Integer e) {
                return c+e;
            }
        };



        Stream stream=integers.stream();
        Stream stream0=stream.filter(filterMe);
        Stream stream1=stream0.map(mappingFunction);
        Integer value= (Integer) stream1.reduce(0,reduceFunction);





        System.out.println(value);

        //System.out.println(integers.stream().filter(filterMe).map(integer -> integer*2).reduce(0,(c,e)->c+e));
        //System.out.println(integers.stream().filter(filterMe).map(integer -> integer*2).findAny().orElse(0));
    }

    private static void iterationJava8() {
        List<Integer> integers= Arrays.asList(1,2,3);

        Iterator<Integer> integerIterator= integers.iterator();

        System.out.println("external iteration----start");
        System.out.println("iterator");
        while (integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }
        System.out.println("for loop");
        for(int i:integers){
            System.out.println(i);
        }
        System.out.println("external iteration----end");

        System.out.println("internal iteration----start");
        System.out.println("for each");

        integers.forEach(i-> System.out.println(i));

        System.out.println("consumer");

        //convert from here-start
        //level=0
        Consumer<Integer> consumer=new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        };
        integers.forEach(consumer);
        //till-here


        //convert from here-start
        //level=1
        Consumer<Integer> consumer1=(Integer i)-> System.out.println(i);
        integers.forEach(consumer1);
        //till-here

        //convert from here-start
        //level=2
        Consumer<Integer> consumer2=i-> System.out.println(i);
        integers.forEach(consumer2);
        //till-here

        //convert from here-start
        //level=3
        integers.forEach(i-> System.out.println(i));
        //till-here

        //method reference
        System.out.println("method referance");
        integers.forEach(System.out::println);
    }
}
