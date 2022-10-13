package com.xec.single.src.Com.xec.azure;

public interface Obeserver {
    void update(String courseName, int price);

    void subscribeChannel(AzureCertificationCoursesInterface azureCertificationCourses);

    String getMembership();

    String getName();


}
