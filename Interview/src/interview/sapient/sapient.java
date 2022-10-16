package interview.sapient;

import java.util.*;
import java.util.stream.Collectors;

public class sapient {

}
    // package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3


class MyCode {
    public static void main (String[] args) {
       /* System.out.println("Hello Java");
        String thrusday = "Thursday";

        for(enum a:enumType){
            if(a==Thursday){
                System.out.print("present"));
            }
        }*/

    }
}





    class BaseService {}
    class ChildService extends BaseService {}

    class Base {
        public void display(BaseService service) {
            System.out.println("In Base");
        }
    }

    class Child extends Base {
        public void display(ChildService service) {
            System.out.println("In Child");
        }
    }
    class CompileTime {
        public static void main(String[] args) {
            Base base = new Child();
             base.display(new ChildService());// in child

            Child child = new Child();
            child.display(new BaseService());// in

            String s="Saturday";
            enumType.values();

            for(enumType a:enumType.values()){
                if(a.name().equalsIgnoreCase("Monday")){
                    System.out.print("present");
                }
            }

            for(enumType a:enumType.values()){
                if(a.name()=="Thursday"){
                    System.out.print("present");
                }
            }

        }
    }

enum enumType{
    Monday,Tuesday,Wednesday
};


    class Employee {
        private String name;
        public Employee(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(name, employee.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
    class Address {
        private String streetName;
        public Address(String streetName) {
            this.streetName = streetName;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "streetName='" + streetName + '\'' +
                    '}';
        }
    }
     class Collections {
        public static void main(String[] args) {
            Map<Employee, List<Address>> hashMap = new HashMap<>();

            Employee employee=new Employee("A");
            hashMap.put(new Employee("A"),
                    Arrays.asList(new Address("St1"), new Address("St2")));

            hashMap.put(new Employee("A"),
                    Arrays.asList(new Address("St3"), new Address("St4")));
            System.out.println(hashMap.size());//1(kopal),2(sridharan)
            List<Address> address = hashMap.get(new Employee("A"));
            System.out.println(address);// //st3,st4(kopal), empty(sriharan)

            List<Employee> emplist = new ArrayList<>();//100
            emplist.add(new Employee("imran"));
            emplist.add(new Employee("imran"));
            emplist.add(new Employee("kopal"));
            emplist.add(new Employee("Sridharan"));
            emplist.add(new Employee("Sridharan"));

            Map<String,List<Employee>> map=emplist.stream().collect(Collectors.groupingBy(Employee:: getName));


            System.out.println(map);

            ListIterator iterator=emplist.listIterator();

            while (iterator.hasNext()){
                Employee e= (Employee) iterator.next();
                iterator.add(e);
            }
          //  System.out.println(emplist);


            //Employee --id, name, dept, salary
           // List<Employee> emplist = new ArrayList<>();
//1. get only employee having dept = "IT"

        }
    }



   /* ArrayList

    get -- O(1)
    add -- O(1)
    remove -- O(n)
    contain --O(n)

    Employee --id, name, dept, salary
    List<Employee> emplist = new ArrayList<>();//100

    // Iterator
    Iterator<Employee> it = emplist.iterator();//hasNext, next, remove
    dept = "IT" modifying the salary increase 5%
            1. there is no issue in this operation--
            2. there is exception in this operation--

    dept = "IT" remove that employee from iterator
//==================JAVA 8============
    Employee --id, name, dept, salary
    List<Employee> emplist = new ArrayList<>();
//1. get only employee having dept = "IT"

emplist.steam().flatMap(e->e.department).filter(d->d.getName.equals("IT")).collect(Colleaction.tolist());

2. Convert in map key--id, value--Employee

emplist.stream().collect(groupingBy(e->e.id,e)Collect(Collectors.toMap()));


    Map<Integer,Emplyee> empMap= new Hashmap<>();
for(Employee e:emplist){
        empMap.put(e.id,e);
    }


3. Employee count based on depart
"IT", 25
"Civil", 39

        emplist.stream().collect(mapping(e->e.department).groupingby(e->e.department),count()).collect(Collectors.toMap());

// Database
    Employee-- id, name, mgid
            id, name, mgid
            1.  Alok  3
            2   Niraj 3
            3   Saurya 4
            4   Siva   5

    name , mgname
    Alok  Saurya
    Niraj Saurya,
    Saurya Siva

    select emp.name,man.name from Employee emp
    join Employee man on emp.madid=man.id;


    Employee --id, name, dept, salary
    Employee count based on depart

"Civil", 39
        "IT", 25

    select emp.dept,count(emp.name) from Employee emp
    group by emp.dept;

    //JPA Mapping
    @Entity
    @Table(name ="employee")
    class Employee//1:1
    private String id;

    @Entity
    @Table(name ="department")
    class Department//1:M
    private String id
    */













