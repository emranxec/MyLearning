package com.xec.java.string;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class StringXecUtills {

    public static void main(String[] args) {
        //stringJoin();

        //findLongestinString("imran -is--- good");

        //pairs();

        //getCharCountArray("IIIII");


       // reverseList();

        LinkedList<String> myList=new LinkedList<>();
        myList.add("imran");
        myList.add("imran");
        myList.add("Amir");
        myList.add("Amir");
        myList.add("Basha");
     //   myList.stream().sorted().unordered().forEach(a-> System.out.println(a));
       // sortTheStringByCountAndAssending(myList);

        String s1="hello world";
        String s2="eholw odlhr";

        //System.out.println(checkIfTwoStringsEqual(s1,s2));


        checkIfEvenElseReturnMiddleValue("aa1aa");

     /*   108 legs
        33 heads*/
        //chicken -2,1
        //rabit   -4,1
        //legs =96
        //legs =
        //84/4=21
        //24/2=12
        int legs=108;
        int heads=33;
        findLegsAndHeads(legs,heads);

        //1,000,000
        //100,000
        separateThousand(10000000);
        separateBetterWayThousand(10000000);
        separateEasyWayThousand(10000000);

        int value=3;
        int myArray[]={1,2,3,5};
        int myArray1[]={1,2,3,4};

        findXOR(value,myArray,myArray1);

        String helllo="Hello";

        checkNextRepeatedElement(helllo);
    }

    private static void checkNextRepeatedElement(String helllo) {
        char c[]=helllo.toCharArray();
        char repeated='\u0000';
        for(char c1:c){
            if(repeated==c1){
                System.out.println(true);
                return;
            }
            repeated=c1;
        }
    }

    private static void findXOR(int value, int[] myArray, int[] myArray1) {
        boolean isPresentInOne=false;
        boolean isPresentInTwo=false;
        for(int i:myArray){
            if(i==value){
                isPresentInOne=true;
            }
        }
        for(int i:myArray1){
            if(i==value){
                isPresentInTwo=true;
            }
        }
        System.out.println(
                isPresentInOne?isPresentInTwo?"false":"true":isPresentInTwo?isPresentInOne?"false":"true":"false");
    }

    private static void separateEasyWayThousand(int i) {
        System.out.println(String.format("%,d\n", i));
    }

    private static void separateBetterWayThousand(int i) {
        DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();

        symbols.setGroupingSeparator(',');
        formatter.setDecimalFormatSymbols(symbols);
        System.out.println(formatter.format(i));
    }

    private static void separateThousand(int input) {
        char[] s1=String.valueOf(input).toCharArray();
        StringBuilder sb1=new StringBuilder();
        int count=0;
        for(int i=s1.length-1;i>=0;i--){
            if(count==3){
                sb1.append(",");
                count=0;
            }
            sb1.append(s1[i]);
            count++;
        }
        System.out.println(sb1.reverse());
    }



    private static void findLegsAndHeads(int legs, int heads) {

    }

    private static void checkIfEvenElseReturnMiddleValue(String s1) {
        if(s1.length()%2==0){
            System.out.println("even number");
            return;
        }else {
            //3->2,5->3  //imran
            int median=(s1.length()/2);
            System.out.println(median);
            char[] c=s1.toCharArray();
            System.out.println(c[median]);
        }

    }

    static boolean checkIfTwoStringsEqual(String s1,String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        HashSet h=new HashSet();
        for(char c:s1.toCharArray()){
            h.add(c);
        }
        for(char c:s2.toCharArray()){
            if(!h.contains(c)){
                return false;
            }
        }
        return true;
    }

    private static void reverseList() {
        List<Integer> number = new ArrayList<>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));

        System.out.println(
                "Reverse order of given List :- ");


        for(int i=0,j=number.size()-1;i<j;i++){
            number.add(i,number.remove(j));
        }

        System.out.println(number);
    }

    private static void sortTheStringByCountAndAssending(LinkedList<String> myList) {
        Map<String, Integer> newHashMap = new LinkedHashMap<>();
        Collections.sort(myList);
        for (String name : myList) {
            if (newHashMap.containsKey(name)) {
                newHashMap.put(name, newHashMap.get(name) + 1);
            } else {
                newHashMap.put(name, 1);
            }
        }


        HashMap<String, Integer> temp = newHashMap.entrySet()
                .stream()
                .sorted(comparing(Map.Entry::getValue))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println(temp);


    }
        private static void pairs() {
        int k=4;
        int[] pairs={7,8,9,1,2,3,4,5,6,}; //k=4
        //{1,2,3,4,5,6,7,8,9}
        int count = 0;
        Arrays.sort(pairs); // Sort array elements

        int l = 0;
        int r = 0;
        while(r < pairs.length){
            if(pairs[r]-pairs[l]==k){
                count++;
                l++;
                r++;
            }else if(pairs[r]-pairs[l]>k){
                l++;
            }else {
                r++;
            }

        }
        System.out.println(count);
    }

    static final int NO_OF_CHARS = 256;
    static char count[] = new char[NO_OF_CHARS];

    /* calculate count of characters
       in the passed string */
    static void getCharCountArray(String str)
    {
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;

        System.out.println(count);
    }


    private static void findLongestinString(String imran_is_good) {
        System.out.println(
                Arrays.asList(imran_is_good.split("(\\s)+"))
                        .stream()
                .filter(s->s.length()%2==0)
                .map(s->s.replaceAll("[^a-zA-Z0-9]", ""))
                .max(comparing(String::length)).get().length());

    }

    private static void stringJoin() {
        String s1="Citibank" ;
        String s2="Bank of America";
        String s3="Chase";

        String s4=s1+s2+s3;
        System.out.println(s4);

        String s5=String.join("",s1,s2,s3);
        System.out.println(s5);

        List<String> L1= Arrays.asList(s1,s2,s3);
        String s6=String.join("",L1);
        System.out.println(s6);

        String[] l2={s1,s2,s3};
        String s7=String.join("",l2);
        System.out.println(s7);
    }

}
