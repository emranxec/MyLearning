package eight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class eight implements I,J{
    @Override
    public void show() {
        System.out.println("eight");
    }
}

interface I{
    default void show(){
        System.out.println("I");
    }
}

interface J{
    default void show(){
        System.out.println("J");
    }

    static void hello(){
        System.out.println("hello");
    }
}

class newOne extends eight implements J{
    @Override
    public void show() {
        super.show();
    }

    public static void main(String[] args) {
        newOne one=new newOne();
        one.show();
        J.hello();

        List<String> mylist= new ArrayList<>();
        mylist.add("imran");
        mylist.add("salman");
        Stream s= mylist.stream();
        s.forEach(a-> System.out.println(a));
        s.forEach(a-> System.out.println(a));
    }
}

