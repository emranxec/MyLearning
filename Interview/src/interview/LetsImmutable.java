package interview;

/*

Do not provide any setters
Mark all fields as private
Make the class final

We will declare class as final and all the fields as private final.
        We will provide one parameterized constructor and getter methods.
        We will not provide any setter method, so that field values can not be changed after object creation.*/


/*Advantages of immutable objects:

        An immutable object remains in exactly one state, the state in which it was created.
        Therefore, immutable object is thread-safe so there is no synchronization issue.
        They cannot be corrupted by multiple threads accessing them concurrently.
        This is far and away the easiest approach to achieving thread safety.
        Immutable classes are easier to design, implement, and use than mutable classes.
        Immutable objects are good Map keys and Set elements, since these typically do not change once created.
        Immutability makes it easier to write, use and reason about the code
        (class invariant is established once and then unchanged).
        Immutability makes it easier to parallelize program as there are no conflicts among objects.
        The internal state of program will be consistent even if you have exceptions.
        References to immutable objects can be cached as they are not going to change.
        (i.e. in Hashing it provide fast operations).

 Disadvantages of immutable objects:
        The only real disadvantage of immutable classes is that they require a separate object for each distinct value.*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LetsImmutable {


    public static void main(String[] args) {
        List<String> newDegrees= new ArrayList<String>();
        newDegrees.add("english");
        Address address=new Address("goa1","goa2");
        Person p=new Person("imran",21,newDegrees,address);
        System.out.println(p.getName());
        System.out.println(p.getAge());
        System.out.println(p.getDegrees());
        List<String> personDegrees=p.getDegrees();
        personDegrees.add("fake");
        System.out.println(p.getDegrees());


    }
}

final class Person implements Serializable {
    private final String name;
    final private int age;
    private final List<String> degrees;
    private Address address;

    Person(String name,int age, List<String> degrees,Address address){
        super();
        this.name=name;
        this.age=age;
        List<String> newDegrees= new ArrayList<String>();
        for(String degree:degrees){
            newDegrees.add(degree);
        }
        this.degrees=newDegrees;
        this.address=address;
        //this line prevent it form serialization and reflection
        System.setSecurityManager(new SecurityManager());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getDegrees() {

       /* List<String> newDegrees= new ArrayList<String>();
        for(String degree:degrees){
            newDegrees.add(degree);
        }
        return newDegrees;*/

        return (ArrayList<String>) Collections.unmodifiableCollection(degrees);

    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
/*        clone() method only works if Address has implemented Cloneable interface.
        If it has not implemented it, then we have to manually deep copy all the fields of Address class.
        But most of the user library has support for Cloneable and Serializable interfaces*/
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", degrees=" + degrees +
                ", address=" + address +
                '}';
    }
}

class Address implements Cloneable{
    private String address1;
    private String address2;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public Address(String address1, String address2) {
        this.address1 = address1;
        this.address2 = address2;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class ChildAddress extends Address{
/*    Is there any problem with this approach?

    Well yes. what if some of the reference variables inside Address class is also Mutable Objects.
    In that case we need to override their  setter methods as well.
    This approch becomes more complex when there are many nested Mutable class references.*/

    public ChildAddress(String address1, String address2) {
        super(address1, address2);
    }

    public void setAddress1(String address1) {
        throw new UnsupportedOperationException();    }

    public void setAddress2(String address2) {
        throw new UnsupportedOperationException();    }
}
