package wissen;

public class designClass {


//Design a class such that only one instance of the class and any of its sub-classes can be created.
// To clarify: Assume A is such a class and B is derived from A.
// B does not have any special code apart from extending A
// new A(); // works fine.
// new A(); // causes an exception
// new B(); // works fine as this is the first instance of B
// new B(); // causes an exception
public static void main(String[] args) {

    A a=new A();
    //A a1=new A();
    //A ab1=new B();
    //A ab2=new B();
    A b1=new B();
    //A b2=new B();
}


}

class A{
    static int ONE_OBJECT;
    static boolean is_reset=false;
    A(){
        if(ONE_OBJECT>0 && !is_reset){
            throw new RuntimeException("class already created BOSS!!");
        }
        if(!is_reset){
            System.out.println("created A");
        }
        ONE_OBJECT++;
    }

    static void reset(){
        is_reset=true;
    }
}

class B extends A{
    static int ONE_OBJECT_B;
    static{
        reset();
    }
    B(){
        if(ONE_OBJECT_B>0){
            throw new RuntimeException("class already created BOSS!!");
        }
        System.out.println("created B");
        ONE_OBJECT_B++;
    }
}
