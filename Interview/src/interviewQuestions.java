import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class interviewQuestions {

    public static void main(String[] args) {

        //1. how to create a immutable class
        immmutableClass immmutableClass=new immmutableClass("imran");

        //2. what is sequential & paralle streams
        parralelvsSequencial();

        //3. remove duplicate using streams
        distictJava8();




    }

    private static void distictJava8() {
        List<Integer> myUniqueNumbers=new ArrayList<>();
        myUniqueNumbers.add(1);
        myUniqueNumbers.add(1);
        myUniqueNumbers.add(2);
        myUniqueNumbers.add(3);
        myUniqueNumbers.add(1);
        myUniqueNumbers.stream().distinct().forEach(a-> System.out.println(a));
    }

    private static void parralelvsSequencial() {
        String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

        System.out.println("-------\nRunning sequential\n-------");
        run(Arrays.stream(strings).sequential());
        System.out.println("-------\nRunning parallel\n-------");
        run(Arrays.stream(strings).parallel());
    }

    public static void run (Stream<String> stream) {

        stream.forEach(s -> {
            System.out.println(LocalTime.now() + " - value: " + s +
                    " - thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}

final class immmutableClass{
    final private String name;

    immmutableClass(String name){
        this.name=name;
    }
    String getName(){
        return name;
    }
}
