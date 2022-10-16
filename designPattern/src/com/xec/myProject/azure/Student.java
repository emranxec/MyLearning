package com.xec.myProject.azure;


public class Student implements Obeserver {
    String name;
    String membership;
    AzureCertificationCoursesInterface azureCertificationCourses=new AzureCertificationCoursesInterface();

    public Student(String name, String membership) {
        this.name = name;
        this.membership=membership;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    @Override
    public void update(String courseName, int price){
        System.out.println("Hi "+ name +", new course "+ courseName +" added in "+ azureCertificationCourses.cloudName +" with price starting from " +price);
    }

    @Override
    public void subscribeChannel(AzureCertificationCoursesInterface azureCertificationCourses){
        this.azureCertificationCourses=azureCertificationCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", membership='" + membership + '\'' +
                '}';
    }
}
