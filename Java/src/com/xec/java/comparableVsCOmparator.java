package com.xec.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class comparableVsCOmparator {

    public static void main(String[] args) {
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee(1,"imran",21));
        employeeList.add(new Employee(2,"salman",11));
        employeeList.add(new Employee(3,"ibrahim",41));
        employeeList.add(new Employee(4,"imtiaz",31));
        System.out.println(employeeList);
        Collections.sort(employeeList);
        System.out.println(employeeList);
        CompareByName compareByName=new CompareByName();
        employeeList.sort(compareByName);
        System.out.println(employeeList);
        CompareByAge compareByAge=new CompareByAge();
        employeeList.sort(compareByAge);
        System.out.println(employeeList);
    }
}

class CompareByName implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
       return e1.getName().compareTo(e2.getName());
    }
}

class CompareByAge implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
        if(e1.getAge()>e2.getAge()){
            return 1;
        }
        if(e1.getAge()<e2.getAge()){
            return -1;
        }
        return 0;
    }
}


class Employee implements Comparable<Employee>{
    int id;
    String name;
    int age;

    public Employee(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Employee e) {
        return this.age-e.age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}