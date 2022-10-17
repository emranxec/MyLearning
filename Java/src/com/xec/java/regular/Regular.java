package com.xec.java.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regular {

    public static void main(String[] args) {


        String string="I am a String. Yes, I am!!";
        System.out.println(string);
        String yourString=string.replaceAll("I","You");
        System.out.println(yourString);
        String alpha="abdcd123 abcd123 ABCDD\t123 ABCD14abcd123 abc\nd123 ";
        System.out.println(alpha.replaceAll(".","Y"));
        System.out.println(alpha.replaceAll("^as","YY"));
        System.out.println(alpha.matches("^as"));
        System.out.println(alpha.matches("^asdasddeasdasd"));
        System.out.println(alpha.replaceAll("asd$","The ENd"));
        System.out.println(alpha.replaceAll("[da]","XX"));
        System.out.println(alpha.replaceAll("[de][a]","XX"));

        System.out.println(alpha.replaceAll("[^s]","z"));

        System.out.println(alpha.replaceAll("[a-dA-D1-3]","X"));
        System.out.println(alpha.replaceAll("(?i)[a-d1-3]","X"));//also replace capitals
        System.out.println(alpha.replaceAll("[0-9]","X"));//repalce range
        System.out.println(alpha.replaceAll("\\d","X"));//replcae digit
        System.out.println(alpha.replaceAll("\\D","X"));//replace other than digit
        System.out.println("----"+alpha);
        System.out.println(alpha.replaceAll("\\s",""));//replace  space
        System.out.println(alpha.replaceAll("\\t","X"));//replace  tab and spaces
        System.out.println(alpha.replaceAll("\\S","X"));//replace others than space
        System.out.println(alpha.replaceAll("\\w","X"));//replace others than space
        System.out.println(alpha.replaceAll("\\W","X")); //replace space
        System.out.println(alpha.replaceAll("\\b","<>")); //add to start and end of words

        String alpha2="abcdd123abcdd123abcdd123abcdd123abcdd123";
        System.out.println("------\n" + alpha2);
        System.out.println(alpha2.replaceAll("^abcd{3}","X")); //quontifier :: check d with 3iterations
        System.out.println(alpha2.replaceAll("^abcd+","X")); //quontifier :: check d with any iterations
        System.out.println(alpha2.replaceAll("^abcd*","X")); //quontifier :: replace abcd even if d is exist or not
        System.out.println(alpha2.replaceAll("^abcd{2,5}","X")); //quontifier :: replace abcd when D occurs 2-5 times
        System.out.println(alpha2.replaceAll("c+d*1","Y")); //quontifier :: more than one c , any number od d and ends with 1

        System.out.println("Imran".replaceAll("[Ii]mran","Emran"));

        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("sapiensTechnology:I am imran khan from Goa and working in sapiensTechnology bangalore and working in sapiensTechnology");

        String myPattern="sapiens";
        Pattern pattern=Pattern.compile(myPattern);
        Matcher matcher=pattern.matcher(stringBuilder);
        System.out.println(matcher.matches());
        int counter=0;
        matcher.reset();
        while(matcher.find()){
            counter++;
            System.out.println("occ :" + counter);
            System.out.println("start :" + matcher.start() +"end :" + matcher.end()  );
        }

        System.out.println("group match-----");

        String myGroupPattern="(sapiens)";
        Pattern groupPattern=Pattern.compile(myGroupPattern);
        Matcher Gmatcher=groupPattern.matcher(stringBuilder);
        System.out.println(Gmatcher.matches());
        Gmatcher.reset();
        while(Gmatcher.find()){
            System.out.println("start :" + matcher.group());
        }

    }
}
