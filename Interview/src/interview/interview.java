package interview;
import java.util.*;

public class interview {

    public static void main(String[] args) {
        List<Integer> l1 = new LinkedList<>(Arrays.asList(3, 2, 1));
        List<Integer> l2 = new LinkedList<>(Arrays.asList(1, 2, 1));
        //expected output =123+121=244= 4 4 2
        List<Integer> l3 = initThirdLL(l1, l2);
        // System.out.println(l3);
        // findSquareOfOddNumber();

        // Given an array of n integers and a number k, find the pairs of numbers in the array such
        // that the difference between the pair is k.


        int[] pairs = {7, 8, 9, 1, 2, 3, 4, 5, 6,};
        int k = 4;
        // findDifferenceBetweenPairs(pairs,k);

        //Write a function to return the longest even length word in a sentence.

        String sentence = "my name amanulla is, imran khan-";

        //  System.out.println(findLongest(sentence));
        //countNumberOfUniqueNumbers();

        System.out.println("------------");

  /*      String str = "khan";
        int n = str.length();
        permute(str, 0, n-1);*/

        String s = new String("5");
        System.out.println(1 + 10 + s + 1 + 10); //115110


    }


    private static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }





    private static void countNumberOfUniqueNumbers() {
        //	Write a function to count the number of unique digits in a number
        int num=111000;
        Set<Integer> digits=new HashSet<>();
        while(num>0){
            digits.add(num%10);
            num=num/10;
        }
        System.out.println(digits.size());
    }

    public static String findLongest(String sentence){

       // String[] subs=String.replaceAll(rejex(/a-z/A-Z),sentense).split(sentence," ");
        String[] subs=sentence.split("[^a-zA-Z0-9]");

        String longest="";
        for(String sub:subs){
            if(sub.length()%2==0 && sub.length()>longest.length()){
                longest=sub;
            }
        }
        return 	longest;

    }

    private static void findDifferenceBetweenPairs(int[] pairs, int k) {
        Map map=new HashMap();
        for(int i=0;i<pairs.length-1;i++){
            for(int j=1;j<pairs.length;j++){
                if(pairs[i]-pairs[j] == k){
                    map.put(pairs[i],pairs[j]);
                    break;
                }
            }
        }
        System.out.println(map);
    }

    private static void findSquareOfOddNumber() {
        //sum of the squares of all the odd numbers in the array.

        int[] num={1,2,3};

        // int sum= IntergerStream.of(num).filter(e->e%2==1).map(e->e*e).sum();
        int sum = 0;
        for(int i=0;i<num.length;i++){
            if(num[i]%2==1){
                sum +=num[i];
                }
             }
        System.out.println(sum);
    }


    private static List<Integer> initThirdLL(List<Integer> l1, List<Integer> l2) {
        List<Integer> l3=new LinkedList<>();
        for(int i=0;i<l1.size();i++){
            l3.add(l1.get(i)+l2.get(i));
        }
        return l3;
    }
}

// An immutable class Student
final class Student
{
    final String name;
    final int regNo;
    final List<String> courses;  // want to make Immutable

    public Student(String name, int regNo, List<String> courses)
    {
        this.name = name;
        this.regNo = regNo;
        this.courses = new ArrayList<>(courses);

    }
    public String getName()
    {
        return name;
    }
    public int getRegNo()
    {
        return regNo;
    }

    public List<String> getCourses() {
        return Collections.unmodifiableList(courses);
    }
}



